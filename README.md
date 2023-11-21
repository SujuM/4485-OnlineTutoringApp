# 4485-OnlineTutoringApp

Bash script:

Update directory path in the bash script. (3 places)
Please delete \4485-OnlineTutoringApp\data\myDB.mv.db before you run bash script.
Otherwise, build fails with "contextLoads() FAILED"


Run the following two commands:
chmod +x myscript.sh


./myscript.sh




Using Intelij IDEA Ultimate to use SpringBoot and H2.
JDK 17    <- It has to be this version for all other dependencies.
Currently, Driver class is SpringDataJpaApplication. (we will needs to rename to OnlineTutoringApplication sometime soon.)

If you run into an issue with dependencies,
Check this link to point this app with JDK 17, https://stackoverflow.com/questions/74890323/in-intellij-spring-boot-gradle-plugin-3-0-0-no-matching-variant-found

If you run into an issue with seeing H2 database, 
Check this link, https://www.jetbrains.com/idea/guide/tutorials/getting-started-spring-data-jpa/database-view/

Use the following URL for testing API call. (While running the app)
http://localhost:8080/swagger-ui/index.html





Table User 
DTYPE: students, tutors


Appointment

create appointment
 - tutor : create their available appointment. updateStatus: available

setStudent: book an appointment
- appointment.updateStatus: scheduled

getStatus: Check the status of appointment.

For frontend,
 - if appointment status is AVAILABLE: show all available appointments that are available by each tutor to students.
 - SCHEDULED: show all scheduled appointments to student
     - For upcoming appointment: if appointmentStatus is SCHEDULED, show a list of appointments.
 - COMPLETED: calculate all completed hours for tutor/student.



****************
Remaining work,

appointment.updateStatus - COMPLETED
calculateDuration of an appointment
additional post endpoint that is related to appointment.


