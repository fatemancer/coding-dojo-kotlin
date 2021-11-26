plugins {
    kotlin("jvm") version "1.6.0"
}

group = "ru.technicalExcellence.codingDojo"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}