plugins {
    id("io.github.gradlebom.generator-plugin") version "1.0.0.Final"
}

bomGenerator {
    // Native Minecraft dependencies
    includeDependency("org.yaml", "snakeyaml", "1.30")
    includeDependency("com.google.code.gson", "gson", "2.8.8")
    includeDependency("com.google.guava", "guava", "31.0.1-jre")
    includeDependency("org.apache.logging.log4j", "log4j-api", "2.17.1")

    // Paper
    includeDependency("io.papermc.paper", "paper-api", "1.18.1-R0.1-SNAPSHOT")

    // Third party dependencies
    includeDependency("org.checkerframework", "checker-qual", "3.22.1")
    // Adventure & Minimessage
    includeDependency("net.kyori", "adventure-api", "4.11.0")
    includeDependency("net.kyori", "adventure-text-minimessage", "4.1.0-SNAPSHOT")
    includeDependency("net.kyori", "adventure-platform-bukkit", "4.0.1")
    includeDependency("com.intellectualsites.paster", "Paster", "1.1.4")

    // IntellectualSites plugins
    includeDependency("com.plotSquared", "PlotSquared-Core", "6.8.1")
    includeDependency("com.plotSquared", "PlotSquared-Bukkit", "6.8.1")
    includeDependency("com.fastasyncworldedit", "FastAsyncWorldEdit-Core", "2.2.0")
    includeDependency("com.fastasyncworldedit", "FastAsyncWorldEdit-Bukkit", "2.2.0")

    // Plugin dependencies
    includeDependency("com.github.MilkBowl", "VaultAPI", "1.7.1")
    includeDependency("org.bstats", "bstats-bukkit", "3.0.0")
    includeDependency("org.bstats", "bstats-base", "3.0.0")

    // Platform dependencies
    includeDependency("io.papermc", "paperlib", "1.0.7")
    includeDependency("dev.notmyfault.serverlib", "ServerLib", "2.3.1")
}
