demo_deltaspike
================

What is it?
-----------

This is a demo project that shows a microblog implemented using DeltaSpike.

It doesn't have a fancy GUI but it tries to show an use for each feature of DeltaSpike.

To run it:

Start the  JBoss WildFly
----------------------

1. Open a command prompt and navigate to the root of the JBoss WildFly directory.
2. The following shows the command line to start the server:

        For Linux:   JBOSS_HOME/bin/standalone.sh
        For Windows: JBOSS_HOME\bin\standalone.bat


Build and Deploy the application
--------------------------------


1. Make sure you have started the JBoss WildFly server as described above.
2. Open a command prompt and navigate to the root directory of this demo.
3. Type this command to build and deploy the archive:

        mvn clean package wildfly:deploy

4. his will deploy `/target/demo_deltaspike.war` to the running instance of the server.
 
Access the application 
----------------------

The application will be running at the following URL: <http://localhost:8080/demo_deltaspike/>.