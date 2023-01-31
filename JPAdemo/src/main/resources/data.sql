insert into book (id, title)
values (1, 'Do it! HTML5 + CSS3 웹 표준의 정석');

insert into book (id, title)
values (2, '코드로 배우는 스프링 웹 프로젝트');

insert into book (id, title)
values (3, 'JUSTICE, 정의란 무엇인가?');

insert into book_store (id, name)
values (1, 'yes24');

insert into book_store (id, name)
values (2, '교보문고');

insert into book_contract(book_id, book_store_id, price)
values (1, 1, 13900);

insert into book_contract(book_id, book_store_id, price)
values (2, 1, 14900);

insert into book_contract(book_id, book_store_id, price)
values (3, 1, 15900);

insert into book_contract(book_id, book_store_id, price)
values (1, 2, 16900);

insert into book_contract(book_id, book_store_id, price)
values (2, 2, 17900);