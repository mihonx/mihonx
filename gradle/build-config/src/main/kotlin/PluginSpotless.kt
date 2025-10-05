/*
 * Copyright (C) 2025 AntsyLich and MihonX contributors.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */
import com.diffplug.gradle.spotless.SpotlessExtension
import mihonx.gradle.extensions.alias
import mihonx.gradle.extensions.libs
import mihonx.gradle.extensions.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal class PluginSpotless : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        plugins {
            alias(libs.plugins.spotless)
        }

        // Configuration should be synced with [/gradle/build-config/build.gradle.kts]
        val spotlessCopyrightKtFile = rootProject.file("./gradle/build-config/spotless/copyright.kt")
        spotless {
            val ktlintVersion = libs.ktlint.cli.get().version
            kotlin {
                target("src/**/*.kt")
                ktlint(ktlintVersion)
                licenseHeaderFile(spotlessCopyrightKtFile)
            }

            kotlinGradle {
                target("*.gradle.kts")
                ktlint(ktlintVersion)
                licenseHeaderFile(spotlessCopyrightKtFile, "(^(?![\\/ ]\\**).*$)")
            }
        }
    }
}

private fun Project.spotless(action: SpotlessExtension.() -> Unit) {
    extensions.configure(action)
}
