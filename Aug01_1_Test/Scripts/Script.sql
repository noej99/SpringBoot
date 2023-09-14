CREATE TABLE aug08_company(
	c_name varchar2(10 char) PRIMARY KEY,
	c_addr varchar2(10 char) NOT null
);

INSERT INTO aug08_company values('농심', '서울');
INSERT INTO aug08_company values('오리온', '인천');


CREATE TABLE aug08_snack(
	s_no number(3) PRIMARY KEY,
	s_name varchar2(10 char) NOT NULL,
	s_price number(5) NOT NULL,
	s_maker varchar2(10 char) NOT NULL,
	CONSTRAINT snack_maker
		FOREIGN KEY(s_maker) REFERENCES aug08_company(c_name)
		ON DELETE CASCADE
);

CREATE SEQUENCE aug08_snack_seq;
INSERT INTO aug08_snack values(aug08_snack_seq.nextval, '새우깡', 1600, '농심');
INSERT INTO aug08_snack values(aug08_snack_seq.nextval, '양파링', 1800, '농심');
INSERT INTO aug08_snack values(aug08_snack_seq.nextval, '초코파이', 5000, '오리온');


SELECT * FROM aug08_snack;




------------------------------------------------
CREATE TABLE aug07_coffee(
	c_name varchar2(10 char) PRIMARY KEY,
	c_price number(5) NOT null
);

SELECT * FROM AUG07_COFFEE;

------------------------------------------------
CREATE TABLE aug17_snack(
	s_name varchar(10 char) PRIMARY KEY,
	s_price number(5) NOT null
);

SELECT * FROM AUG17_SNACK;

------------------------------------------------

CREATE TABLE aug18_photo(
	p_title varchar2(10 char) PRIMARY KEY,
	p_file varchar2(200 char) NOT null
);

SELECT  * FROM aug18_photo;

------------------------------------------------

CREATE TABLE mp_member(
	mm_id varchar2(10 char) PRIMARY KEY,
	mm_pw char(60 char) NOT NULL,
	mm_name varchar2(10 char) NOT null
);

SELECT * FROM mp_member
