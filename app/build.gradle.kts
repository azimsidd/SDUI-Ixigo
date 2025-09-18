plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)

    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.thecodingshef.testixigo"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.thecodingshef.sduiIxigo"
        minSdk = 24
        targetSdk = 36
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
    implementation(libs.gson)


    implementation("androidx.compose.material:material-icons-extended:1.7.8")
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.cronet.embedded)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)


    ksp(libs.hilt.compiler)

    implementation(libs.hilt.android)

    implementation(libs.hilt.navigation.compose)
    implementation(libs.hilt.lifecycle.viewmodel)

    implementation(libs.androidx.appcompat)



    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    implementation(libs.logging.interceptor)


    implementation("androidx.compose.ui:ui-text-google-fonts:1.8.3")

    implementation("com.ibm.icu:icu4j:77.1")

    debugImplementation(libs.chucker.debug)


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.navigation:navigation-compose:2.7.6")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.8")

// Room Database
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")

// CameraX
    implementation("androidx.camera:camera-camera2:1.3.1")
    implementation("androidx.camera:camera-lifecycle:1.3.1")
    implementation("androidx.camera:camera-view:1.3.1")

// Permissions
    implementation("com.google.accompanist:accompanist-permissions:0.32.0")

// Image loading
    implementation("io.coil-kt:coil-compose:2.5.0")

// Material icons for Compose (used in speech recognition UI, etc.)
    implementation("androidx.compose.material:material-icons-extended")

    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")

    implementation("com.yandex.div:div:32.17.0")
    implementation("com.yandex.div:div-core:32.17.0")
    implementation("com.yandex.div:div-json:32.17.0")
    implementation("com.yandex.div:picasso:32.17.0")


    implementation ("com.github.bumptech.glide:glide:5.0.5")
    annotationProcessor ("com.github.bumptech.glide:compiler:5.0.5")


    implementation("com.squareup.picasso:picasso:2.71828")

    // Or for Coil
    implementation("io.coil-kt:coil-compose:2.7.0")
    // Kotlinx Serialization (JSON handling)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.compose.navigation)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.coil.svg)
    implementation(libs.material)
}