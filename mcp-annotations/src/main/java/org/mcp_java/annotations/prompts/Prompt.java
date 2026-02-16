/*
 * Copyright 2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mcp_java.annotations.prompts;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a method as providing an MCP prompt template.
 * <p>
 * Prompts are reusable message templates that can be used by MCP clients.
 * The method should return a list of messages or a prompt result object.
 * </p>
 *
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/prompts/">MCP Specification - Prompts</a>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Prompt {

    /**
     * The name of the prompt.
     * <p>
     * If not specified, the method name will be used.
     * </p>
     *
     * @return the prompt name
     */
    String name() default "";

    /**
     * A human-readable title for the prompt.
     * <p>
     * This is a short, user-friendly display name for the prompt.
     * </p>
     *
     * @return the prompt title
     */
    String title() default "";

    /**
     * A human-readable description of what this prompt does.
     *
     * @return the prompt description
     */
    String description() default "";

    /**
     * Icon for the prompt.
     *
     * @return the icon configuration
     */
    PromptIcon icon() default @PromptIcon;

    /**
     * Nested annotation for prompt icons.
     */
    @Target({})
    @Retention(RetentionPolicy.RUNTIME)
    @interface PromptIcon {
        /**
         * The icon source (URI).
         *
         * @return the icon source
         */
        String src() default "";

        /**
         * The MIME type of the icon.
         *
         * @return the MIME type
         */
        String mimeType() default "";

        /**
         * Theme for the icon (light or dark).
         *
         * @return the theme
         */
        String theme() default "";
    }
}
