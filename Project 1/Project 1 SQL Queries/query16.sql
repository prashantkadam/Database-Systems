--16. List the dept_code, course# and title of each course that has been taken by student B003. 
--For each such course, also list the grade the student received. 
--If no grade has been assigned for a class, output “to be assigned” as the grade information for the course.


select co.DEPT_CODE,co.COURSE#,co.TITLE, NVL(e.lgrade,'to be assigned') from 
COURSES co, enrollments e
where course# in (
--select e.B#, e.CLASSID,c.DEPT_CODE, c.COURSE#, e.LGRADE
select  cl.COURSE#
from Enrollments e1 join classes cl on e1.CLASSID = cl.CLASSID
where e.B# like 'B003'
      and e.CLASSID = cl.CLASSID
);