--Find student B# and faculty B# pairs (named student_B# and faculty_B#, respectively) 
--such that the student has taken a course
--from the faculty but they are not from the same department

SELECT e.B# as student_B#, c.faculty_B# as faculty_B#
from CLASSES c join ENROLLMENTS e on c.CLASSID = e.classid

INTERSECT

select s.B#,f.B#
from STUDENTS s, FACULTY f
where s.DEPTNAME not like f.DEPTNAME;
