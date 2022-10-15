import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.4"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	id("com.github.node-gradle.node") version "2.2.4"
}

group = "com.miniproject"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-mustache")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("jakarta.validation:jakarta.validation-api:2.0.2")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation(kotlin("test"))
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
	dependsOn("transpile")
}

task<com.moowork.gradle.node.npm.NpmTask>("transpile") {
	setNpmCommand("run", "transpile")
	dependsOn("prettier-format")
}

task<com.moowork.gradle.node.npm.NpmTask>("prettier-format") {
	setNpmCommand("run", "prettier-format")
	dependsOn("install")
}

task<com.moowork.gradle.node.npm.NpmTask>("install") {
	setNpmCommand("install")
}

node {
	download = true
	npmVersion = "6.14.6"
	nodeModulesDir = project.file("${project.projectDir}/src/main/frontend")
}
