package com.cognifide.gradle.aem.instance

import com.cognifide.gradle.aem.pkg.deploy.SyncTask
import org.gradle.api.tasks.TaskAction

open class DownTask : SyncTask() {

    companion object {
        val NAME = "aemDown"
    }

    init {
        description = "Turns off local AEM instance(s)."
    }

    @TaskAction
    fun down() {
        val instances = Instance.locals(project)
        synchronizeLocalInstances(instances, { it.down() })

        notifier.default("Instance(s) down", instances.joinToString(", ") { it.name })
    }

}