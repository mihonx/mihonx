/*
 * Copyright (C) 2025 AntsyLich and MihonX Open Source Project contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
import com.android.build.api.dsl.androidLibrary

plugins {
    alias(libs.plugins.kotlin.android.library)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.spotless)
}

kotlin {
    jvmToolchain(17)

    androidLibrary {
        namespace = "mihonx"
        compileSdk = 35
        minSdk = 21
    }
    jvm()
}

mavenPublishing {
    coordinates(
        groupId = "com.github.mihonx",
        artifactId = "mihonx",
        version = "1.0.0",
    )

    pom {
        name = "MihonX"
        description = "Extension API for Mihon"
        url = "https://github.com/mihonx/mihonx"
        inceptionYear = "2025"

        licenses {
            license {
                name = "Mozilla Public License Version 2.0"
                url = "https://www.mozilla.org/en-US/MPL/2.0"
                distribution = "repo"
            }
        }

        organization {
            name = "Mihon Extension Open Source Project"
            url = "https://github.com/mihonx"
        }

        developers {
            developer {
                id = "antsylich"
                name = "AntsyLich"
                url = "https://github.com/AntsyLich"
            }
        }

        scm {
            connection = "scm:git:git://github.com/mihonx/mihonx.git"
            url = "https://github.com/mihonx/mihonx"
        }
    }
}

spotless {
    val ktlintVersion = libs.ktlint.cli.get().version
    kotlin {
        target("src/**/*.kt")
        ktlint(ktlintVersion)
        licenseHeaderFile(rootProject.file("spotless/copyright.kt"))
    }

    kotlinGradle {
        target("*.kts")
        ktlint(ktlintVersion)
        licenseHeaderFile(rootProject.file("spotless/copyright.kt"), "(^(?![\\/ ]\\**).*$)")
    }
}
