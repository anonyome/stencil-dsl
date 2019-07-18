@file:Suppress("FunctionName")

package com.anonyome.stencil.gradle

fun RootBuildGradleStencil(
        kotlinVersion: String
) =
//language=kotlin
"""
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    tasks.withType<Test> {
        testLogging {
            events(
                    TestLogEvent.FAILED,
                    TestLogEvent.PASSED,
                    TestLogEvent.SKIPPED,
                    TestLogEvent.STANDARD_ERROR,
                    TestLogEvent.STANDARD_OUT
            )

            exceptionFormat = TestExceptionFormat.FULL

            showCauses = true
            showExceptions = true
            showStackTraces = true
        }
    }
}
"""