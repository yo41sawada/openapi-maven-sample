CREATE TYPE status AS ENUM ('ACTIVE', 'INACTIVE');
CREATE TABLE "user" (
    id INT NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    "status" status NOT NULL
);