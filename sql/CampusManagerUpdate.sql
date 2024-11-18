-- subjects
update subjects set  TeacherID = 1 where SubjectID = 1;
update subjects set  TeacherID = 2 where SubjectID = 2;
update subjects set  TeacherID = 3 where SubjectID = 3;

-- student_subjects

update student_subjects set StudentID = 1 ,SubjectID = 1 where RecordID = 1;
update student_subjects set StudentID = 1 ,SubjectID = 2 where RecordID = 2;
update student_subjects set StudentID = 2 ,SubjectID = 1 where RecordID = 3;
update student_subjects set StudentID = 2 ,SubjectID = 3 where RecordID = 4;
update student_subjects set StudentID = 3 ,SubjectID = 2 where RecordID = 5;
update student_subjects set StudentID = 3 ,SubjectID = 3 where RecordID = 6;

-- grades

update grades set StudentID = 1 ,SubjectID = 1 where GradeID = 1;
update grades set StudentID = 1 ,SubjectID = 2 where GradeID = 2;
update grades set StudentID = 2 ,SubjectID = 1 where GradeID = 3;
update grades set StudentID = 2 ,SubjectID = 3 where GradeID = 4;
update grades set StudentID = 3 ,SubjectID = 2 where GradeID = 5;
update grades set StudentID = 3 ,SubjectID = 3 where GradeID = 6;