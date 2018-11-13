package com.cognifide.gradle.sling.pkg

import com.cognifide.gradle.sling.base.BasePlugin
import com.cognifide.gradle.sling.pkg.deploy.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.language.base.plugins.LifecycleBasePlugin

class PackagePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project, {
            setupDependentPlugins()
            setupTasks()
        })
    }

    private fun Project.setupDependentPlugins() {
        plugins.apply(BasePlugin::class.java)
    }

    private fun Project.setupTasks() {
        val clean = tasks.getByName(LifecycleBasePlugin.CLEAN_TASK_NAME)

        val prepare = tasks.create(PrepareTask.NAME, PrepareTask::class.java)
        val compose = tasks.create(ComposeTask.NAME, ComposeTask::class.java)
        val upload = tasks.create(UploadTask.NAME, UploadTask::class.java)
        tasks.create(DeleteTask.NAME, DeleteTask::class.java)
        tasks.create(PurgeTask.NAME, PurgeTask::class.java)
        val install = tasks.create(InstallTask.NAME, InstallTask::class.java)
        tasks.create(UninstallTask.NAME, UninstallTask::class.java)
        val deploy = tasks.create(DeployTask.NAME, DeployTask::class.java)

        val assemble = tasks.getByName(LifecycleBasePlugin.ASSEMBLE_TASK_NAME)
        val check = tasks.getByName(LifecycleBasePlugin.CHECK_TASK_NAME)
        val build = tasks.getByName(LifecycleBasePlugin.BUILD_TASK_NAME)

        assemble.mustRunAfter(clean)
        check.mustRunAfter(clean)
        build.dependsOn(compose)

        prepare.mustRunAfter(clean)

        compose.dependsOn(prepare, assemble, check)
        compose.mustRunAfter(clean)

        upload.dependsOn(compose)
        install.mustRunAfter(compose, upload)

        deploy.dependsOn(compose)
    }

    companion object {
        const val ID = "com.cognifide.sling.package"

        const val META_PATH = "META-INF"

        const val VLT_PATH = "$META_PATH/vault"

        const val VLT_PROPERTIES = "$VLT_PATH/properties.xml"

        const val JCR_ROOT = "jcr_root"
    }

}