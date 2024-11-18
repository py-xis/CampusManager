-- students
alter table students add constraint pk_students primary key(studentId);

-- teachers
alter table teachers add constraint pk_teachers primary key(teacherID);

-- subjects
alter table subjects add constraint pk_Subjects PRIMARY KEY (SubjectID);

ALTER TABLE subjects MODIFY COLUMN SubjectID INT AUTO_INCREMENT;

alter table subjects add constraint fk_TeacherId_Subjects FOREIGN KEY (TeacherID) REFERENCES Teachers(TeacherID) on delete cascade;

-- student_subjects
alter table student_subjects add constraint pk_student_subjects primary key (RecordID);

ALTER TABLE student_subjects MODIFY COLUMN RecordID INT AUTO_INCREMENT;

alter table student_subjects add constraint fk_StudentId_Student_Subjects FOREIGN KEY (StudentID) REFERENCES Students(StudentID) on delete cascade;

alter table student_subjects add constraint fk_subjectId_Student_Subjects FOREIGN KEY (SubjectID) REFERENCES Subjects(SubjectID) on delete cascade;

-- grades
alter table grades add constraint pk_Grades PRIMARY KEY (GradeID);

ALTER TABLE grades MODIFY COLUMN GradeID INT AUTO_INCREMENT;

alter table grades add constraint fk_StudentId_Grades FOREIGN KEY (StudentID) REFERENCES Students(StudentID) on delete cascade;

alter table grades add constraint fk_SubjectId_Grades FOREIGN KEY (SubjectID) REFERENCES Subjects(SubjectID) on delete cascade;
