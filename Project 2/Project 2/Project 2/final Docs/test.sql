exec PACKAGE_SRS.PROC_DELETE_STUDENT('B100');
select class_size from classes where classid = 'c0007';
select * from enrollments where classid = 'c0007';
set SERVEROUTPUT ON;
select classid, count(*) from enrollments group by classid;
select * from logs;