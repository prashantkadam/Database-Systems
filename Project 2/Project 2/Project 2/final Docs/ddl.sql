CREATE TABLE students (B# CHAR(4) PRIMARY KEY CHECK (B# LIKE 'B%'),
firstname VARCHAR2(15) NOT NULL, lastname VARCHAR2(15) NOT NULL, status VARCHAR2(10) 
CHECK (status IN ('freshman', 'sophomore', 'junior', 'senior', 'MS', 'PhD')), 
gpa NUMBER(3,2) CHECK (gpa BETWEEN 0 AND 4.0), email VARCHAR2(20) UNIQUE,
bdate DATE, deptname VARCHAR2(4) NOT NULL);

CREATE TABLE courses (dept_code VARCHAR2(4) NOT NULL, course# NUMBER(3) NOT NULL
CHECK (course# BETWEEN 100 AND 799), title VARCHAR2(20) NOT NULL,
PRIMARY KEY (dept_code, course#));

CREATE TABLE course_credit (course# NUMBER(3) NOT NULL PRIMARY KEY
CHECK (course# BETWEEN 100 AND 799), credits NUMBER(1) CHECK (credits IN (3, 4)),
CHECK ((course# < 500 AND credits = 4) OR (course# >= 500 AND credits = 3)));

CREATE TABLE classes (classid CHAR(5) PRIMARY KEY CHECK (classid LIKE 'c%'), 
dept_code VARCHAR2(4) NOT NULL, course# NUMBER(3) NOT NULL, 
sect# NUMBER(2), year NUMBER(4), semester VARCHAR2(8) 
CHECK (semester IN ('Spring', 'Fall', 'Summer 1', 'Summer 2')), limit NUMBER(3), 
class_size NUMBER(3), FOREIGN KEY (dept_code, course#) REFERENCES courses ON DELETE CASCADE, 
UNIQUE(dept_code, course#, sect#, year, semester), CHECK (class_size <= limit));

CREATE TABLE grades(lgrade VARCHAR2(2) NOT NULL CHECK (lgrade IN ('A', 'A-', 'B+', 'B', 
'B-', 'C+', 'C', 'C-','D', 'F', 'I')) PRIMARY KEY,
ngrade NUMBER(2,1) CHECK (ngrade IN (4, 3.7, 3.3, 3, 2.7, 2.3, 2, 1.7, 1, 0, NULL)),
CHECK ((lgrade = 'A' AND ngrade = 4) OR (lgrade = 'A-' AND ngrade = 3.7) OR 
(lgrade = 'B+' AND ngrade = 3.3) OR (lgrade = 'B' AND ngrade = 3) OR  
(lgrade = 'B-' AND ngrade = 2.7) OR (lgrade = 'C+' AND ngrade = 2.3) OR 
(lgrade = 'C' AND ngrade = 2) OR (lgrade = 'C-' AND ngrade = 1.7) OR 
(lgrade = 'D' AND ngrade = 1) OR (lgrade = 'F' AND ngrade = 0) OR  
(lgrade = 'I' AND ngrade = NULL)));

CREATE TABLE enrollments (B# CHAR(4) REFERENCES students, classid CHAR(5) REFERENCES classes, 
lgrade VARCHAR2(2) REFERENCES grades, PRIMARY KEY (B#, classid));

CREATE TABLE prerequisites (dept_code VARCHAR2(4) NOT NULL,
course# NUMBER(3) NOT NULL, pre_dept_code VARCHAR2(4) NOT NULL,
pre_course# NUMBER(3) NOT NULL,
PRIMARY KEY (dept_code, course#, pre_dept_code, pre_course#),
FOREIGN KEY (dept_code, course#) REFERENCES courses ON DELETE CASCADE,
FOREIGN KEY (pre_dept_code, pre_course#) REFERENCES courses ON DELETE CASCADE);

CREATE TABLE logs (logid NUMBER(4) PRIMARY KEY, who VARCHAR2(10) NOT NULL, time DATE NOT NULL,
table_name VARCHAR2(12) NOT NULL, operation VARCHAR2(6) NOT NULL, key_value VARCHAR2(10));
