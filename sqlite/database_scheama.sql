CREATE TABLE configurations (
        id INTEGER NOT NULL,
        name VARCHAR,
        PRIMARY KEY (id),
        UNIQUE (name)
)

CREATE TABLE sensors (
        id INTEGER NOT NULL,
        name VARCHAR NOT NULL,
        kp FLOAT NOT NULL,
        ki FLOAT NOT NULL,
        kd FLOAT NOT NULL,
        tf FLOAT NOT NULL,
        configuration_id INTEGER NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY(configuration_id) REFERENCES configurations (id)
)
