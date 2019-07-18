@file:Suppress("FunctionName")

package com.anonyome.stencil.gradle

import com.anonyome.stencil.buildTemplate

fun KotlinGradleProject(
        group: String,
        packageName: String,
        kotlinVersion:String = "1.3.14"
) = buildTemplate {
    "project-templates-kotlin-dsl" dir {
        "project-templates-plugin" dir {
            "build.gradle.kts" file KotlinJvmBuildGradleStencil(
                    group = group,
                    kotlinVersion = kotlinVersion
            )
            src {
                main {
                    kotlin {
                        packageName srcPackage { }
                    }
                }
                test {
                    kotlin {
                        packageName srcPackage { }
                    }
                }
            }
        }

        // root project files
        ".gitignore" file KotlinGradleGitIgnoreStencil()
        "build.gradle.kts" file RootBuildGradleStencil(
                kotlinVersion = kotlinVersion
        )
        "README.md" file "Project Templates Kotlin DSL\n==="
        "settings.gradle.kts" file SettingsGradleTemplate("project-templates-plugin")
    }
}.first()