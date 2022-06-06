plugins {
    id("io.github.gradlebom.generator-plugin") version "1.0.0.Final"
}

bomGenerator {
    includeDependency("org.checkerframework", "checker-qual", "3.22.0")
    includeDependency("net.kyori", "adventure-api", "4.9.3")
    includeDependency("net.kyori", "adventure-text-minimessage", "4.1.0-SNAPSHOT")
    includeDependency("net.kyori", "adventure-platform-bukkit", "4.0.1")
}
