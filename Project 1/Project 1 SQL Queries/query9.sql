--Find every student (all attributes are needed) who has taken more than 3 classes.
--Write a query with a correlated subquery and write another query with an uncorrelated subquery.

-- co-relatted query
select * from STUDENTS s
where exists (
    select B#
    from ENROLLMENTS  e
    where e.B# = s.B# 
    GROUP BY e.B#
    HAVING COUNT(e.CLASSID) > 3  
);

-- un-corelated Query

SELECT  * 
from STUDENTS s
where  B# in (
    select B#
    from ENROLLMENTS e
    GROUP BY B#
    HAVING COUNT(e.CLASSID) > 3  
);