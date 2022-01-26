-- in database Robots

CREATE TABLE Jaegers (
    id          SERIAL PRIMARY KEY,
    modelName   TEXT,
    mark        CHAR(6),
    height      DOUBLE PRECISION,   -- meters
    weight      INTEGER,            -- tons
    status      TEXT,
    origin      TEXT,
    launch      DATE,
    kaijuKill   INTEGER
);