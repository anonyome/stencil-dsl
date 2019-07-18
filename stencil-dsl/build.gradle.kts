import org.gradle.api.JavaVersion.VERSION_1_8

plugins {
    `java-library`
    jacoco
    id("kotlin")
}

group = "com.anonyome.stencil"
version = "0.0.0"

repositories {
    mavenCentral()
    google()
    jcenter()
}

java {
    sourceCompatibility = VERSION_1_8
}

dependencies {
    implementation(Require.kotlin.stdlibJdk8)
}

tasks.named("jacocoTestReport").configure { dependsOn("test") }
