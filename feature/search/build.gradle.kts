plugins {
    id("githubapi.android.feature")
}

android {
    namespace = "com.example.search"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    implementation(project(":core:domain"))
    implementation(project(":core:model"))

    implementation(libs.orbit.core)
    implementation(libs.orbit.compose)
    implementation(libs.orbit.viewmodel)

    implementation(libs.paging.runtime)
    implementation(libs.paging.compose)

    implementation(libs.hilt.navigation.compose)

    implementation(libs.landscapist.glide)
}