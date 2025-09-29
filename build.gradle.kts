import org.springframework.boot.gradle.tasks.run.BootRun

group = "org.com"
version = "1.0-SNAPSHOT"
val springBootVersion = "3.2.5"

plugins {
    kotlin("jvm") version "2.0.21"
    id("application")
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.jetbrains.kotlin.plugin.spring") version "2.0.21" // so configuration class are automatically open

    `kotlin-dsl`
}

kotlin {
    jvmToolchain(21)
}

// this create the 'run' in application
application { mainClass.set("org.com.MainKt") }

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // web
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")

    // DB
    // Hibernate + JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion") // depends on jakarta

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin") // Jackson extensions for Kotlin for working with JSON
    implementation("org.jetbrains.kotlin:kotlin-reflect") // Kotlin reflection library, required for working with Spring
    implementation("jakarta.validation:jakarta.validation-api:3.1.1")

    // HTTP
    implementation("com.squareup.okhttp3:okhttp:4.9.2")

    // Log
    implementation("org.slf4j:slf4j-simple:2.0.9")

//    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.mysql:mysql-connector-j:8.3.0") // ✅ MySQL driver

    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

configurations.all {
    exclude(group = "ch.qos.logback", module = "logback-classic")
}

tasks.register<Exec>("dockerUp") {
    commandLine("/opt/homebrew/bin/docker", "compose", "-f",
        rootProject.file("config/docker/docker-compose.yml").absolutePath,
        "up", "-d")
}

tasks.named<BootRun>("bootRun") {
    dependsOn("dockerUp")
    mainClass.set("org.com.MainKt")
}

tasks.test {
    useJUnitPlatform()
}



//dependencyManagement {
//    dependencies {
//        dependencySet("org.slf4j:1.7.7") {
//            entry("slf4j-api")
//            entry("slf4j-simple")
//        }
//    }
//}
