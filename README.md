# brucx-ws

###Requirements
* Java 8
* Postgres Database 9.3+

###Development

For default development settings, Postgres database must be running on `localhost:5432`.
Default user is "brucx" with password "brucx" on "brucx schema.
 
 Setting can be overridden by environment variables or command line arguments.
 
 Example: ˙.\gradlew bootRun -DactiveProfile=dev -Dspring.datasource.username=someUsername˙
 
Preferred way of starting application: `.\gradlew clean bootRun -DactiveProfile=dev`