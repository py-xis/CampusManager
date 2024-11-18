-- Script for creating the Students table.
create table students(
    studentId int,
    firstName varchar(100) not null,
    lastName varchar(100),
    DOB date not null,
    gender char(1) not null,
    email varchar(100)
);

-- Script for creating Teachers table
create table teachers(
    teacherID int,
    firstName varchar(100) not null,
    lastName varchar(100),
    hireDate date not null,
    subject varchar(100),
    email varchar(110)
);

-- Script for creating the subjects table
CREATE TABLE subjects (
    SubjectID INT ,
    SubjectName VARCHAR(100),
    SubjectDescription TEXT,
    TeacherID INT
) ENGINE=InnoDB;


-- Script for creating the Student_Subjects
CREATE TABLE student_subjects (
    RecordID INT ,
    StudentID INT,
    SubjectID INT,
    Year YEAR,
    Semester VARCHAR(10)
) ENGINE=InnoDB;

-- Script for creating the grades table
CREATE TABLE grades (
    GradeID INT ,
    StudentID INT,
    SubjectID INT,
    Grade CHAR(4),
    Term VARCHAR(10),
    Year YEAR,
    DateRecorded DATE
) ENGINE=InnoDB;

