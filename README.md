Example of Java Spring Boot application that provides a variety of functionalities for health care application such as user creation,user manipulation,appointment system ,doctor and patient system.

# Features
+ User management : Tools for manipulation of users,such as creation,updating and deletion.
+ Appointment management : Tools for creating and canceling appointments.
+ Doctor and patient management : Tools for creating new patients and all necessary information about patients.
+ Role based accsess : Defined roles and permissions for different user types.
+ JTW Token : JWT Token is used for authentication.
+ Database integration : Integration with MySQL for data storage.

# Database model and enteties
![Sql-ER DIAGRAM](https://github.com/asc108/Doctor-Appointment-System/assets/32851529/de880893-cd27-48c1-821b-ffde9f5ea8ed)

# In depth
## Roles
There are 3 predefined roles : **ADMIN,USER,DOCTOR**.
+ Admin -> has accsess to every method in application.
+ User -> has accsess to user managment and appointment managment.
+ Doctor -> has accsess to doctor and patient managment,also every doctor is also a user.



