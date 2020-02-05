--
-- PostgreSQL database dump
--

-- Dumped from database version 12.0
-- Dumped by pg_dump version 12.0

-- Started on 2020-02-05 00:27:33

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;
--
-- TOC entry 2844 (class 1262 OID 16393)
-- Name: rundomizer; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE rundomizer;


ALTER DATABASE rundomizer OWNER TO postgres;

\connect rundomizer

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 16442)
-- Name: rundomizer; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA rundomizer;


ALTER SCHEMA rundomizer OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 16446)
-- Name: user; Type: TABLE; Schema: rundomizer; Owner: postgres
--

CREATE TABLE rundomizer."user" (
    id integer NOT NULL,
    email character(255) NOT NULL,
    first character(255) NOT NULL,
    last character(255) NOT NULL,
    password character(255) NOT NULL
);


ALTER TABLE rundomizer."user" OWNER TO postgres;

--
-- TOC entry 2712 (class 2606 OID 16450)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: rundomizer; Owner: postgres
--

ALTER TABLE ONLY rundomizer."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


-- Completed on 2020-02-05 00:27:34

--
-- PostgreSQL database dump complete
--

