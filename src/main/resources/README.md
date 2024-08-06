//IT IS THE QUERY TO CREATE THE DATABASE IN A GOOD WAY

create database RiwiAcademyDB;
use RiwiAcademyDB;
create table students (
id int primary key auto_increment,
state enum('Activo', 'Inactivo') not null,
email varchar(255) not null,
name varchar(55) not null,
apellido varchar(55) not null,
documento varchar(255) not null
);

create table curses (
id int primary key auto_increment,
name varchar(100) not null unique,
student_id int not null,
foreign key (student_id) references students(id)
);

create table inscriptions (
id int primary key auto_increment,
curse_id int not null,
student_id int not null,
foreign key (curse_id) references curses(id)
on delete cascade,
foreign key (student_id) references students(id)
on delete cascade
);

create table grades (
id int primary key auto_increment,
number_grade int not null,
description varchar(100) not null,
curse_id int not null,
student_id int not null,
foreign key (student_id) references students(id)
on delete cascade,
foreign key (curse_id) references curses(id)
on delete cascade
);

alter table inscriptions
add column date_inscription date not null;


//TO START THE APLICATION BEFORE OF CREATE THE DATABASE, YOU HAVE THAT GO TO THE FILE CALLED "MAIN" AND CLICK ON THE BUTTON IN THE TOP AND RIGHT SIDE IN THE SCREEN, AND WAITING FOR A BIT SECONDS

//IN THIS FOLDER YOU CAN SEE AN IMAGE WITH THE DESIGN OF THE DATABASE AND ITS RELATIONS

//IN YOUR DBConnection YOU CAN TO HAVE SOMETHING LIKE :

        String URL = "jdbc:mysql://127.0.0.1:3306/RiwiAcademyDB";
        String USER = "root";
        String PASSWORD = "tupassword";

//IF YOU DON'T HAVE SOMETHING LIKE THAT, TOU COULD TO DO SOMETHING CHANGES IN YOUR CONFIGURATION

//THIS IS THE REPOSITORY'S LINK: 