--Find the dept_code, course# and title of each course that was offered in the Spring semester of 2016. In the
--output, dept_code and course# of each course should be concatenated under a new column header course_id.

select co.dept_code || co.course# as course_id,co.TITLE
from Courses co 
where  (co.dept_code, co.course#) in(
select cs.dept_code, cs.course#
from classes cs where cs.semester = 'Spring' and cs.year = 2016
);