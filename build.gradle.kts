import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.2"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	kotlin("jvm") version "1.7.10"
	kotlin("plugin.spring") version "1.6.21"

	/* Kotlin serialization plugin */
	//kotlin("plugin.serialization") version "1.7.10"
}

group = "com.asavio"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-graphql")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	/* Kotlin serialization */
	//implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0-RC")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework:spring-webflux")
	testImplementation("org.springframework.graphql:spring-graphql-test")
}

/*configurations.all {
	exclude(group = "com.fasterxml.jackson.core", module = "jackson-databind")
	exclude(group = "com.fasterxml.jackson.datatype", module = "jackson-datatype-jdk8")
	exclude(group = "com.fasterxml.jackson.datatype", module = "jackson-datatype-jsr310")
	exclude(group = "com.fasterxml.jackson.module", module = "jackson-module-parameter-names")
	exclude(group = "com.fasterxml.jackson.module", module = "jackson-module-kotlin")
}*/

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
