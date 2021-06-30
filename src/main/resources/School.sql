drop table IF EXISTS groups, students, courses, student_course;

create table "groups" (group_id INTEGER generated always as identity PRIMARY KEY,
                       group_name VARCHAR(100)
);

create table "students" (student_id INTEGER generated always as identity PRIMARY KEY,
                         group_id INTEGER,
                         first_name VARCHAR(100),
                         last_name VARCHAR(100),
                         FOREIGN KEY(group_id) references groups(group_id) ON DELETE CASCADE
);

create table "courses" (course_id INTEGER generated always as identity PRIMARY KEY,
                        course_name VARCHAR(100),
                        course_description VARCHAR(100)
);

create table "student_course" (id INTEGER generated always as identity PRIMARY KEY,
                               student_id INTEGER,
                               course_id INTEGER,
                               FOREIGN KEY(student_id) references students(student_id) ON DELETE CASCADE,
                               FOREIGN KEY(course_id) references courses(course_id) ON DELETE CASCADE
);

grant all on table courses to drovorub;
grant all on table students to drovorub;
grant all on table student_course to drovorub;
grant all on table "groups" to drovorub;

-- Find all students who dont have a selected course

select * from students s where s.student_id not in (
    select sc.student_id from student_course sc where sc.course_id in (
        select c.course_id from courses c where c.course_id = 10
        )
);

select * from students s where s.student_id not in (
    select sc.student_id from student_course sc where sc.course_id = 10
);

-- Find all students related to course with given name

select s.student_id, s.first_name, s.last_name, c.course_name from students s
INNER JOIN student_course sc on s.student_id = sc.student_id
INNER JOIN courses c on c.course_id = sc.course_id
where c.course_name = 'Algebra';


--Find all groups with less or equals student count

select g.group_id, g.group_name from "groups" g where g.group_id in (
    select s.group_id from students s group by s.group_id having count(s.group_id) <= 7
);

