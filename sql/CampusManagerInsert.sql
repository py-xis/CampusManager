INSERT INTO students (studentId, firstName, lastName, DOB, gender, email) VALUES
(1, 'John', 'Doe', '2004-03-15', 'M',  'john.doe@example.com'),
(2, 'Jane', 'Smith', '2003-07-22', 'F',  'jane.smith@example.com'),
(3, 'Mark', 'Brown', '2005-01-30', 'M', 'mark.brown@example.com');


INSERT INTO teachers (teacherID, firstName, lastName, hireDate, subject, email) VALUES
(1, 'Alice', 'Johnson', '2015-08-23', 'Mathematics', 'alice.johnson@example.com'),
(2, 'Bob', 'Lee', '2010-09-12', 'Biology', 'bob.lee@example.com'),
(3, 'Chloe', 'Davis', '2018-03-17', 'English', 'chloe.davis@example.com');


INSERT INTO subjects (SubjectID, SubjectName, SubjectDescription, TeacherID) VALUES
(1, 'Calculus', 'An advanced mathematics course covering differential and integral calculus.', NULL),
(2, 'Biology', 'Study of life and living organisms, including their structure, function, growth, and evolution.', NULL),
(3, 'English Literature', 'Study of literature written in the English language, including analysis of texts and themes.', NULL);


INSERT INTO student_subjects (StudentID, SubjectID, Year, Semester) VALUES
(NULL, NULL, 2023, 'Fall'),
(NULL, NULL, 2023, 'Fall'),
(NULL, NULL, 2023, 'Fall'),
(NULL, NULL, 2023, 'Fall'),
(NULL, NULL, 2023, 'Fall'),
(NULL, NULL, 2023, 'Fall');


INSERT INTO grades (StudentID, SubjectID, Grade, Term, Year, DateRecorded) VALUES
(NULL, NULL, 'A', 'Fall', 2023, '2023-12-15'),
(NULL, NULL, 'B', 'Fall', 2023, '2023-12-15'),
(NULL, NULL, 'A-', 'Fall', 2023, '2023-12-15'),
(NULL, NULL, 'B+', 'Fall', 2023, '2023-12-15'),
(NULL, NULL, 'A', 'Fall', 2023, '2023-12-15'),
(NULL, NULL, 'A-', 'Fall', 2023, '2023-12-15');
