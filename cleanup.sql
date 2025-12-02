-- Drop all existing tables to ensure a clean slate
DROP TABLE IF EXISTS model_part_compatibility CASCADE;
DROP TABLE IF EXISTS brand_part_compatibility CASCADE;
DROP TABLE IF EXISTS brand_vehicle_type CASCADE;
DROP TABLE IF EXISTS auto_part CASCADE;
DROP TABLE IF EXISTS part_type CASCADE;
DROP TABLE IF EXISTS vehicle_model CASCADE;
DROP TABLE IF EXISTS brand CASCADE;
DROP TABLE IF EXISTS vehicle_type CASCADE;
DROP TABLE IF EXISTS auto_parts CASCADE; -- Old table

-- Spring Boot will recreate the tables on startup because of spring.jpa.hibernate.ddl-auto=update
-- But we can also manually create them if needed. For now, we'll let Hibernate do it.
-- After the app starts and creates tables, we can run the INSERTs.
