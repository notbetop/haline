import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "top.notbe"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
    }
    @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs){
                    exclude("org.jetbrains.compose.material")
                }
//                implementation(compose.material3)
//                implementation(project(":haline"))
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "peter-record"
            packageVersion = "1.0.0"
        }
    }
}
