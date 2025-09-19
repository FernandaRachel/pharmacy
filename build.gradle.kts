import org.springframework.boot.gradle.tasks.run.BootRun

group = "org.com"
version = "1.0-SNAPSHOT"
val springBootVersion = "3.2.5"

plugins {
    kotlin("jvm") version "2.1.10"
    id("application")
    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
    `kotlin-dsl`
}

// this create the 'run' in application
application { mainClass.set("org.com.pharmacy.MainKt") }
//application { mainClass.set("org.com.pharmacy.api.controller.PharmacyControllerKt") }
//application { mainClass.set("org.com.MainKt") }

tasks.named<BootRun>("bootRun") {
    mainClass.set("org.com.MainKt")
//    mainClass.set("org.com.pharmacy.api.controller.PharmacyControllerKt")
}

//springBoot {
//    mainClass.set("org.com.Main")
//}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")

    // DB
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion")
    implementation("org.hsqldb:hsqldb:2.7.2")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin") // Jackson extensions for Kotlin for working with JSON
    implementation("org.jetbrains.kotlin:kotlin-reflect") // Kotlin reflection library, required for working with Spring
    implementation("jakarta.validation:jakarta.validation-api:3.1.1")

    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    dependencies {
        dependencySet("org.slf4j:1.7.7") {
            entry("slf4j-api")
            entry("slf4j-simple")
        }
    }
}



tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}