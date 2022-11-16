plugins {
    id("io.github.gradlebom.generator-plugin") version "1.0.0.Final"
}

bomGenerator {
    // FastAsyncWorldEdit, PlotSquared, etc. serve a bom on its on, which we don't want here
    excludeProject("bom-1.16.x")
    excludeProject("bom-1.18.x")
    excludeProject("bom-newest")

    // Native Minecraft dependencies
    includeDependency("org.yaml", "snakeyaml", "1.30")
    includeDependency("com.google.code.gson", "gson", "2.8.8")
    includeDependency("com.google.guava", "guava", "31.0.1-jre")
    includeDependency("org.apache.logging.log4j", "log4j-api", "2.17.1")

    // Paper
    includeDependency("io.papermc.paper", "paper-api", "1.18.1-R0.1-SNAPSHOT")

    // Third party dependencies
    includeDependency("org.checkerframework", "checker-qual", "3.27.0")
    // Adventure & Minimessage
    includeDependency("net.kyori", "adventure-api", "4.9.3")
    includeDependency("net.kyori", "adventure-text-minimessage", "4.1.0-SNAPSHOT")
    includeDependency("net.kyori", "adventure-platform-bukkit", "4.0.1")

    // IntellectualSites plugins
    includeDependency("com.plotsquared", "PlotSquared-Core", "6.10.4")
    includeDependency("com.plotsquared", "PlotSquared-Bukkit", "6.10.3")
    includeDependency("com.fastasyncworldedit", "FastAsyncWorldEdit-Core", "2.4.10")
    includeDependency("com.fastasyncworldedit", "FastAsyncWorldEdit-Bukkit", "2.4.10")

    // IntellectualSites libraries
    includeDependency("com.intellectualsites.paster", "Paster", "1.1.4")
    includeDependency("com.intellectualsites.informative-annotations", "informative-annotations", "1.2")

    // Plugin dependencies
    includeDependency("com.github.MilkBowl", "VaultAPI", "1.7.1")
    includeDependency("org.bstats", "bstats-bukkit", "3.0.0")
    includeDependency("org.bstats", "bstats-base", "3.0.0")

    // Platform dependencies
    includeDependency("io.papermc", "paperlib", "1.0.7")
    includeDependency("dev.notmyfault.serverlib", "ServerLib", "2.3.1")
}
