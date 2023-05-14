INSERT INTO cases (customer_id, provider, error_code, status, ticket_creation_date, last_modified_date, product_name)
SELECT
    'customer_id_' || (random() * 10)::integer,
    'provider_' || (random() * 3)::integer,
    CASE floor(random() * 3)
        WHEN 0 THEN '404'
        WHEN 1 THEN '420'
        WHEN 2 THEN '500'
        ELSE 'unknown'
    END,
    CASE floor(random() * 3)
        WHEN 0 THEN 'open'
        WHEN 1 THEN 'closed'
        WHEN 2 THEN 'pending'
        ELSE 'unknown'
    END,
    TIMESTAMP '2023-01-01 00:00:00' + (random() * (TIMESTAMP '2023-02-28 00:00:00' - TIMESTAMP '2023-01-01 00:00:00')),
    TIMESTAMP '2023-01-01 00:00:00' + (random() * (TIMESTAMP '2023-04-30 00:00:00' - TIMESTAMP '2023-03-01 00:00:00')),
    CASE floor(random() * 3)
        WHEN 0 THEN 'Blue'
        WHEN 1 THEN 'Red'
        WHEN 2 THEN 'Green'
        ELSE 'unknown'
    END,
FROM generate_series(1, 100);

SELECT * from cases
