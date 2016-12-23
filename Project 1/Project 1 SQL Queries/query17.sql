--17. Find the dept_code, course# and title of each course whose title contains “systems” and that has been 
--taken by all students whose GPA is higher than 3.25. Note that even though a qualified course is required to be 
--taken by all students whose GPA is higher than 3.25, it may also be taken by some students
--whose GPA is not higher than 3.25

select * from COURSES c where c.TITLE like '%systems%' 
and  not exists
(select * from students s where s.gpa > 3.25 and not exists
(
select * from enrollments e, classes cl 
where c.dept_code = cl.dept_code and 
      e.classid = cl.classid and 
      s.B# = e.B# and    
      c.COURSE# = cl.course#
)
);

