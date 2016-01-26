CREATE SEQUENCE store_sequence
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

CREATE TABLE categories (
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('store_sequence'),
  name CHARACTER VARYING (255) NOT NULL,
  parent_id BIGINT REFERENCES categories (id),
  characteristics_template JSON
);

CREATE TABLE orders (
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('store_sequence'),
  start_date TIMESTAMP NOT NULL,
  delivery_type CHARACTER VARYING (255) NOT NULL,
  address CHARACTER VARYING (255),
  order_status CHARACTER VARYING (255) NOT NULL
);

CREATE TABLE accounts (
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('store_sequence'),
  name CHARACTER VARYING (255) UNIQUE,
  amount DOUBLE PRECISION,
  user_id BIGINT
);

CREATE TABLE users (
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('store_sequence'),
  username CHARACTER VARYING (255) NOT NULL UNIQUE,
  password CHARACTER VARYING (255) NOT NULL,
  first_name CHARACTER VARYING (255),
  last_name CHARACTER VARYING (255),
  address CHARACTER VARYING (255),
  registration_date TIMESTAMP NOT NULL,
  email CHARACTER VARYING (255) NOT NULL UNIQUE,
  avatar BYTEA,
  account_id BIGINT UNIQUE REFERENCES accounts (id),
  activity_status CHARACTER VARYING (255) NOT NULL
);

ALTER TABLE accounts
ADD FOREIGN KEY (user_id) REFERENCES users (id);

CREATE TABLE goods (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('store_sequence'),
  name CHARACTER VARYING (255) NOT NULL,
  article CHARACTER VARYING(255) NOT NULL,
  count bigint NOT NULL,
  category_id bigint NOT NULL REFERENCES categories (id),
  price double precision NOT NULL,
  producer CHARACTER VARYING (255) NOT NULL,
  image BYTEA
);

CREATE TABLE roles (
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('store_sequence'),
  name CHARACTER VARYING (255) NOT NULL
);

CREATE TABLE messages (
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('store_sequence'),
  message CHARACTER VARYING (255) NOT NULL,
  message_type CHARACTER VARYING (255) NOT NULL
);

CREATE TABLE goods_messages (
  goods_id BIGINT NOT NULL REFERENCES goods (id),
  messages_id BIGINT NOT NULL REFERENCES messages (id) UNIQUE
);

CREATE TABLE goods_orders (
  goods_id BIGINT NOT NULL REFERENCES goods (id),
  orders_id BIGINT NOT NULL REFERENCES orders (id)
);

CREATE TABLE users_orders (
  user_id BIGINT NOT NULL REFERENCES users (id),
  order_id BIGINT NOT NULL REFERENCES orders (id) UNIQUE
);

CREATE TABLE users_roles (
  user_id BIGINT NOT NULL REFERENCES users (id),
  role_id BIGINT NOT NULL REFERENCES roles (id)
);

CREATE TABLE users_messages (
  user_id BIGINT NOT NULL REFERENCES users (id),
  messages_id BIGINT NOT NULL REFERENCES messages (id) UNIQUE
);

INSERT INTO roles (name) VALUES ('ADMIN'), ('SILENCE'), ('BANNED');