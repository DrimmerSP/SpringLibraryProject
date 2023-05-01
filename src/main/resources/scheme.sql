-- CREATE TABLE IF NOT EXISTS public.users
-- (
--     second_name TEXT        NOT NULL,
--     name        TEXT        NOT NULL,
--     birth_date  TIMESTAMP   NOT NULL,
--     phone       TEXT        NOT NULL
--         CONSTRAINT users_pk
--             PRIMARY KEY,
--     email       TEXT UNIQUE NOT NULL
-- );

CREATE TABLE public.authors
(
    id           BIGINT       NOT NULL
        PRIMARY KEY,
    created_by   VARCHAR(255),
    created_when TIMESTAMP(6),
    deleted_by   VARCHAR(255),
    deleted_when TIMESTAMP(6),
    is_deleted   BOOLEAN DEFAULT FALSE,
    fio          VARCHAR(255) NOT NULL,
    bith_date    DATE,
    description  VARCHAR(255)
);

-- ALTER TABLE public.authors
--     OWNER TO postgres;

CREATE TABLE public.books
(
    id               BIGINT       NOT NULL
        PRIMARY KEY,
    created_by       VARCHAR(255),
    created_when     TIMESTAMP(6),
    deleted_by       VARCHAR(255),
    deleted_when     TIMESTAMP(6),
    is_deleted       BOOLEAN DEFAULT FALSE,
    amount           INTEGER      NOT NULL,
    title            VARCHAR(255) NOT NULL,
    description      VARCHAR(255),
    genre            SMALLINT     NOT NULL,
    online_copy_path VARCHAR(255),
    publish          VARCHAR(255),
    publish_date     DATE         NOT NULL,
    storage_place    VARCHAR(255) NOT NULL
);

-- ALTER TABLE public.books
--     OWNER TO postgres;

CREATE TABLE public.book_authors
(
    author_id BIGINT NOT NULL
        CONSTRAINT fk_authors_books
            REFERENCES public.authors,
    book_id   BIGINT NOT NULL
        CONSTRAINT fk_books_authors
            REFERENCES public.books
);

-- ALTER TABLE public.book_authors
--     OWNER TO postgres;

CREATE TABLE public.book_rent_info
(
    id           BIGINT       NOT NULL
        PRIMARY KEY,
    created_by   VARCHAR(255),
    created_when TIMESTAMP(6),
    deleted_by   VARCHAR(255),
    deleted_when TIMESTAMP(6),
    is_deleted   BOOLEAN DEFAULT FALSE,
    rent_date    TIMESTAMP(6) NOT NULL,
    rent_period  INTEGER      NOT NULL,
    return_date  TIMESTAMP(6) NOT NULL,
    returned     BOOLEAN      NOT NULL,
    book_id      BIGINT       NOT NULL
        CONSTRAINT fk_rent_book_info_book
            REFERENCES public.books,
    user_id      BIGINT       NOT NULL
);

-- ALTER TABLE public.book_rent_info
--     OWNER TO postgres;

CREATE TABLE public.roles
(
    id          BIGSERIAL
        PRIMARY KEY,
    description VARCHAR(255),
    title       VARCHAR(255)
);

-- ALTER TABLE public.roles
--     OWNER TO postgres;

CREATE TABLE public.users
(
    second_name  TEXT         NOT NULL,
    name         TEXT         NOT NULL,
    birth_date   TIMESTAMP    NOT NULL,
    phone        TEXT         NOT NULL
        CONSTRAINT users_pk
            PRIMARY KEY,
    email        TEXT         NOT NULL
        CONSTRAINT users_pk2
            UNIQUE
        CONSTRAINT uniqueemail
            UNIQUE,
    id           BIGINT       NOT NULL,
    created_by   VARCHAR(255),
    created_when TIMESTAMP(6),
    deleted_by   VARCHAR(255),
    deleted_when TIMESTAMP(6),
    is_deleted   BOOLEAN DEFAULT FALSE,
    address      VARCHAR(255) NOT NULL,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL,
    login        VARCHAR(255) NOT NULL
        CONSTRAINT uniquelogin
            UNIQUE,
    middle_name  VARCHAR(255) NOT NULL,
    password     VARCHAR(255) NOT NULL,
    role_id      BIGINT       NOT NULL
        CONSTRAINT fk_users_roles
            REFERENCES public.roles
);

-- ALTER TABLE public.users
--     OWNER TO postgres;


