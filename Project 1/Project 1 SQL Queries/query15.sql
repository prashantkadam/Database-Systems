--15. Find the B# and firstname of each student who has received at least one highest grade in one of the classes he/she has taken.
-- Suppose all possible grades are (A, A-, B+, B, B-, C+, C, C-, D, F, I). 
-- Note that the highest grade given to students in a class is not necessarily A.
--(Hint: You may need to utilize the number grade ngrade for this query.)

select B#,FIRSTname
from students s
where exists(

select *
from enrollments e, grades g
where e.lgrade = g.lgrade and
      s.B# = e.B# and 
      (e.classid, g.ngrade) in (
    

  select en.classid,max(gr.ngrade)
  from enrollments en, grades gr
  where en.lgrade = gr.lgrade
  group by en.classid
)
);