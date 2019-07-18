import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.41")
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
