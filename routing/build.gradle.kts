plugins {
	kotlin("jvm") version "1.3.60"
	id("org.jetbrains.kotlin.plugin.serialization") version "1.3.60"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
	jcenter()
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.14.0")
	implementation("io.ktor:ktor-client-cio:1.3.0")
	implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.60")
	implementation("org.jetbrains.kotlin:kotlin-serialization:1.3.60")
	implementation("io.ktor:ktor-client-json-jvm:1.3.0")
	implementation("io.ktor:ktor-client-serialization-jvm:1.3.0")
}

tasks {
	compileKotlin {
		kotlinOptions.jvmTarget = "1.8"
	}
	compileTestKotlin {
		kotlinOptions.jvmTarget = "1.8"
	}
}
