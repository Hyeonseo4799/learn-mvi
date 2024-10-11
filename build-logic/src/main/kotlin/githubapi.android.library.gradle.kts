import com.example.githubapi.configureKotlinAndroid
import com.example.githubapi.libs

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    configureKotlinAndroid(this)
}

dependencies {
    "implementation"(libs.findLibrary("androidx.core.ktx").get())
    "implementation"(libs.findLibrary("androidx.appcompat").get())
    "testImplementation"(libs.findLibrary("junit").get())
    "androidTestImplementation"(libs.findLibrary("androidx.junit").get())
    "androidTestImplementation"(libs.findLibrary("androidx.espresso.core").get())
}