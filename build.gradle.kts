/*
 * Copyright (C) 2025 AntsyLich and MihonX Open Source Project contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
plugins {
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.maven.publish) apply false

    alias(libs.plugins.spotless)
}

spotless {
    val ktlintVersion = libs.ktlint.cli.get().version
    kotlin {
        target("src/**/*.kt")
        ktlint(ktlintVersion)
        licenseHeaderFile(rootProject.file("spotless/copyright.kt.txt"))
    }

    kotlinGradle {
        target("*.kts")
        ktlint(ktlintVersion)
        licenseHeaderFile(rootProject.file("spotless/copyright.kt.txt"), "(^(?![\\/ ]\\**).*$)")
    }
}
