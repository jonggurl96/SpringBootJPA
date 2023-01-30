# SpringBootJPA
- Java 17
- Spring Boot 3.0.2
- Spring web
- JPA
- H2DB
- Lombok
- Maven

# @SpringBootApplication
- @ComponentScan - 해당 패키지와 하위 패키지의 Bean 등록
    - @Configuration, @Controller, @Service 등...
    - 해당 Bean들은 @Autowired를 사용하지 않고 *@RequiredArgsConstructor*로 한 번에 Bean 등록
- @EnableAutoConfiguration
    - 포함된 jar 파일들 하위의 spring.factories 파일을 읽어 Bean 등록
- @SpringConfiguration

# src/main 하위 구조
```
webapp/WEB-INF/views/*.jsp
static: html, css, js, img 등의 정적 자원
templates: View Template
application.properties: 설정 파일
```

# application.properties
```
# JPA 설정

## Dialect 설정
### Habernate으로 사용할 H2DB 설정
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.H2Dialect

## Hibernate가 실행하는 모든 query를 콘솔로 출력
spring.jpa.properties.hibernate.show_sql = true

## 디버깅용 sql문 이외에 추가적인 정보를 출력
spring.jpa.properties.hibernate.use_sql_comments = true


# H2DB JDBC 연결 - h2w 실행하여 복붙 가능
spring.datasource.url = jdbc:h2:tcp://localhost/~/test
spring.datasource.driver-class-name = org.h2.Driver
spring.datasource.username = test
spring.datasource.password = test

# 테이블이 존재하지 않는다면 자동 생성
spring.jpa.hibernate.ddl-auto=create

# server port
server.port=8081
```

# Entity 객체 - Book
```
@Entity // entity 명시
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder // @NoArgsConstructor와 함께 사용하는 경우 @AllArgsConstructor 반드시 사용
@Table(name = "tbl_book") // DB 테이블과 이름이 다를 때 사용, 생략 가능
@SequenceGenerator( // id seq 정의
    name = "BOOKSEQ", // Java에서 사용할 이름
    sequenceName = "BOOK_SEQ", // DB 상에 정의된 Sequence 이름
    initialValue = 1, // 초기값
    allocationSize = 1 // 1개씩 DB에서 읽어와 적용
)
public class Book {
    @Id // PK 명시
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKSEQ")
    private long id;

    @Column(name = "title", nullable = false, columnDefinition = "varchar(255) default 'EMPTY'") // 속성 생략 가능
    private String title;
}
```
### @Builder의 경우 내부적으로 AllArgs 생성자에 setter를 적용하기 때문에 @NoArgsConstructor만 적용할 경우 에러
무분별한 생성을 막기 위해 @Setter와 new Entity()는 지양하고 아래와 같이 사용
```
/** Book book = BookBuilder.build() */
Book book = Book.builder().title("title").build();
```
### GenerationType
- @GeneratedValue(strategy = GenerationType.AUTO): default(JPA 구현체가 생성 방식을 결정)
- @GeneratedValue(strategy = GenerationType.IDENTITY): auto_increment를 지원하는 MySql 등에서 사용
- @GeneratedValue(strategy = GenerationType.TABLE, generator = TABLEGENERATOR)
- @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCEGENERATOR): auto_increment를 지원하지 않는 Oracle 등에서 사용
    - DB에 sequence가 생성된 상태여야 사용 가능

### 컬럼명 camelCase로 바꾸기
```
application.properties
jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

# Repository<T, ID>
- T: Entity type
- ID: Entity 객체의 id 타입 = Serializable 객체, premitive type 사용 불가능 (long = Long)

```
public interface **Repository extends Repository<T, ID> {
    /** Repository interface는 메소드가 없음 */
    /** 원하는 메소드를 직접 규칙에 맞게 작성해야 함 */
}
```

### CrudRepository<T, ID> extends Repository<T, ID> - @NoRepositoryBean
```
/** entity 저장 후 저장한 entity 반환 (C / U) */
<S extends T> S save(S entity);
<S extends T> Iterable<S> saveAll(Iterable<S> entity);

/** select(R) */
Optional<T> findById(ID id);
Iterable<T> findAll();
Iterable<T> findAllById(Iterable<ID> ids);
long count();

/** delete(D) */
void deleteById(ID id);
void delete(T entity);
void deleteAllById(Iterable<? extends ID> ids);
void deleteAll(Iterable<? extends T> entities);
void deleteAll();

boolean existsById(ID id);
```

### PagingAndSortRepository<T, ID> extends Repository<T, ID> - @NoRepositoryBean
```
/** sort = Sort.by(Sort.Direction.DESC, "sort할 java 멤버 변수명") */
Iterable<T> findAll(Sort sort);

Page<T> findAll(Pageable pageable);
```

### JpaRepository<T, ID> extends ListCrudRepository<T, ID>, ListPagingAndSortingRepository<T, ID>, QueryByExampleExecutor\<T\> - @NoRepositoryBean
> 이미 작성된 메소드들이 있으니 JpaRepository를 확장한 Repository 생성 시 Body를 비워도 무방함
> ```
> public interface **Repository<T, ID> extends JpaRepository<T, ID> {
> }
> ```
> 이 상태 그대로 아래 메소드들 사용 가능

## Repository Method Naming Rule
### Repository Methods
```
T save();
T delete();
T findOne();
List<T> findAll();
long count();

/**
 * method 이름에 query처럼 조건 추가 가능
 * ex:> findAllByTitle(title);
 * ex:> findByDateBetween(fromDate, toDate);
 * ex:> findByColLike(col);
 * ex:> findByColIsNull();
 * ex:> findAllOrderByColAsc();
 * ex:> findByColGreaterThanEqual(col)
 * and, or, not, in 등등 가능
 */

/** 또는 아래처럼 직접 쿼리를 작성할 수 있음 */

/** 위치 기반 */
@Query("select * from tbl where reg_date between ?1 and ?2")
public List<T> method(fromDate, toDate);

/** 이름 기반 */
@Query("select * from tbl where reg_date between :fromDate and :toDate")
public List<T> method(fromDate, toDate);
```

## @NoRepositoryBean
말 그대로 Bean이 아니기 때문에 구현한 다른 **Repository<T, ID> 인터페이스에 @Repository Annotation을 추가하지 않는다.

# @RequiredArgsConstructor
이 annotation이 적용된 클래스의 멤버 변수는 @SpringBootApplication에 포함된 @ComponentScan이 읽어 Bean으로 등록한다.
따라서 Repository<T, ID>를 구현한 Repository 인터페이스나 Service 등을 구현한 객체는 해당 annotation을 달아줘야 Bean으로 등록된다.