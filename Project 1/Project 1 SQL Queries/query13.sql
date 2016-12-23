--13. Find the first name of every student who has taken at least one course that has been taken by student B005.
--Note that here we are talking about taking the same course, not just the same class. 
--(Clearly, student B005 satisfies the condition and his first name should be included in the output.)
select s.firstname from STUDENTS s
where s.B# in (
select e.B#
from ENROLLMENTS e, CLASSES c
where e.CLASSID = c.CLASSID 
and  c.COURSE# = any(
                      select c.COURSE#
                      from Enrollments e join CLASSES c on e.CLASSID = c.CLASSID
                      where e.B# like 'B005'
                    )
                    );