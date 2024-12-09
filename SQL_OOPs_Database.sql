CREATE DATABASE OOPs;
USE OOPs;

CREATE TABLE hiredLogin (
    Name VARCHAR(255),
    Year INT,
    Mail VARCHAR(255),
    Password VARCHAR(255),
    University VARCHAR(255),
    Course VARCHAR(255),
    Location varchar(255),
    PRIMARY KEY (Name)
);

CREATE TABLE hirerLogin (
    Name VARCHAR(255),
    Package VARCHAR(255),
    Location varchar(255),
    Course varchar(255),
    Password VARCHAR(255),
    PRIMARY KEY (Name)
);

INSERT INTO hiredLogin VALUES
("Aabha", 2, "aabha.lokhande22@vit.edu", "Aabha@2004", "VIT", "CSE", "Bangalore"),
("Aditya", 2, "aditya.adaki22@vit.edu", "Aditya@2004", "VIT", "CSE", "Pune"),
("Pranit", 2, "pranit.chilbule221@vit.edu", "Pranit@2004", "VIT", "CSE", "Mumbai");

INSERT INTO hirerLogin VALUES
("TCS", 4, "Mumbai", "ALL", "TCS"),
("Google", 50, "Bangalore", "CSE", "Google"),
("Barclays", 14, "Pune", "IT", "Barclays");

-- CREATE TABLE courses (
--     ID INT AUTO_INCREMENT PRIMARY KEY,
--     Course VARCHAR(255)
-- );

-- CREATE TABLE hirerCourses (
--     Name VARCHAR(255),
--     Course_ID INT,
--     PRIMARY KEY (Name, Course_ID),
--     FOREIGN KEY (Name) REFERENCES hirerLogin (Name),
--     FOREIGN KEY (Course_ID) REFERENCES courses (ID)
-- );

-- CREATE TABLE hiredLocation (
--     Name VARCHAR(255),
--     Location VARCHAR(255),
--     FOREIGN KEY (Name) REFERENCES hiredLogin (Name)
-- );

-- CREATE TABLE hirerLocation (
--     Name VARCHAR(255),
--     Location VARCHAR(255),
--     FOREIGN KEY (Name) REFERENCES hirerLogin (Name)
-- );

-- INSERT INTO courses VALUES
-- (1, "CSE"),
-- (2, "CSE(AIML)"),
-- (3, "CSE(AI)"),
-- (4, "IT"),
-- (5, "AIDS"),
-- (6, "E&TC"),
-- (7, "MECH"),
-- (8, "CHEM"),
-- (9, "INSTRU"),
-- (10, "CIVIL"),
-- (11, "ANY");

-- INSERT INTO hirerCourses VALUES
-- ("TCS", 11),
-- ("Google", 1),
-- ("Google", 2),
-- ("Google", 3),
-- ("Google", 4),
-- ("Google", 5),
-- ("Barclays", 1),
-- ("Barclays", 2),
-- ("Barclays", 3);

-- INSERT INTO hirerLocation VALUES
-- ("TCS", "Mumbai"),
-- ("TCS", "Pune"),
-- ("TCS", "Banglore"),
-- ("TCS", "Delhi"),
-- ("Google", "Mumbai"),
-- ("Google", "Banglore"),
-- ("Barclays", "Mumbai"),
-- ("Barclays", "Pune"),
-- ("Barclays", "Banglore");

-- INSERT INTO hiredLocation VALUES
-- ("Pranit", "Mumbai"),
-- ("Pranit", "Pune"),
-- ("Pranit", "Banglore"),
-- ("Pranit", "Delhi"),
-- ("Aabha", "Mumbai"),
-- ("Aabha", "Banglore"),
-- ("Aditya", "Mumbai"),
-- ("Aditya", "Pune"),
-- ("Aditya", "Banglore");