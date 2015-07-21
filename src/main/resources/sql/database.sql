CREATE TABLE news (
  id               NUMBER(6) NOT NULL,
  deleted CHAR DEFAULT 0 check (deleted in(0,1)),
  title            VARCHAR2(100)       NOT NULL,
  brief            VARCHAR2(500)       NOT NULL,
  content          VARCHAR2(2048)      NOT NULL,
  postingDate TIMESTAMP             NOT NULL
);
CREATE SEQUENCE news_id_seq;

CREATE OR REPLACE TRIGGER news_bir
BEFORE INSERT ON news
FOR EACH ROW

  BEGIN
    SELECT news_id_seq.NEXTVAL
    INTO   :new.id
    FROM   dual;
  END;