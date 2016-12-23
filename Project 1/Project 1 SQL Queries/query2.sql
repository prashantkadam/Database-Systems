--Find the B#, first name, last name and GPA of each student who has taken at least one CS course and at
--least one math course.

select B#,firstname, lastname, gpa
from Students
where B# in ( 
				select e.B#
				from enrollments e join classes c on e.classid = c.classid
				where c.dept_code like 'Math'
        
        INTERSECT
        
        select e.B#
				from enrollments e join classes c on e.classid = c.classid
				where c.dept_code = 'CS'

			);