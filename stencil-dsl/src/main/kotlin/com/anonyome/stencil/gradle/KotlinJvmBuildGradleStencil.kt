@file:Suppress("FunctionName")

package com.anonyome.stencil.gradle

fun KotlinJvmBuildGradleStencil(
        group: String,
        kotlinVersion: String
) =
//language=kotlin
"""
import org.gradle.api.JavaVersion.VERSION_1_8

plugins {
    id("kotlin")
    `java-library`
    jacoco
}

group = $group
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
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
}

tasks.named("jacocoTestReport").configure { dependsOn("test") }
"""