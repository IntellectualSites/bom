plugins {
    id("io.github.gradlebom.generator-plugin") version "1.0.0.Final"
}

bomGenerator {
    includeDependency("org.checkerframework", "checker-qual", "3.22.0")
}
