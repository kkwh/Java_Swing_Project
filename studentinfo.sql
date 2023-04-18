create table STUDENTINFOMANAGE (
    cid     number(6)
            constraint STUDENTINFOMANAGE_cid_pk primary key,
    name    varchar2(100)
            constraint STUDENTINFOMANAGE_name_nn not null,
    gender  varchar2(2 char)
            CONSTRAINT STUDENTINFOMANAGE_gender_nn not null,
    phone   varchar2(100)
            constraint STUDENTINFOMANAGE_phone_nn not null,
    email   varchar2(100),
    birth   varchar2(100)
            CONSTRAINT STUDENTINFOMANAGE_birth_nn not null,
    major   varchar2(100)
            CONSTRAINT STUDENTINFOMANAGE_major_nn not null,
    studentid varchar2(100)
            CONSTRAINT STUDENTINFOMANAGE_studentid_nn not null,
    avggradepoint varchar2(100)
);

drop table contacts;

insert into studentinfomanage(name, gender, phone, email, birth, major, studentid, avggradepoint)
values('김우현', '남성', '010-1111-2222', 'kwh@naver.com', '1996-12-04', 
       '행정학과', '2015123456', '3.99');

insert into studentinfomanage(name, gender, phone, email, birth, major, studentid, avggradepoint)
values('홍길동', '남성', '010-1111-2222', 'kwh@nate.com', '1994-11-01', 
       '경영학과', '2013122676', '3.21');
commit;