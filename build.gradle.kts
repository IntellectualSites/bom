import java.net.URI

plugins {
    `maven-publish`
    signing

    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"

    idea
    eclipse
}

version = "1.0.0-SNAPSHOT"

allprojects {
    group = "com.intellectualsites"
    version = rootProject.version

    repositories {
        mavenCentral()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
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
            }
        }
    }
}

subprojects {
    apply {
        plugin<MavenPublishPlugin>()
        plugin<SigningPlugin>()

        plugin<IdeaPlugin>()
        plugin<EclipsePlugin>()
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

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(URI.create("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(URI.create("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
        }
    }
}
