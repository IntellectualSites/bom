# Bill of materials for IntellectualSites plugins

This repository implements a [Maven BOM](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html#Importing_Dependencies) which can be used in a plugin's build file to more easily manage dependencies on other common plugins.

# Usage

## Import the BOM

### Gradle
```kt
dependencies {
    implementation(platform("com.intellectualsites:bom:<VERSION>"))
}
```
You can find more information about shared and managed dependencies with Gradle [here](https://docs.gradle.org/current/userguide/platforms.html).

### Maven
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.intellectualsites</groupId>
            <artifactId>bom</artifactId>
            <version>VERSION</version>
            <scope>import</scope>
            <type>pom</type>
        </dependency>
    </dependencies>
</dependencyManagement>
```

## Declaring dependencies

Now you can declare dependencies without needing to specify a version:

### Gradle
```kt
dependencies {
    compileOnly("org.checkerframework:checker-qual")
}
```

### Maven
```xml
<dependency>
    <groupId>org.checkerframework</groupId>
    <artifactId>checker-qual</artifactId>
</dependency>
```

You can always override a version managed by the BOM if you wish.
