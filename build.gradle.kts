import java.net.URI

plugins {
    `maven-publish`
    signing

    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"

    idea
    eclipse
}

version = "1.0"

subprojects {
    apply {
        plugin<MavenPublishPlugin>()
        plugin<SigningPlugin>()

        plugin<IdeaPlugin>()
        plugin<EclipsePlugin>()
    }
}

allprojects {
    group = "com.intellectualsites.bom"
    version = rootProject.version

    repositories {
        mavenCentral()
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven {
            url = uri("https://jitpack.io")
            content {
                includeModule("com.github.MilkBowl", "VaultAPI")
            }
        }
        maven {
            url = uri("https://repo.papermc.io/repository/maven-public/")
            content {
                includeModule("io.papermc", "paperlib")
                includeModule("io.papermc.paper", "paper-api")
            }
        }
    }

    signing {
        if (!version.toString().endsWith("-SNAPSHOT")) {
            val signingKey: String? by project
            val signingPassword: String? by project
            useInMemoryPgpKeys(signingKey, signingPassword)
            signing.isRequired
            sign(publishing.publications)
        }
    }
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(URI.create("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(URI.create("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
        }
    }
}
