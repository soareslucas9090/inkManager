
CREATE SEQUENCE public.users_id_users_seq;

CREATE TABLE public.users (
                id_users BIGINT NOT NULL DEFAULT nextval('public.users_id_users_seq'),
                email VARCHAR NOT NULL,
                password VARCHAR NOT NULL,
                name VARCHAR NOT NULL,
                CONSTRAINT users_pk PRIMARY KEY (id_users)
);


ALTER SEQUENCE public.users_id_users_seq OWNED BY public.users.id_users;

CREATE SEQUENCE public.worktype_id_worktype_seq;

CREATE TABLE public.worktype (
                id_worktype BIGINT NOT NULL DEFAULT nextval('public.worktype_id_worktype_seq'),
                name VARCHAR NOT NULL,
                deleted_at DATE,
                id_users BIGINT NOT NULL,
                CONSTRAINT worktype_pk PRIMARY KEY (id_worktype)
);


ALTER SEQUENCE public.worktype_id_worktype_seq OWNED BY public.worktype.id_worktype;

CREATE SEQUENCE public.work_id_work_seq;

CREATE TABLE public.work (
                id_work BIGINT NOT NULL DEFAULT nextval('public.work_id_work_seq'),
                client_name VARCHAR NOT NULL,
                description VARCHAR NOT NULL,
                scheduled_date DATE NOT NULL,
                completed_date DATE NOT NULL,
                id_users BIGINT NOT NULL,
                id_worktype BIGINT NOT NULL,
                CONSTRAINT work_pk PRIMARY KEY (id_work)
);


ALTER SEQUENCE public.work_id_work_seq OWNED BY public.work.id_work;

CREATE SEQUENCE public.material_id_material_seq;

CREATE TABLE public.material (
                id_material BIGINT NOT NULL DEFAULT nextval('public.material_id_material_seq'),
                name VARCHAR NOT NULL,
                description VARCHAR NOT NULL,
                quantity REAL NOT NULL,
                image_url VARCHAR NOT NULL,
                unit VARCHAR NOT NULL,
                deleted_at DATE,
                id_users BIGINT NOT NULL,
                CONSTRAINT material_pk PRIMARY KEY (id_material)
);


ALTER SEQUENCE public.material_id_material_seq OWNED BY public.material.id_material;

CREATE TABLE public.workmaterial (
                id_material BIGINT NOT NULL,
                id_work BIGINT NOT NULL,
                used_quantity REAL NOT NULL,
                CONSTRAINT workmaterial_pk PRIMARY KEY (id_material, id_work)
);


ALTER TABLE public.material ADD CONSTRAINT user_material_fk
FOREIGN KEY (id_users)
REFERENCES public.users (id_users)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.work ADD CONSTRAINT user_work_fk
FOREIGN KEY (id_users)
REFERENCES public.users (id_users)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.worktype ADD CONSTRAINT user_worktype_fk
FOREIGN KEY (id_users)
REFERENCES public.users (id_users)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.work ADD CONSTRAINT worktype_work_fk
FOREIGN KEY (id_worktype)
REFERENCES public.worktype (id_worktype)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.workmaterial ADD CONSTRAINT work_workmaterial_fk
FOREIGN KEY (id_work)
REFERENCES public.work (id_work)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.workmaterial ADD CONSTRAINT material_workmaterial_fk
FOREIGN KEY (id_material)
REFERENCES public.material (id_material)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;