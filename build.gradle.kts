import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// NOTE: If you change a version, make sure to update the plugin version as well (if applicable).
val jacksonVersion: String by extra { "2.10.3" }
val jUnitVersion: String by extra { "5.5.2" }
val kotlinCoroutinesReactorVersion: String by extra { "1.3.5" }
val kotlinVersion: String by extra { "1.3.71" }
val reactorVersion: String by extra { "1.0.2.RELEASE" }
val reactorTestSupportVersion: String by extra { "3.3.4.RELEASE" }
val springBootVersion: String by extra { "2.2.6.RELEASE" }
val springKafkaVersion: String by extra { "2.4.4.RELEASE" }

plugins {
	id("org.springframework.boot") version "2.2.6.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	id("org.jmailen.kotlinter") version "2.3.2"
	kotlin("jvm") version "1.3.71"
	kotlin("plugin.spring") version "1.3.71"
}

group = "com.coffeeculture"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_14

val developmentOnly by configurations.creating
configurations {
	runtimeClasspath {
		extendsFrom(developmentOnly)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator:$springBootVersion")
	implementation("org.springframework.boot:spring-boot-starter-webflux:$springBootVersion")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:$reactorVersion")
	implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:$kotlinCoroutinesReactorVersion")
	implementation("org.springframework.kafka:spring-kafka:$springKafkaVersion")
	developmentOnly("org.springframework.boot:spring-boot-devtools:$springBootVersion")
	testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("io.projectreactor:reactor-test:$reactorTestSupportVersion")
	testImplementation("org.springframework.kafka:spring-kafka-test:$springKafkaVersion")
}

tasks.withType<Test> {
	useJUnitPlatform()

	// Show more feeback for tests. Default behavior only reports failures.
	testLogging {
		events("passed", "skipped", "failed")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
