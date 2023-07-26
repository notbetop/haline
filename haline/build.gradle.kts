plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "top.notbe"
version = "1.0-alpha01"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm()
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.common) {
                    exclude("org.jetbrains.compose.material")
                }
                println()
            }
        }
        val jvmTest by getting
    }
}