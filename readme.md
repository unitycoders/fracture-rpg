# Fracture RPG (2014 Rewrite)
Fracture RPG is a science fiction themed RPG being written primarilly by WebPigeon as a hobby project.

## Compiling and Running
The source code for the project is packaged using maven (with idea files provided for ease of use). You can use maven to package and run the game.

Unit tests are run automaticlly by Travis.
[![Build Status](https://travis-ci.org/unitycoders/fracture-rpg.png?branch=rewrite)](https://travis-ci.org/unitycoders/fracture-rpg)

The project uses maven for depenceny management and to make life easy :).

### Using Maven
All commands must be run from project root (dir with pom.xml in)

* To run the game, run the ```mvn exec:java``` command.
* To run the unit tests, run the ```mvn test``` command.
* To compile the project into a jar file, run the ```mvn package``` command.
* To check for the current technical debt for the project, run ```mvn sonar:sonar``` (needs sonarqube running locally).

A runnable jar file will be avaiable one the project is mature enouph to warrent it.

