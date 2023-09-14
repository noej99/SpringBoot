CREATE TABLE QABOARD(
	q_no number(5) PRIMARY KEY,
	q_cate varchar2(20 char),
	q_title varchar2(100 char) NOT NULL,
	q_writer varchar2(40 char) NOT NULL,
	q_txt long NOT NULL,
	q_date DATE NOT null,
	CONSTRAINT qb_writer
	FOREIGN KEY (q_writer) REFERENCES member_writer(mw_m_id)
	ON DELETE cascade
);

DROP TABLE QABOARD;

DROP SEQUENCE qaboard_seq;

CREATE SEQUENCE qaboard_seq;

DELETE FROM QABOARD WHERE q_no = 1

INSERT INTO qaboard values(qaboard_seq.nextval, 'ㅇㅇ', 'test', '뭐요', sysdate);

SELECT * FROM QABOARD;

------------------------------------------------
CREATE TABLE qaboard_count(
	qc_no number(5) PRIMARY KEY,
	qc_like number(5) DEFAULT 0 NOT null,
	qc_view number(5) DEFAULT 0 NOT null,
	CONSTRAINT qc_counter
	FOREIGN KEY (qc_no) REFERENCES qaboard (q_no)
	ON DELETE cascade
);

DROP TABLE QABOARD_COUNT

INSERT INTO QABOARD_COUNT values(45, 7, 11);

SELECT * FROM QABOARD_COUNT;
-------------------------------------------------
CREATE TABLE qaboard_like_check(
	NO number(5) PRIMARY KEY,
	qlc_no number(5) NOT NULL,
	qlc_id varchar2(40 char) NOT null,
	qlc_check number(1) DEFAULT 0 NOT NULL,
	CONSTRAINT qlc_mw_id
	FOREIGN KEY (qlc_id) REFERENCES member_writer(mw_m_id),
	CONSTRAINT qlc_q_no
	FOREIGN KEY (qlc_no) REFERENCES qaboard(q_no)
	ON DELETE cascade
);

CREATE SEQUENCE qaboard_like_check_seq;

SELECT * FROM qaboard_like_check; 

DROP TABLE QABOARD_LIKE_CHECK;

DROP SEQUENCE qaboard_like_check_seq;
-------------------------------------------------

CREATE TABLE qaboard_reply(
	qr_no number(5) PRIMARY KEY,
	qr_q_no number(5) NOT NULL,
	qr_writer varchar2(20 char) NOT NULL,
	qr_txt varchar2(4000 char) NOT NULL,
	qr_date DATE NOT NULL,
	CONSTRAINT qr_writer
	FOREIGN KEY (qr_writer) REFERENCES member_writer(mw_m_id),
	CONSTRAINT qr_q_no
	FOREIGN KEY (qr_q_no) REFERENCES qaboard(q_no)
	ON DELETE cascade
);

CREATE SEQUENCE qaboard_reply_seq;

DROP SEQUENCE qaboard_Reply_seq;

SELECT * FROM QABOARD_REPLY;

INSERT INTO QABOARD_REPLY values(qaboard_Reply_Seq.nextval, 61, 'test', 'ㅋㅋㅋㅋㅋㅋ', sysdate); 

DROP TABLE QABOARD_REPLY 
-------------------------------------------------

CREATE TABLE qaboard_rereply (
	qrr_no number(5) PRIMARY KEY,
	qrr_qr_no number(5) NOT NULL,
	qrr_writer varchar2(20 char) NOT NULL,
	qrr_txt varchar2(4000 char) NOT NULL,
	qrr_date DATE NOT NULL,
	CONSTRAINT qrr_qr_no
	FOREIGN KEY (qrr_qr_no) REFERENCES qaboard_reply(qr_no)
	ON DELETE cascade
);

CREATE SEQUENCE qaboard_rereply_seq;

INSERT INTO QABOARD_REREPLY values(qaboard_ReReply_Seq.nextval, 2, 'test', 'ㅋㅋㅋㅋㅋㅋ', sysdate);

SELECT * FROM QABOARD_REREPLY;

DROP TABLE qaboard_rereply

-------------------------------------------------


CREATE TABLE QABOARD_file(
	qf_no number(5) PRIMARY key,
	qf_file varchar2(1000 char)NOT NULL,
	CONSTRAINT qbf_no
	FOREIGN KEY (qf_no) REFERENCES qaboard (q_no)
	ON DELETE cascade
);

DROP TABLE QABOARD_file


SELECT * FROM member