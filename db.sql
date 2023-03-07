-- In case something exists
DROP TABLE employee PURGE;
DROP SEQUENCE employee_sec;

-- Create
CREATE SEQUENCE employee_sec START WITH 1 INCREMENT BY 1;

CREATE TABLE employee (
    id INTEGER DEFAULT employee_sec.nextval NOT NULL PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    document VARCHAR2(100) NOT NULL,
    position VARCHAR2(100) NOT NULL,
    age INTEGER NOT NULL,
    phone VARCHAR2(100) NOT NULL
);

INSERT INTO employee (name, document, position, age, phone) VALUES ('Santiago Aguilar', '1111111111', 'Software Developer', 28, '3111111111');
INSERT INTO employee (name, document, position, age, phone) VALUES ('Gina Suarez', '2222222222', 'Software Developer', 27, '3222222222');
INSERT INTO employee (name, document, position, age, phone) VALUES ('Andrés Carvajal', '3333333333', 'Software Developer', 28, '3333333333');

-- Select
SELECT * FROM employee;
