CREATE TABLE IF NOT EXISTS users
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(200),
  email VARCHAR(200)
);
CREATE UNIQUE INDEX users_id_uindex ON users (id);

CREATE TABLE IF NOT EXISTS events
(
  id SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(200),
  price DOUBLE PRECISION,
  date_time TIMESTAMP,
  auditorium_id INT
);
CREATE UNIQUE INDEX events_id_uindex ON events (id);

CREATE TABLE IF NOT EXISTS auditoriums
(
  id SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(200),
  number_seats INT
);
CREATE UNIQUE INDEX auditoriums_id_uindex ON auditoriums (id);