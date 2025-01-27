plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.rosahosseini.findr.data.db"
}

dependencies {
    implementation(project(":domain:model"))
    implementation("androidx.room:room-ktx:2.6.1")
    implementation("androidx.room:room-runtime:2.6.1")
    implementation(libs.roomCommon)
    ksp("androidx.room:room-compiler:2.6.1")
    implementation(libs.dataStore)
    implementation(libs.hiltAndroid)
    ksp(libs.hiltCompiler)
    testImplementation(libs.bundles.testCore)
}
