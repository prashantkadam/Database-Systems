--Find the B# and first name of every student who has taken all 400-level CS courses. 
--Here we are referring to courses, not classes
        
select s.B#,s.FIRSTNAME from students s where not exists
(
    select * from courses co where co.dept_code = 'CS' and  co.COURSE# BETWEEN 400 and 499
        and not exists
          (
          select * from ENROLLMENTS e, classes c
          where e.classid = c.classid and
                c.dept_code = co.dept_code and
                c.course# = co.course# and
                s.B# = e.B#));
