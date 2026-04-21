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
package org.mcp_java.server.prompts;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/**
 * Configures a parameter of a {@link Prompt} method.
 * <p>
 * This annotation allows you to provide metadata about prompt arguments,
 * such as names, descriptions, and whether they are required.
 * </p>
 *
 * @see Prompt
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/prompts">MCP Specification - Prompts</a>
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PromptArg {

    /**
     * Constant value for {@link #name()} indicating that the annotated element's name should be used as-is.
     */
    String ELEMENT_NAME = "<<element name>>";

    /**
     * The name of the argument.
     * <p>
     * By default, the parameter name from the method signature will be used
     * (requires compilation with the {@code -parameters} flag).
     * </p>
     *
     * @return the argument name
     */
    String name() default ELEMENT_NAME;

    /**
     * A human-readable title for the argument.
     * <p>
     * This is a short, user-friendly display name for the argument.
     * </p>
     *
     * @return the argument title
     */
    String title() default "";

    /**
     * A human-readable description of the argument.
     *
     * @return the argument description
     */
    String description() default "";

    /**
     * Whether this parameter is required.
     * <p>
     * A parameter is not required if:
     * <ul>
     * <li>{@code required} is set to {@code false}, or
     * <li>the parameter type is {@link Optional}, {@link OptionalDouble}, {@link OptionalInt} or
     * {@link OptionalLong}, or
     * <li>{@link #defaultValue()} is set to a non-empty string
     * </ul>
     * <p>
     * Otherwise, the parameter is required.
     *
     * @return {@code false} to make the parameter not required
     */
    boolean required() default true;

    /**
     * Default value for this argument when not provided.
     * <p>
     * The value should be provided as a string and will be converted to the
     * appropriate type by the framework implementation.
     * <p>
     * Setting a default value causes the parameter to not be required, regardless of the value of
     * {@link #required()}.
     *
     * @return the default value as a string
     */
    String defaultValue() default "";
}
