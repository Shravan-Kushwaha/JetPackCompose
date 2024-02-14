// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    /*ext{
         compose_ui_version = "1.1.1"
    }*/
    dependencies {
        classpath (libs.kotlin.gradle.plugin)
        classpath (libs.hilt.android.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.devtoolsKsp) apply false
}