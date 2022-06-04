create sequence user_id_seq
    as integer;

alter table "user"
    alter column id set default nextval('public.user_id_seq'::regclass);

alter sequence user_id_seq owned by "user".id;

alter table "user"
    add constraint user_pk
        primary key (id);

