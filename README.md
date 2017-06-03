# Back-End-MS-Actividades
repositorio para el microservicio de actividades
# Start Services
- Download the latest version of eclipse  https://www.eclipse.org/downloads/eclipse-packages/
- Download the latest version of java, if not installed http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- Open the downloaded project in eclipse:
  1. Open eclipse
  2. Import the project: File / import - Maven / Existin Maven Projects
- Find the path where the project was downloaded
- Have access to the internet, and wait for maven to download all its dependencies and create the structure of the project.
- Compile the project without errors
  1. Right click over project, Run as.. / Maven build...
- Write in the goals: "compile" (without quotes) and then click the RUN button
- See that the compilation succeeds in the console
- Run the service:
  1. Run a new maven command (Right click over project, Run as.. / Maven build...)
  2. Write in the goals: "spring-boot:run" (without quotes) and then click the RUN button
#Note: Default port is 9999
