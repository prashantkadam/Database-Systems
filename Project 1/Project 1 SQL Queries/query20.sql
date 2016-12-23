-- Compute the GPA for each student from the student’s number grades (ngrade) for all the courses he/she has taken (ignore the GPA values already in the students table). 
-- The GPA of a student is computed by dividing the sum of his/her number grades by the number of classes he/she has taken and received a non-null number grade. If a student has not received any non-null grade yet, the student’s GPA will be null. For each student, the B# of the student and the computed GPA (name column head as cgpa) should be displayed. 
-- Display the results in descending non-null GPA values

select s.B#, nvl(to_char(tempInner.cgpa),' ') as cgpa
from students s  left join (
        select e1.B#, sum(g1.nGRADE), count(e1.CLASSID),sum(g1.nGRADE) / count(e1.CLASSID) as cgpa
        from ENROLLMENTS e1 join GRADES g1 on e1.LGRADE = g1.LGRADE
        where g1.NGRADE is not null
        group by e1.B# ) tempInner
on s.B# = tempInner.B#
order by tempInner.cgpa desc nulls last;