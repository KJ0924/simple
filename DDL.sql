DROP TABLE TB_TEMPLATE CASCADE CONSTRAINTS;
DROP TABLE TB_BOARD CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_BOARD;
CREATE SEQUENCE SEQ_BOARD NOCACHE NOCYCLE;
CREATE TABLE TB_TEMPLATE(
TEMPLATE VARCHAR2(10) PRIMARY KEY,
HTML VARCHAR2(4000),
CRE_DT TIMESTAMP DEFAULT SYSDATE,
UPD_DT TIMESTAMP DEFAULT SYSDATE
);

CREATE TABLE TB_BOARD(
NO NUMBER PRIMARY KEY,
JSON_DATA VARCHAR2(4000) NOT NULL,
CRE_DT TIMESTAMP DEFAULT SYSDATE,
UPD_DT TIMESTAMP DEFAULT SYSDATE
);
