import org.gradle.kotlin.dsl.`kotlin-dsl`

repositories {
    google()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
    jcenter()
}

plugins {
    `kotlin-dsl`
}