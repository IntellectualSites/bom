import java.net.URI

plugins {
    `maven-publish`
    signing

    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"

    idea
    eclipse
}

version = "1.5-SNAPSHOT"

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

    publishing {
        publications {
            create<MavenPublication>("maven") {
                pom {
                    name.set(project.name + " " + project.version)
                    description.set("Bill of materials for IntellectualSites projects.")
                    url.set("https://github.com/IntellectualSites/bom")

                    licenses {
                        license {
                            name.set("GNU General Public License, Version 3.0")
                            url.set("https://www.gnu.org/licenses/gpl-3.0.html")
                            distribution.set("repo")
                        }
                    }

                    developers {
                        developer {
                            id.set("NotMyFault")
                            name.set("Alexander Brandes")
                            organization.set("IntellectualSites")
                            email.set("contact@notmyfault.dev")
                        }
                    }

                    scm {
                        url.set("https://github.com/IntellectualSites/bom")
                        connection.set("scm:https://IntellectualSites@github.com/IntellectualSites/bom.git")
                        developerConnection.set("scm:git://github.com/IntellectualSites/bom.git")
                    }

                    issueManagement{
                        system.set("GitHub")
                        url.set("https://github.com/IntellectualSites/bom/issues")
                    }
                }
            }
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
