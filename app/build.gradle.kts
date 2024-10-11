plugins {
    id("githubapi.android.application")
    id("githubapi.android.hilt")
}

android {
    namespace = "com.example.githubapi"

    defaultConfig {
        applicationId = "com.example.githubapi"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    implementation(project(":feature:main"))

    implementation(libs.androidx.activity)

    implementation(libs.material)
}