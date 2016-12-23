--Find the classid, dept_code and course# of each class offered in Spring 2016 that is not full
--and for each such class, also list the number of seats available (computed by limit – class_size)
--under the header “seats_available”.

select classid, dept_code, course#, LIMIT - CLASS_SIZE as seats_available
from CLASSES
where semester = 'Spring' and year = 2016 and  CLASS_SIZE < LIMIT;