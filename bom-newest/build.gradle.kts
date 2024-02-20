plugins {
    id("io.github.gradlebom.generator-plugin") version "1.0.0.Final"
}

bomGenerator {
    // FastAsyncWorldEdit, PlotSquared, etc. serve a bom on its on, which we don't want here
    excludeProject("bom-1.16.x")
    excludeProject("bom-newest")

    // Native Minecraft dependencies - locked at the version the game uses
    includeDependency("org.yaml", "snakeyaml", "2.2")
    includeDependency("com.google.code.gson", "gson", "2.10.1")
    includeDependency("com.google.guava", "guava", "32.1.2-jre")
    includeDependency("org.apache.logging.log4j", "log4j-api", "2.19.0")

    // Paper
    includeDependency("io.papermc.paper", "paper-api", "1.20.2-R0.1-SNAPSHOT")

    // Third party dependencies
    includeDependency("org.checkerframework", "checker-qual", "3.42.0")
    // Adventure & Minimessage
    includeDependency("net.kyori", "adventure-api", "4.16.0")
    includeDependency("net.kyori", "adventure-text-minimessage", "4.15.0")
    includeDependency("net.kyori", "adventure-platform-bukkit", "4.3.2")

    // IntellectualSites plugins
    includeDependency("com.intellectualsites.plotsquared", "plotsquared-core", "7.3.5")
    includeDependency("com.intellectualsites.plotsquared", "plotsquared-bukkit", "7.3.5")
    includeDependency("com.fastasyncworldedit", "FastAsyncWorldEdit-Core", "2.9.0")
    includeDependency("com.fastasyncworldedit", "FastAsyncWorldEdit-Bukkit", "2.9.0")

    // IntellectualSites libraries
    includeDependency("com.intellectualsites.paster", "Paster", "1.1.5")
    includeDependency("com.intellectualsites.informative-annotations", "informative-annotations", "1.4")

    // Plugin dependencies
    includeDependency("com.github.MilkBowl", "VaultAPI", "1.7.1")
    includeDependency("org.bstats", "bstats-bukkit", "3.0.2")
    includeDependency("org.bstats", "bstats-base", "3.0.2")

    // Platform dependencies
    includeDependency("io.papermc", "paperlib", "1.0.8")
    includeDependency("dev.notmyfault.serverlib", "ServerLib", "2.3.4")
}
