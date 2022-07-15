plugins {
    kotlin("jvm") version "1.7.0"
}

group = "ru.technicalExcellence.codingDojo"
version = "1.0"

repositories {
    mavenCentral()
}

val junitVersion = "5.8.2"
val mockitoVersion = "4.6.1"

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
