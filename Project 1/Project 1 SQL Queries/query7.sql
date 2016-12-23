--Find the dept_code and course# of each course that has been offered the most number of times 
--(each record in the classes table corresponds to a course offering). 
--Note that it is possible that more than one course may satisfy this query condition; 
--in this case, all such courses should be retrieved.

select dept_code,course#
from(
        SELECT dept_code,course#,count(*) as num
        FROM CLASSES 
        group by Course#,dept_code
       -- order by num desc
) t
where t.num = (

select max(num)
from(
        SELECT dept_code,course#,count(*) as num
        FROM CLASSES 
        group by Course#,dept_code
        --order by num desc
        )
        );
