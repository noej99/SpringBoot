CREATE TABLE QB(
	q_no number(5) PRIMARY KEY,
	q_title varchar2(100 char) NOT NULL,
	q_writer varchar2(40 char) NOT NULL,
	q_txt varchar2(4000 char) NOT NULL,
	q_date DATE NOT NULL,
	CONSTRAINT qb_writer
	FOREIGN KEY (q_writer) REFERENCES Member_Writer(mw_m_id)
	ON DELETE cascade
);

DROP TABLE qb

CREATE SEQUENCE qb_seq;

INSERT INTO qb values(qb_seq.nextval, );

SELECT * FROM qb;