# AutomationHR

This project its a Mulesoft Challenge for QA Engineer Role made By Almer Meza

## Core:

This Project its made with Maven, Java 1.8, Selenium, testNG and Spring boot

## Requirements:

In order to Run this Project you should have install:

- Maven
- Java 1.8
- Chrome or Firefox Browser

> Note: probably you need to update your browser or if you are running Windows or linux you have to download chrome driver or firefox geckodriver; in this case you have to put driver in the corresponding directory.

>Driver path: /src/main/resources/drivers

## How to Run Tests Cases??

This project need 2 parameters for run, you have to indicate Environment And Browser

>Note: by default this project only have info for Production Properties.

####Environments value:
- prod
- qa

####Brower value:
- chrome
- firefox
- chrome-headless

##Running Test:

for get run dependencies, run this command:

```sh
$ mvn clean install
```
then for execute Tests Cases by default you only have to write the follows command:

```sh
$ mvn clean test -Denvironment=prod -Dbrowser=chrome
```
**Also** if you want execute test for specific groups test or environment or browser you have to write this command:

```sh
$ mvn clean test -Dgroups={groupsName} -Denvironment={environmentValue} -Dbrowser={browserValue}
```

####Groups List:

- frontend
- home
- login
- loginOptions
- anypoint
- anypointPlatfom
- anypointStudio
- anypointDownload

##How to see Execution Results?

Once your execution finished, in the **/Reports** Directory will be create a file named "AutomationHRReport.html", you only have to open in your browser and see the Results test

##Author

Almer Meza