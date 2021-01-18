plugins {
	id("base-common")
	application
}
java {
	sourceCompatibility = org.gradle.api.JavaVersion.VERSION_11
	targetCompatibility = org.gradle.api.JavaVersion.VERSION_11
}
tasks.jar {
	manifest {
		attributes(mapOf(
				"Implementation-Title" to project.name,
				"Implementation-Version" to project.version,
				"Implementation-Vendor" to "ELEX co.,pte."
		))
	}
}
dependencies {
	project(":lib")
}
