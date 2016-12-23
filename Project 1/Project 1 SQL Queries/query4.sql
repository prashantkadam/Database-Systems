--Find the B#, firstname, lastname and GPA of each graduate student who has received a grade below B (i.e.,
--B-, C+, C, C-, D, F) at least one course he/she has taken.

select B#,firstname, lastname, gpa
from Students
where status like 'MS' and B# in ( 
				select e.B# 
				from enrollments e 
				where e.lgrade in ( 'B-', 'C+', 'C', 'C-', 'D', 'F')
			);
      