import com.example.githubapi.configureComposeAndroid
import com.example.githubapi.libs

plugins {
    id("githubapi.android.library")
    id("githubapi.android.hilt")
    kotlin("plugin.compose")
}

android {
    configureComposeAndroid(this)

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    "implementation"(project(":core:navigation"))

    "implementation"(libs.findLibrary("androidx-navigation").get())

    "implementation"(libs.findLibrary("androidx.core.ktx").get())
    "implementation"(libs.findLibrary("androidx.appcompat").get())
    "testImplementation"(libs.findLibrary("junit").get())
    "androidTestImplementation"(libs.findLibrary("androidx.junit").get())
    "androidTestImplementation"(libs.findLibrary("androidx.espresso.core").get())
}