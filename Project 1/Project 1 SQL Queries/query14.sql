--14. Find the dept_code and course# of each course that has two or more classes in the same semester of the same year.
--  The query should also show the semester and year information for each qualified course.

select dept_code,course#,SEMESTER,YEAR--,COUNT(CLASSID)
from Classes
GROUP BY dept_code,course#,SEMESTER,YEAR
HAVING COUNT(CLASSID) >= 2;