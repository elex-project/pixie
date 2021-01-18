plugins {
    id ("base-application")
}

application{
    mainClass.set("com.elex_project.pixie.app.Application")
}

dependencies {
    implementation("com.elex-project:jazz:1.1.0")
}
