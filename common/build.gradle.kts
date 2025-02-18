plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.serialization)
}

val applicationId: String by rootProject.extra
val javaVersion: JavaVersion by rootProject.extra

android {
    compileSdk = libs.versions.androidCompileSdk.get().toInt()
    namespace = "${applicationId}.common"

    defaultConfig {
        minSdk = libs.versions.androidMinSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of(javaVersion.majorVersion))
        }
    }
}

dependencies {
    implementation(libs.timber)
}
