# Experienced Hacks to Fix Bugs

- If the project isn't picking the required java sdk, add the below in build.gradle file
```java
tasks.withType(JavaCompile) {
    options.fork = true
    options.forkOptions.javaHome = file("/Users/preethi/.jenv/versions/temurin64-21.0.4")
}
```

