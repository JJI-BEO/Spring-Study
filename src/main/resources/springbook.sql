CREATE TABLE users (
    id       VARCHAR2(8 BYTE),
    password VARCHAR2(8 BYTE),
    name     VARCHAR2(20 BYTE),
    role     VARCHAR2(5 BYTE),
    PRIMARY KEY ( id )
);

INSERT INTO users VALUES (
    'test',
    'test1234',
    '관리자',
    'Admin'
);

INSERT INTO users VALUES (
    'user1',
    'user1',
    '홍길동',
    'User'
);

SELECT
    *
FROM
    users;

CREATE TABLE board (
    seq     NUMBER(5, 0),
    title   VARCHAR2(200 BYTE),
    writer  VARCHAR2(20 BYTE),
    content VARCHAR2(2000 BYTE),
    regdate DATE DEFAULT sysdate + 1,
    cnt     NUMBER(5, 0) DEFAULT 0,
    PRIMARY KEY ( seq )
);

create sequence board_seq increment by 1 start with 0 MAXVALUE 9999999 MINVALUE 0;
INSERT INTO board (
    seq,
    title,
    writer,
    content
) VALUES (
    board_seq.NEXTVAL,
    '가입인사',
    '관리자',
    '잘부탁합니다...'
);

SELECT
    *
FROM
    board;

COMMIT;