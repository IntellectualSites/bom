plugins {
    id("io.github.gradlebom.generator-plugin") version "1.0.0.Final"
}

bomGenerator {
    // Native Minecraft dependencies - locked to the latest version we support
    includeDependency("org.yaml", "snakeyaml", "1.27")
    includeDependency("com.google.code.gson", "gson", "2.8.0")
    includeDependency("com.google.guava", "guava", "21.0")
    includeDependency("org.apache.logging.log4j", "log4j-api", "2.8.1")

    // Third party dependencies
    includeDependency("org.checkerframework", "checker-qual", "3.22.0")
    // Adventure & Minimessage
    includeDependency("net.kyori", "adventure-api", "4.9.3")
    includeDependency("net.kyori", "adventure-text-minimessage", "4.1.0-SNAPSHOT")
    includeDependency("net.kyori", "adventure-platform-bukkit", "4.0.1")
    includeDependency("com.intellectualsites.paster", "Paster", "1.1.4")

    // Plugin dependencies
    includeDependency("com.github.MilkBowl", "VaultAPI", "1.7.1")
    includeDependency("org.bstats", "bstats-bukkit", "3.0.0")

    // Platform dependencies
    includeDependency("io.papermc", "paperlib", "1.0.7")
    includeDependency("dev.notmyfault.serverlib", "ServerLib", "2.3.1")
}