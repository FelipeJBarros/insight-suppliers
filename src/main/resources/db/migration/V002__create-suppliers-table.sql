CREATE TABLE IF NOT EXISTS suppliers (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        VARCHAR(255) NOT NULL,
    doc_number  VARCHAR(14) UNIQUE NOT NULL,
    email       VARCHAR(255) UNIQUE NOT NULL
);