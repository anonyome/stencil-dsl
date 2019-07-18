@file:Suppress("FunctionName")

package com.anonyome.stencil.gradle

fun KotlinGradleGitIgnoreStencil() =
//language=.gitignore
"""
### Kotlin
# Compiled class file
*.class

# Log file
*.log

# BlueJ files
*.ctxt

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar

# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml
hs_err_pid*

### Gradle
.gradle
**/build/
**/out

# Ignore Gradle GUI config
gradle-app.setting

# Avoid ignoring Gradle wrapper jar file (.jar files are usually ignored)
!gradle-wrapper.jar

# Cache of project
.gradletasknamecache

.idea
*.iml

secret.properties

# for Android Studio
local.properties
""".trimIndent()