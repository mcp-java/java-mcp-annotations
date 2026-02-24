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
 * The annotated method can return various types that will be converted to prompt responses:
 * </p>
 * <ul>
 * <li>PromptMessage - Single message in the response</li>
 * <li>List of PromptMessage - Multiple messages in the response</li>
 * <li>PromptResponse - Full response with description and messages</li>
 * <li>Other types - Encoded according to framework-specific rules</li>
 * </ul>
 * <p>
 * Method parameters can be configured using {@link PromptArg} annotations to define
 * the prompt's argument schema.
 * </p>
 *
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/prompts/">MCP Specification - Prompts</a>
 * @see PromptArg
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Prompt {

    /**
     * Constant value for {@link #name()} indicating that the annotated element's name should be used as-is.
     */
    String ELEMENT_NAME = "<<element name>>";

    /**
     * The unique name of the prompt.
     * <p>
     * Each prompt must have a unique name. This is intended for programmatic or logical use,
     * but may be used for UI display as a fallback if {@link #title()} is not present.
     * </p>
     * <p>
     * By default, the name is derived from the annotated method name.
     * </p>
     *
     * @return the prompt name
     */
    String name() default ELEMENT_NAME;

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
     * <p>
     * This description will be sent to MCP clients to help them understand
     * when and how to use this prompt.
     * </p>
     *
     * @return the prompt description
     */
    String description() default "";
}
