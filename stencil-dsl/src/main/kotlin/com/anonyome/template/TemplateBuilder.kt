package com.anonyome.template

typealias TemplateBuilderBlock = TemplateBuilder.() -> Unit

class TemplateBuilder {
    private val children = mutableListOf<Template>()

    operator fun Template.unaryPlus() {
        children.add(this)
    }

    fun build(): List<Template> = children

    infix fun String.file(withContents: String?) = +Template.File(
        this,
        withContents
    )

    infix fun String.dir(builder: TemplateBuilderBlock) = +Template.Dir(
        this,
        buildTemplate(builder)
    )

    /**
     * @param named fully qualified package path to be created, e.g. (com.example.feature)
     */
    infix fun String.srcPackage(builder: TemplateBuilderBlock) {
        val pathParts = split(".").toMutableList()

        // start at the bottom and work our way up
        val finalDirName = pathParts.run { removeAt(lastIndex) }
        val finalDir = Template.Dir(finalDirName, buildTemplate(builder))

        // add the generated folder hierarchy to the builder
        + pathParts.foldRight(finalDir) { parentName, childDir ->
            Template.Dir(parentName, listOf(childDir))
        }
    }
}

fun buildTemplate(builder: TemplateBuilderBlock): List<Template> = TemplateBuilder().apply { builder() }.build()

fun TemplateBuilder.file(named: String, withContents: String? = null) = +Template.File(
    named,
    withContents
)

fun TemplateBuilder.dir(named: String, builder: TemplateBuilderBlock = {}) = +Template.Dir(
    named,
    buildTemplate(builder)
)