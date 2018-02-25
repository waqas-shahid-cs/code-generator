# Code Generator
This is the utility project which generates the code that would assist in reducing the development time. It generate the code files which generally follows the same pattern in every task.

You can clone the project to customize it.

## Build
You can build the project by using the following maven command:
`mvn clean package`

## Run
```
java -jar -Dproject.path={Project Path} target/code-generator-1.0-SNAPSHOT.jar {Command Name}
```
__Note:__
- {Project Path} Path of the Project where we need to create the files.
- {Command Name} There can be many commands supported by this project. Use the command as you require.

## Commands
Basically, you can add differert commands to the generator. Below are the details of the commands supported by this project:

### 1) generate-classes:
This command is used to generate all type of code files supported by this project.
