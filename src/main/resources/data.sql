CREATE TABLE events_log(
    id INT auto_increment,
    ip_origin VARCHAR(15) NOT NULL,
    logged_on TIMESTAMP NOT NULL,
    method_name VARCHAR(30) NOT NULL
);

INSERT INTO events_log (ip_origin, logged_on, method_name) VALUES ('231.123.123.123', '2024-06-15 15.15.15', 'getPokemonId');