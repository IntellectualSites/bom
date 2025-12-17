plugins {
    id("io.github.gradlebom.generator-plugin") version "1.0.0.Final"
}

bomGenerator {
    // FastAsyncWorldEdit, PlotSquared, etc. serve a bom on its on, which we don't want here
    excludeProject("bom-1.16.x")
    excludeProject("bom-newest")

    // Native Minecraft dependencies - locked at the version the game uses
    includeDependency("org.yaml", "snakeyaml", "2.2")
    includeDependency("com.google.code.gson", "gson", "2.11.0")
    includeDependency("com.google.guava", "guava", "33.3.1-jre")
    // Introduced by Paper
    includeDependency("org.apache.logging.log4j", "log4j-api", "2.24.1")

    // Paper
    includeDependency("io.papermc.paper", "paper-api", "1.21.5-no-moonrise-SNAPSHOT")

    // Third party dependencies
    includeDependency("org.checkerframework", "checker-qual", "3.52.1")
    // Adventure & Minimessage
    includeDependency("net.kyori", "adventure-api", "4.26.1")
    includeDependency("net.kyori", "adventure-text-minimessage", "4.26.1")
    includeDependency("net.kyori", "adventure-platform-bukkit", "4.4.1")

    // IntellectualSites plugins
    includeDependency("com.intellectualsites.plotsquared", "plotsquared-core", "7.5.10")
    includeDependency("com.intellectualsites.plotsquared", "plotsquared-bukkit", "7.5.10")
    includeDependency("com.fastasyncworldedit", "FastAsyncWorldEdit-Core", "2.14.2")
    includeDependency("com.fastasyncworldedit", "FastAsyncWorldEdit-Bukkit", "2.14.2")

    // IntellectualSites libraries
    includeDependency("com.intellectualsites.paster", "Paster", "1.1.7")
    includeDependency("com.intellectualsites.informative-annotations", "informative-annotations", "1.6")

    // Plugin dependencies
    includeDependency("com.github.MilkBowl", "VaultAPI", "1.7.1")
    includeDependency("org.bstats", "bstats-bukkit", "3.1.0")
    includeDependency("org.bstats", "bstats-base", "3.1.0")

    // Platform dependencies
    includeDependency("io.papermc", "paperlib", "1.0.8")
    includeDependency("dev.notmyfault.serverlib", "ServerLib", "2.3.7")
}
