# Java 11 changes

Steps to Follow:

* Install JDK 11 ( Install Jenv to switch between java versions easily. ref: https://github.com/jenv/jenv)
* In gradle.properties, change springBootVersion to springBootVersion=2.7.1 if it is on 1.x version.
* In gradle.properties, change platform connector version to 2.4.5 if it is less than 2.2.8
* Change maven plugin to 'maven-publish'
* Change all compile to implementation, testCompile to testImplementation & implementationOnly to implementation
* Change lombok version to 1.18.24
* Change gradle version in gradle-wrapper.properties to 7.2 ( or 7.3.3 if 7.2 is not working)
* In DockerFile, change apline-jre:latest to alpine-adoptopenjdk-jre:11
* In entrypoint.sh, change bash to sh
* Change javax.validation.constraints.NotBlank to org.hibernate.validator.constraints.NotBlank;
* Change javax.validation.constraints.Null; to javax.validation.constraints.Null
* Move to template based vela configuration
* In vela file, change openjdk8 to openjdk11. In build-feature and build-release, change image from java:openjdk8 to
* docker.com/tap/alpine-openjdk11-build:latest
* Migrating from SpringFox to SpringDoc

- Remove springfox and swagger 2 dependencies. Add springdoc-openapi-ui dependency instead.

springdoc dependency
```html
<dependency>
<groupId>org.springdoc</groupId>
<artifactId>springdoc-openapi-ui</artifactId>
<version>1.6.9</version>
</dependency>
```
- Replace swagger 2 annotations with swagger 3 annotations (it is already included with springdoc-openapi-ui dependency). Package for swagger 3 annotations is io.swagger.v3.oas.annotations.

annotations

```java
@Api → @Tag

@ApiIgnore → @Parameter(hidden = true) or @Operation(hidden = true) or @Hidden

@ApiImplicitParam → @Parameter

@ApiImplicitParams → @Parameters

@ApiModel → @Schema

@ApiModelProperty(hidden = true) → @Schema(accessMode = READ_ONLY)

@ApiModelProperty → @Schema

@ApiOperation(value = "foo", notes = "bar") → @Operation(summary = "foo", description = "bar")

@ApiParam → @Parameter

@ApiResponse(code = 404, message = "foo") → @ApiResponse(responseCode = "404", description = "foo")
```

- Add constant `APPLICATION_TITLE = <Application Name>` to the constants file.
- Change Swagger Configuration class :
Swagger Configuration
```java
@OpenAPIDefinition(servers = {@Server(url = "${server.servlet.context-path}", description = "Default Server URL")})
@Configuration
@Slf4j
public class SwaggerConfig {

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(APPLICATION_TITLE)
                        .description("Shopright Application")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}
```
- Run the application, make sure the swagger page is working fine.
- Remove junit dependency in dependencies{}, add useJUnitPlatform() in test{} in build.gradle file.
- Make the following replacements in test classes
annotations
```java
import org.junit.After; → import org.junit.jupiter.api.AfterEach;

import org.junit.Before; → import org.junit.jupiter.api.BeforeEach;

import org.junit.Test; → import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith; → import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.test.context.junit4.SpringRunner; → import org.springframework.test.context.junit.jupiter.SpringExtension;

@Before → @BeforeEach

@After → @AfterEach

@RunWith(SpringRunner.class) → @ExtendWith(SpringExtension.class)

import static org.junit.Assert.assertEquals; → import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.Assert.assertTrue; → import static org.junit.jupiter.api.Assertions.assertTrue;
```
- For test cases with annotation `@Test`
testcases
```java
@Test(expected = SomeException.class)
public void test_someMethod() throws SomeException {
..............
Mockito.when(...........)
.thenReturn(.........);
someMethod();
}
```



                            ⬇︎



```java
@Test
public void test_someMethod() throws SomeException {
..............
Mockito.when(...........)
.thenReturn(.........);

        assertThrows(SomeException.class, () -> someMethod(), "error message here");
 
    }
```

- If an error raises with use of import javax.validation.Valid; add the dependency below in `build.gradle` `dependencies{}`

spring-boot-starter-validation dependency
```java
implementation group: 'org.springframework.boot', name: 'spring-boot-starter-validation', version: "${springBootVersion}"
```