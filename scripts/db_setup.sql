create database spring_exam;
create user 'springuser'@'%' identified by 'userspring';
grant all on spring_exam.* to 'springuser'@'%';