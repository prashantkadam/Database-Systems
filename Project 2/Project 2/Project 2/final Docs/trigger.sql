CREATE SEQUENCE seq_logs INCREMENT BY 1 START WITH 1000;
/
show errors;
CREATE OR REPLACE TRIGGER TRIGGER_INSERT_ENROLLMENTS
  AFTER INSERT
  ON ENROLLMENTS
  FOR EACH ROW
DECLARE
  t_keyval LOGS.KEY_VALUE%TYPE;
BEGIN
    t_keyval := :new.B# || ',' || :new.classid;
   -- dbms_output.put_line(t_keyval);
  INSERT INTO LOGS (LOGID, WHO, TIME, TABLE_NAME, OPERATION, KEY_VALUE)
    VALUES (seq_logs.NEXTVAL, user, SYSDATE, 'Enrollments', 'Insert', t_keyval);
END;
/



CREATE OR REPLACE TRIGGER TRIGGER_DELETE_ENROLLMENTS
  AFTER DELETE 
  ON ENROLLMENTS
  FOR EACH ROW
DECLARE
  t_keyval LOGS.KEY_VALUE%TYPE;
BEGIN
    t_keyval := :old.B# || ',' || :old.classid;
   -- dbms_output.put_line(t_keyval);
  INSERT INTO LOGS (LOGID, WHO, TIME, TABLE_NAME, OPERATION, KEY_VALUE)
    VALUES (seq_logs.NEXTVAL, user, SYSDATE, 'Enrollments', 'Delete', t_keyval);
END;
/


--create trigger TRIGGER_LOGS_ENROLLMENTS
-- This trigger will log entry for student table insert
create or replace TRIGGER trigger_insert_student
  AFTER INSERT
  ON STUDENTS
  FOR EACH ROW
DECLARE
  t_keyval LOGS.KEY_VALUE%TYPE;
BEGIN
    t_keyval := :new.B#;
    --dbms_output.put_line(t_keyval);
  INSERT INTO LOGS (LOGID, WHO, TIME, TABLE_NAME, OPERATION, KEY_VALUE)
    VALUES (seq_logs.NEXTVAL, user, SYSDATE, 'Students', 'Insert', t_keyval);
END;
/




--create trigger class_size
-- This trigger will log entry for class size increase
CREATE OR REPLACE TRIGGER TRIGGER_INC_CLASS_SIZE
  before INSERT ON ENROLLMENTS
  FOR EACH ROW
  DECLARE
  old_class_size CLASSES.CLASS_SIZE%TYPE;
  l_limit CLASSES.LIMIT%TYPE;
  class_full EXCEPTION;
  BEGIN
  SELECT class_size, limit INTO old_class_size, l_limit
  FROM CLASSES
  WHERE classid = :new.classid;
  IF (old_class_size = l_limit) THEN
    raise class_full;
  ELSE
    UPDATE CLASSES 
    SET class_size = old_class_size + 1
    WHERE classid = :new.classid;
  END IF;
  --dbms_output.put_line('trigger TRIGGER_INC_CLASS_SIZE executed...');
  EXCEPTION
  WHEN class_full 
  THEN RAISE_APPLICATION_ERROR(-20008, 'The class is full.');
END;
/

create or replace TRIGGER TRIGGER_DEC_CLASS_SIZE AFTER
  DELETE ON ENROLLMENTS FOR EACH ROW 
  DECLARE 
    old_class_size CLASSES.CLASS_SIZE%TYPE;
  BEGIN
    SELECT class_size
    INTO old_class_size
    FROM CLASSES
    WHERE classid = :old.classid;
    
    UPDATE CLASSES
    SET class_size = old_class_size - 1
    WHERE classid  = :old.classid;
    
    --dbms_output.put_line('trigger TRIGGER_DEC_CLASS_SIZE executed...');
  END;
  /

create or replace TRIGGER trigger_delete_student
  AFTER DELETE 
  ON STUDENTS
  FOR EACH ROW
DECLARE
  l_classid varchar2(200);
  t_keyval LOGS.KEY_VALUE%TYPE;
  CURSOR c1
    IS
      SELECT classid FROM ENROLLMENTS WHERE B# = :old.B#;
      c1_rec c1%rowtype;
BEGIN
  if(not c1%isopen) then
    open c1;
  end if;
  fetch c1 into c1_rec;
  while c1%found loop
     l_classid := c1_rec.classid;
    delete from enrollments where B# = :old.B# and classid = l_classid;
      fetch c1 into c1_rec;
  END LOOP;
    close c1;
    t_keyval := :old.B#;
    --dbms_output.put_line(t_keyval);
  INSERT INTO LOGS (LOGID, WHO, TIME, TABLE_NAME, OPERATION, KEY_VALUE)
    VALUES (seq_logs.NEXTVAL, user, SYSDATE, 'Students', 'Delete', t_keyval);
END;
/
show errors;