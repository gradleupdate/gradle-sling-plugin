package com.cognifide.gradle.aem.base.vlt

import com.cognifide.gradle.aem.api.AemTask
import com.cognifide.gradle.aem.internal.PropertyParser
import com.cognifide.gradle.aem.internal.file.FileOperations
import org.gradle.api.Project
import java.io.Closeable
import java.io.File

class VltFilter(val file: File, private val temporary: Boolean = false) : Closeable {

    companion object {

        fun temporary(project: Project, paths: List<String>): VltFilter {
            val template = FileOperations.readResource("vlt/temporaryFilter.xml")!!
                    .bufferedReader().use { it.readText() }
            val content = PropertyParser(project).expand(template, mapOf("paths" to paths))
            val file = AemTask.temporaryFile(project, VltTask.NAME, "temporaryFilter.xml")

            file.printWriter().use { it.print(content) }

            return VltFilter(file, true)
        }

    }

    override fun close() {
        if (temporary) {
            file.delete()
        }
    }

}