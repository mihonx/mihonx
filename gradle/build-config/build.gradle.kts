/*
 * Copyright (C) 2025 AntsyLich and MihonX contributors.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.samWithReceiver)
    alias(libs.plugins.spotless)
    alias(libs.plugins.detekt)
    `java-gradle-plugin`
}

// Configuration should be synced with [/gradle/build-config/src/main/kotlin/PluginSpotless.kt]
val editorConfigFile = rootProject.file("../../.editorconfig")
val spotlessCopyrightKtFile = rootProject.file("./spotless/copyright.kt")
spotless {
    val ktlintVersion = libs.ktlint.cli.get().version
    kotlin {
        target("src/**/*.kt")
        ktlint(ktlintVersion).setEditorConfigPath(editorConfigFile)
        licenseHeaderFile(spotlessCopyrightKtFile)
    }

    kotlinGradle {
        target("*.gradle.kts")
        ktlint(ktlintVersion).setEditorConfigPath(editorConfigFile)
        licenseHeaderFile(spotlessCopyrightKtFile, "(^(?![\\/ ]\\**).*$)")
    }
}

val detektConfigFile = rootProject.file("detekt/config.yml")
detekt {
    config.setFrom(detektConfigFile)
    buildUponDefaultConfig = true
}

dependencies {
    compileOnly(gradleKotlinDsl())
    implementation(libs.android.gradle)
    implementation(libs.compatPatrouille.gradle)
    implementation(libs.detekt.gradle)
    implementation(libs.kotlin.gradle)
    implementation(libs.maven.publish.gradle)
    implementation(libs.spotless.gradle)

    // These allow us to reference the dependency catalog inside of our compiled plugins
    compileOnly(files(libs::class.java.superclass.protectionDomain.codeSource.location))
    compileOnly(files(mihonx::class.java.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("detekt") {
            id = mihonx.plugins.detekt.get().pluginId
            implementationClass = "PluginDetekt"
        }
        register("kotlin-multiplatform") {
            id = mihonx.plugins.kotlin.multiplatform.get().pluginId
            implementationClass = "PluginKotlinMultiplatform"
        }
        register("maven-publish") {
            id = mihonx.plugins.maven.publish.get().pluginId
            implementationClass = "PluginMavenPublish"
        }
        register("spotless") {
            id = mihonx.plugins.spotless.get().pluginId
            implementationClass = "PluginSpotless"
        }
    }
}

samWithReceiver {
    annotation("org.gradle.api.HasImplicitReceiver")
}
