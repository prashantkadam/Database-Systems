create or replace PACKAGE "PACKAGE_SRS" 
AS
type ref_show_all_tuples
IS
  ref
  CURSOR;
    PROCEDURE proc_show_all_tables(
        in_table_name VARCHAR2,
        out_prc OUT sys_refcursor );
    PROCEDURE proc_show_student_info(
        in_student_B# IN students.B#%type,
        out_prc OUT sys_refcursor ) ;
  TYPE ref_cursor
IS
  REF
  CURSOR;
  
  PROCEDURE proc_find_dependent_courses(
        c_dept_code IN PREREQUISITES.pre_dept_code%TYPE,
        c_course#   IN PREREQUISITES.pre_course#%TYPE,
        out_prc OUT sys_refcursor );
  
    PROCEDURE enroll_student(
        stud_B#      IN STUDENTS.B#%TYPE,
        stud_classid IN CLASSES.CLASSID%TYPE);

FUNCTION GIVE_RESPECTIVE_NGRADE 
(
  IN_LGRADE IN VARCHAR2 
) RETURN VARCHAR2;

PROCEDURE PROC_DELETE_STUDENT (p_students_b# IN STUDENTS.B#%TYPE);
PROCEDURE PROC_DELETE_ENROLLMENT(
    p_B#      IN ENROLLMENTS.B#%TYPE,
    p_classid IN ENROLLMENTS.CLASSID%TYPE);
  
  procedure proc_show_class_details (p_class_id in Classes.classid%type,
    out_prc OUT sys_refcursor);
    
END;