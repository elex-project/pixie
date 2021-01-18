plugins {
	id("base-common")
	`java-library`
	`maven-publish`
}
java {
	sourceCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
	targetCompatibility = org.gradle.api.JavaVersion.VERSION_1_8
}
tasks.jar {
	manifest {
		attributes(mapOf(
				"Implementation-Title" to project.name,
				"Implementation-Version" to project.version,
				"Implementation-Vendor" to "ELEX co.,pte.",
				"Automatic-Module-Name" to "com.elex_project.pixie"
		))
	}
}
publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			from(components["java"])
			pom {
				name.set("Barcode")
				description.set(project.description)
				url.set("https://github.com/elex-project/pixie")
				properties.set(mapOf(
						"year" to "2021"
				))
				licenses {
					license {
						name.set("Apache License 2.0")
						url.set("https://github.com/elex-project/pixie/blob/main/LICENSE")
					}
				}
				developers {
					developer {
						id.set("elex-project")
						name.set("Elex")
						email.set("developer@elex-project.com")
					}
				}
				scm {
					connection.set("scm:git:https://github.com/elex-project/pixie.git")
					developerConnection.set("scm:git:https://github.com/elex-project/pixie.git")
					url.set("https://github.com/elex-project/pixie")
				}
			}
		}
	}

	repositories {
		maven {
			name = "mavenElex"
			val urlRelease = uri("https://repository.elex-project.com/repository/maven-releases")
			val urlSnapshot = uri("https://repository.elex-project.com/repository/maven-snapshots")
			url = if (version.toString().endsWith("SNAPSHOT")) urlSnapshot else urlRelease
			// Repository credential, Must be defined in ~/.gradle/gradle.properties
			credentials {
				username = project.findProperty("repo.username") as String
				password = project.findProperty("repo.password") as String
			}
		}
		maven {
			name = "mavenGithub"
			url = uri("https://maven.pkg.github.com/elex-project/pixie")
			credentials {
				username = project.findProperty("github.username") as String
				password = project.findProperty("github.token") as String
			}
		}
	}
}
dependencies {

}
