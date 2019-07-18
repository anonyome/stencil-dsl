package com.anonyome.template.gradle

import com.anonyome.template.TemplateBuilder
import com.anonyome.template.TemplateBuilderBlock

fun TemplateBuilder.src(builder: TemplateBuilderBlock) = "src" dir builder
fun TemplateBuilder.main(builder: TemplateBuilderBlock) = "main" dir builder
fun TemplateBuilder.test(builder: TemplateBuilderBlock) = "test" dir builder
fun TemplateBuilder.androidTest(builder: TemplateBuilderBlock) = "androidTest" dir builder

fun TemplateBuilder.java(builder: TemplateBuilderBlock) = "java" dir builder
fun TemplateBuilder.kotlin(builder: TemplateBuilderBlock) = "kotlin" dir builder

fun TemplateBuilder.res(builder: TemplateBuilderBlock) = "res" dir builder
fun TemplateBuilder.layout(builder: TemplateBuilderBlock) = "layout" dir builder
fun TemplateBuilder.values(builder: TemplateBuilderBlock) = "values" dir builder

fun TemplateBuilder.resources(builder: TemplateBuilderBlock) = "resources" dir builder