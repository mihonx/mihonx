/*
 * Copyright (C) 2025 AntsyLich and MihonX contributors.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */
package mihonx.auth

import kotlinx.coroutines.flow.Flow
import mihonx.auth.models.AuthSession

/**
 * A sealed interface for providing different authentication methods.
 *
 * Implement one or more of the sub-interfaces, [OAuth] or [UserInput], to offer
 * different ways for a user to log in.
 */
public sealed interface Auth {

    /**
     * The current authentication session, or `null` if not authenticated.
     */
    public val session: AuthSession?

    /**
     * A flow that emits the authentication session, used to observe changes.
     */
    public val sessionFlow: Flow<AuthSession?>

    /**
     * Logs the user out of the current session.
     */
    public fun logout()

    /**
     * For OAuth-based authentication. This is presented as a single login option.
     */
    public interface OAuth : Auth {

        /**
         * Returns the OAuth authorization URL.
         *
         * @param state `state` query parameter for the URL. Used to maintain state between the request and callback.
         * @return The OAuth authorization URL.
         */
        public fun getOAuthUrl(state: String): String

        /**
         * Handles the OAuth callback after the user has authorized the application.
         *
         * @param data A map of data received from the OAuth callback.
         * @return `true` if the authentication was successful.
         */
        public suspend fun onOAuthCallback(data: Map<String, String?>): Boolean
    }

    /**
     * For authentication using user-provided input. Each [Form] in [forms] is presented as a single login option.
     */
    public interface UserInput : Auth {

        /**
         * A list of forms, each representing a login option (e.g., "Username and Password", "Access Token").
         *
         * For a single option, use the [Auth.form] helper.
         */
        public val forms: List<Form>

        /**
         * Attempts to log in with the given form data.
         *
         * @param formKey The key of the submitted form.
         * @param data A map of data from the input fields.
         * @return `true` if the login was successful.
         */
        public suspend fun onLogin(formKey: String, data: Map<String, String?>): Boolean
    }

    /**
     * Represents a form for user input, corresponding to a single login option.
     *
     * @property key A unique identifier for the form.
     * @property icon An icon for this login option.
     * @property label The name of this login option.
     * @property fields A list of input fields in the form.
     */
    public data class Form(
        val key: String,
        val icon: Icon,
        val label: String,
        val fields: List<InputField>,
    ) {
        /**
         * An enum representing icons for the form.
         */
        public enum class Icon {
            Username,
            Password,
            Misc,
        }
    }

    /**
     * Represents an input field in a [Form].
     *
     * @property key A unique identifier for the input field.
     * @property type The type of the input field.
     * @property label A label for the input field.
     * @property isRequired Whether the input field is required.
     * @property isValid A function to validate the input.
     */
    public data class InputField(
        val key: String,
        val type: Type,
        val label: String,
        val isRequired: Boolean,
        val isValid: (String) -> Boolean = { true },
    ) {
        /**
         * An enum representing the type of the input field.
         */
        public enum class Type {
            Email,
            Username,
            Password,
            Number,
            Misc,
        }
    }

    public companion object {
        /**
         * Helper function to create a list with a single [Form].
         */
        public fun form(
            key: String,
            icon: Form.Icon,
            label: String,
            fields: List<InputField>,
        ): List<Form> = listOf(
            Form(
                key = key,
                icon = icon,
                label = label,
                fields = fields,
            ),
        )
    }
}
