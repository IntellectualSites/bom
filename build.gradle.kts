import java.net.URI

plugins {
    `maven-publish`
    signing

    id("io.github.gradle-nexus.publish-plugin") version "2.0.0"

    idea
    eclipse
}

version = "1.46-SNAPSHOT"

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
        if (!project.hasProperty("skip.signing") && !version.toString().endsWith("-SNAPSHOT")) {
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
            }
        }
    }
}

nexusPublishing {
    this.repositories {
        sonatype {
            nexusUrl.set(URI.create("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(URI.create("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
        }
    }
}
