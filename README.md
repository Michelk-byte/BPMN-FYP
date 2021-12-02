# Camunda BPM Process Application
A Mini-Project Process Application for [Camunda BPM](http://docs.camunda.org) to model and implement the FYP process.
An FYP Process is a Step by Step Guide to Execute our Final Year Project. FYP is an academic task that must be accomplished individually by every undergraduate student to obtain the attributions to graduate.

![img.png](pics/img.png)

Camunda Modeled FYP Process.

![img.png](img/img.png)

Original FYP Process to be modeled.


This project was built using Java Spring Boot and integrated with Camunda's various features.
Inside IntelliJ, it was set up as an Apache Maven Project.


## To build the project

1. Clone the project.
2. Open Project on IntelliJ.

Due to IntelliJ's "Add Maven Support" feature, it will immediately recognize it as a maven.
Dependencies will be resolved without any user interaction.

That's it! Press Shift+F10 or click the Run button to start the project.

## To Start the project

1. To access the application, use [localhost:8080](http://localhost:8080/).
2. Authenticate with the credentials specified in application.yaml file under resources.

![img_1.png](img/img_1.png)

Default user credentials are id: demo, password: demo.

3. Click on the Home button, then TaskList, and finally Start Process.

A List of BPMN models will be provided.
4. Select the root model: "FYP".

![img_3.png](img/img_3.png)