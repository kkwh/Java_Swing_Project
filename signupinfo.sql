create table Signupinfo (
    cid     number(6)
            constraint signupinfo_cid_pk primary key,
    name    varchar2(30)
            constraint signupinfo_name_nn not null,
    id      varchar2(30)
            CONSTRAINT signupinfo_id_nn not null,
    pw      varchar2(30)
            CONSTRAINT signupinfo_gender_nn not null,
    birth   varchar2(30),
    phone   varchar2(13)
            constraint signupinfo_phone_nn not null,
    email   varchar2(30)
);