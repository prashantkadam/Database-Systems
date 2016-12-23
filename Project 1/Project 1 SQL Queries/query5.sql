--Find the firstname and lastname of each student who has never received an A for any course he/she has
--taken. In the output, firstname and lastname of each student should be concatenated with a space in between
--under a new column header name.

select firstname || ' ' || lastname as name
from Students
where B# not in ( 
				select e.B# 
				from enrollments e
				where e.lgrade like 'A'
			) and B# in ( select e1.B# 
				from enrollments e1 );