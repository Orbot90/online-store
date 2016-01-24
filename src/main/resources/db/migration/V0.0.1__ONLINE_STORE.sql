CREATE TABLE categories (
  id BIGINT NOT NULL PRIMARY KEY,
  name CHARACTER VARYING (255) NOT NULL,
  parent_id BIGINT REFERENCES categories (id)
);

CREATE TABLE goods (
  id bigint NOT NULL PRIMARY KEY,
  name CHARACTER VARYING (255) NOT NULL,
  count bigint NOT NULL,
  category_id bigint NOT NULL REFERENCES categories (id),
  price double precision NOT NULL,
  producer CHARACTER VARYING (255) NOT NULL
);