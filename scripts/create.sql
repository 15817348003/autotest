-- Database: autotest

-- DROP DATABASE autotest;

CREATE DATABASE autotest
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;
       
-- Table: public.project

-- DROP TABLE public.project;

CREATE TABLE public.project
(
  id integer NOT NULL DEFAULT nextval('project_id_seq'::regclass),
  project_name character varying(100) NOT NULL,
  project_code character varying(40) NOT NULL,
  enable integer DEFAULT 1,
  create_date date NOT NULL,
  update_date date NOT NULL,
  CONSTRAINT project_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.project
  OWNER TO postgres;
  
  
-- Table: public.test_case

-- DROP TABLE public.test_case;

CREATE TABLE public.test_case
(
  id integer NOT NULL DEFAULT nextval('test_case_id_seq'::regclass),
  test_case_id character varying(100) NOT NULL,
  test_module_id integer,
  case_name character varying(300) NOT NULL,
  menu_module_value character varying(100) NOT NULL,
  menu_function_value character varying(100) NOT NULL,
  class_module_name character varying(100) NOT NULL,
  class_function_name character varying(100) NOT NULL DEFAULT 1,
  enable integer NOT NULL DEFAULT 1,
  create_date date NOT NULL,
  update_date date NOT NULL,
  CONSTRAINT test_case_pkey PRIMARY KEY (id),
  CONSTRAINT test_case_test_module_id_fkey FOREIGN KEY (test_module_id)
      REFERENCES public.test_module (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.test_case
  OWNER TO postgres;
  
  
-- Table: public.test_case_step

-- DROP TABLE public.test_case_step;

CREATE TABLE public.test_case_step
(
  id integer NOT NULL DEFAULT nextval('test_case_step_id_seq'::regclass),
  test_case_id integer NOT NULL,
  sub_step integer,
  step_type integer NOT NULL DEFAULT 1,
  step_id character varying(50) NOT NULL,
  seq character varying(20) NOT NULL,
  wait_element_located character varying(100) NOT NULL,
  element_xpth character varying(100) NOT NULL,
  element_action character varying(100),
  clean character varying(100),
  element_value character varying(100),
  pause_sec date NOT NULL,
  create_date date NOT NULL,
  update_date date NOT NULL,
  CONSTRAINT test_case_step_pkey PRIMARY KEY (id),
  CONSTRAINT test_case_step_test_case_id_fkey FOREIGN KEY (test_case_id)
      REFERENCES public.test_case (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.test_case_step
  OWNER TO postgres;
  
  
-- Table: public.test_module

-- DROP TABLE public.test_module;

CREATE TABLE public.test_module
(
  id integer NOT NULL DEFAULT nextval('test_module_id_seq'::regclass),
  module_name character varying(100) NOT NULL,
  parent_module_id integer,
  project_id integer NOT NULL,
  type character varying(50) NOT NULL,
  sequence character varying(18) NOT NULL,
  level integer NOT NULL,
  enable integer NOT NULL DEFAULT 1,
  create_date date NOT NULL,
  update_date date NOT NULL,
  CONSTRAINT test_module_pkey PRIMARY KEY (id),
  CONSTRAINT test_module_project_id_fkey FOREIGN KEY (project_id)
      REFERENCES public.project (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.test_module
  OWNER TO postgres;
  
  
-- Sequence: public.project_id_seq

-- DROP SEQUENCE public.project_id_seq;

CREATE SEQUENCE public.project_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.project_id_seq
  OWNER TO postgres;

  
  
-- Sequence: public.test_case_id_seq

-- DROP SEQUENCE public.test_case_id_seq;

CREATE SEQUENCE public.test_case_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 101
  CACHE 1;
ALTER TABLE public.test_case_id_seq
  OWNER TO postgres;

  
-- Sequence: public.test_case_step_id_seq

-- DROP SEQUENCE public.test_case_step_id_seq;

CREATE SEQUENCE public.test_case_step_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 101
  CACHE 1;
ALTER TABLE public.test_case_step_id_seq
  OWNER TO postgres;
  
  
-- Sequence: public.test_module_id_seq

-- DROP SEQUENCE public.test_module_id_seq;

CREATE SEQUENCE public.test_module_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 102
  CACHE 1;
ALTER TABLE public.test_module_id_seq
  OWNER TO postgres;

  
  
  
  