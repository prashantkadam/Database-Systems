--query3.sql
--Find the dept_code and course# of each course that was not offered in the Fall semester of 2015. 

select co.dept_code, co.course#
from COURSES co 
where co.COURSE# in (
      select course# from COURSES
      
      minus
      
      select course#
      from Classes
      WHERE semester like 'Fall' and year = 2015
);