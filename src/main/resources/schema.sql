DROP TABLE IF EXISTS cases;

CREATE TABLE cases (
    case_id VARCHAR(255) PRIMARY KEY,
    customer_id VARCHAR(255) NOT NULL,
    provider VARCHAR(255) NOT NULL,
    error_code VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    ticket_creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP NOT NULL,
    product_name TEXT NOT NULL
);

SELECT * from cases


DROP TABLE IF EXISTS aggregation;

CREATE TABLE aggregation (
    id VARCHAR(255) PRIMARY KEY,
    error_code VARCHAR(50) NOT NULL,
    provider VARCHAR(255) NOT NULL,
    product_name TEXT NOT NULL,
    cases_number VARCHAR(255) NOT NULL
);

SELECT * from aggregation
