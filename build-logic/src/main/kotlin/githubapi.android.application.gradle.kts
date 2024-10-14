import com.example.githubapi.configureComposeAndroid
import com.example.githubapi.configureKotlinAndroid
import com.example.githubapi.libs

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.compose")
}

android {
    configureKotlinAndroid(this)
    configureComposeAndroid(this)

    defaultConfig {
        targetSdk = 34
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