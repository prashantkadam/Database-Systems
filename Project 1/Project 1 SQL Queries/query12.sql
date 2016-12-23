--12. Find the title of each course that has been taken by student B001 but not by student B002

select TITLE from
COURSES
WHERE COURSE# in
                  (
                    select c.COURSE#
                    from Enrollments e join CLASSES c on e.CLASSID = c.CLASSID
                    where e.B# like 'B001'
                    
                    MINUS
                    
                    select c.COURSE#
                    from Enrollments e join CLASSES c on e.CLASSID = c.CLASSID
                    where e.B# like 'B002'
                  );