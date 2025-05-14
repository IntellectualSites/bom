import com.vanniktech.maven.publish.SonatypeHost
import java.net.URI

plugins {
    signing

    id("com.vanniktech.maven.publish") version "0.32.0"

    idea
    eclipse
}

version = "1.54-SNAPSHOT"

subprojects {
    apply {
        plugin<com.vanniktech.maven.publish.MavenPublishPlugin>()
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
            url = uri("https://maven.enginehub.org/repo")
            content {
                includeGroup("org.enginehub")
                includeGroup("com.sk89q")
            }
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
                includeModule("io.papermc.paper", "paper-api")
            }
        }
    }

    signing {
        if (!project.hasProperty("skip.signing") && !version.toString().endsWith("-SNAPSHOT")) {
            val signingKey: String? by project
            val signingPassword: String? by project
            useInMemoryPgpKeys(signingKey, signingPassword)
            signing.isRequired
            sign(publishing.publications)
        }
    }

    mavenPublishing {

        coordinates(
            groupId = "$group",
            artifactId = project.name,
            version = "${project.version}",
        )

        pom {
            name.set(project.name)
            description.set("Bill of materials for IntellectualSites projects.")
            url.set("https://github.com/IntellectualSites/bom")

            licenses {
                license {
                    name.set("The MIT License")
                    url.set("https://opensource.org/licenses/MIT")
                    distribution.set("repo")
                }
            }

            developers {
                developer {
                    id.set("NotMyFault")
                    name.set("Alexander Brandes")
                    organization.set("IntellectualSites")
                    organizationUrl.set("https://github.com/IntellectualSites/")
                    email.set("contact(at)notmyfault.dev")
                }
            }

            scm {
                url.set("https://github.com/IntellectualSites/bom")
                connection.set("scm:git:https://github.com/IntellectualSites/bom.git")
                developerConnection.set("scm:git:git@github.com:IntellectualSites/bom.git")
                tag.set("${project.version}")
            }

            issueManagement{
                system.set("GitHub")
                url.set("https://github.com/IntellectualSites/bom/issues")
            }
        }
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    }
}
