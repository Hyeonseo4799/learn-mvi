package com.example.githubapi

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


internal fun Project.configureComposeAndroid(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }
    }

    dependencies {
        val bom = libs.findLibrary("androidx-compose-bom").get()
        add("implementation", platform(bom))

        add("implementation", libs.findLibrary("androidx-compose-ui").get())
        add("implementation", libs.findLibrary("androidx-compose-ui-tooling").get())
        add("implementation", libs.findLibrary("androidx-compose-ui-tooling-preview").get())
        add("implementation", libs.findLibrary("androidx-activity-compose").get())
        add("implementation", libs.findLibrary("androidx-compose-material3").get())
    }
}