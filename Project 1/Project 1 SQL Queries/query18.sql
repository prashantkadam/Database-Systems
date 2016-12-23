--18. Find the B#, firstname and the total number of credits that have been earned by each student. 
--If a student has not taken any course, he/she is assumed to have earned zero credits and zero credits should be reported for such a student. 
--Don’t count the credits when no grade is given for a class.

select s.B#, s.FIRSTNAME, nvl(temp.total_credits,0) as total_credits
  from students s
    left join (
          select t.B#,sum(c.CREDITS) as total_credits
          from COURSE_CREDIT c,
                  (
                    select B#,c.COURSE#
                    from enrollments e join classes c 
                    on e.classid = c.classid and e.lgrade is  not null
                    ) t
          where c.COURSE# = t.course#
          GROUP by t.B# --,c.COURSE#
          --order by B#
          ) temp
on temp.B# = s.B#;