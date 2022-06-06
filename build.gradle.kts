import java.net.URI

plugins {
    `maven-publish`
    signing

    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"

    idea
    eclipse
}

group = "com.intellectualsites.bom"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
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
                description.set("Bill of materials for IntellectualSites projects")
                url.set("https://github.com/IntellectualSites/bom")

                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                        distribution.set("repo")
                    }
                }

                developers {
                    developer {
                        id.set("NotMyFault")
                        name.set("Alexander Brandes")
                    }
                }

                scm {
                    url.set("https://github.com/IntellectualSites/bom")
                    connection.set("scm:https://IntellectualSites@github.com/IntellectualSites/bom.git")
                    developerConnection.set("scm:git://github.com/IntellectualSites/bom.git")
                }

                issueManagement {
                    system.set("GitHub")
                    url.set("https://github.com/IntellectualSites/bom/issues")
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
