DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS basket;
DROP TABLE IF EXISTS goods;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 1;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  email      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP DEFAULT now(),
  enabled    BOOL DEFAULT FALSE

);
CREATE UNIQUE INDEX unique_email ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE orders
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id     INTEGER NOT NULL,
  registered TIMESTAMP DEFAULT now(),
  newOrder    BOOL DEFAULT TRUE,
  enabled    BOOL DEFAULT FALSE
);

CREATE TABLE goods
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  count     INTEGER,
  price   FLOAT,
  producer VARCHAR,
  description VARCHAR
);

CREATE TABLE basket
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  registered TIMESTAMP DEFAULT now(),
  cleared    BOOL DEFAULT FALSE

);

CREATE TABLE