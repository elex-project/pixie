import gradle.kotlin.dsl.accessors._683557702394105647b122afeeebaf6d.java

plugins {
	java
}

group = "com.elex-project"
version = "1.1.0"
description = "2D/1D Barcode Generator"

repositories {
	maven {
		url = uri("https://repository.elex-project.com/repository/maven")
	}
}

configurations {
	compileOnly {
		extendsFrom(annotationProcessor.get())
	}
	testCompileOnly {
		extendsFrom(testAnnotationProcessor.get())
	}
}
java {
	withSourcesJar()
	withJavadocJar()
}
tasks.compileJava {
	options.encoding = "UTF-8"
}

tasks.compileTestJava {
	options.encoding = "UTF-8"
}

tasks.test {
	useJUnitPlatform()
}

tasks.javadoc {
	if (JavaVersion.current().isJava9Compatible) {
		(options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
	}
	(options as StandardJavadocDocletOptions).encoding = "UTF-8"
	(options as StandardJavadocDocletOptions).charSet = "UTF-8"
	(options as StandardJavadocDocletOptions).docEncoding = "UTF-8"

}

dependencies {
	implementation("org.slf4j:slf4j-api:1.7.30")
	implementation("org.jetbrains:annotations:20.1.0")

	implementation("com.elex-project:abraxas:4.0.3")

	compileOnly("org.projectlombok:lombok:1.18.16")
	annotationProcessor("org.projectlombok:lombok:1.18.16")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.16")

	testImplementation("ch.qos.logback:logback-classic:1.2.3")
	testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}
