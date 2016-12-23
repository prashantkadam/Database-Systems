--Find every class (all attributes are needed) that is offered by the CS department 
--in the Spring semester of 2016 
--and has less than 3 students enrolled. 
--For this query, the use of the class_size information from the classes table is not permitted

select * from CLASSES 
where DEPT_CODE = 'CS' and SEMESTER = 'Spring' and YEAR=2016  and  classid in (
select CLASSID from 
(
SELECT ClassId, COUNT(B#)
FROM ENROLLMENTS
GROUP BY CLASSID
having count(B#) < 3)
);