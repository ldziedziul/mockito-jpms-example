# Mockito vs modular Java

This project shows the problem with creating a spy of the class from another module

## Running tests

You can run tests with maven:

```shell
mvn clean test
```

### Results on different Java versions

#### Java 8:

The code simply work, no warning

#### Java 11

The code works but prints the warning about illegal access:

```
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.mockito.internal.util.reflection.ReflectionMemberAccessor (file:~/.m2/repository/org/mockito/mockito-core/4.0.0/mockito-core-4.0.0.jar) to field java.io.File.path
```

#### Java 17

The code breaks with no warning about illegal access:

```
Cannot invoke "String.indexOf(int)" because "this.path" is null
```

This can be fixed by:
- removing usage of `spy` (using mock or fake instead)
- opening `java.io` module: `mvn clean test -Popen-java.io`
