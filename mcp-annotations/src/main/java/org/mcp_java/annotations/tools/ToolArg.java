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
package org.mcp_java.annotations.tools;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Configures a parameter of a {@link Tool} method.
 * <p>
 * This annotation allows you to provide additional metadata about tool parameters,
 * such as custom names and descriptions that will be included in the tool's
 * JSON Schema definition.
 * </p>
 *
 * @see Tool
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/tools/">MCP Specification - Tools</a>
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ToolArg {

    /**
     * The name of the parameter as it appears in the tool's JSON Schema.
     * <p>
     * If not specified, the parameter name from the method signature will be used
     * (requires compilation with the {@code -parameters} flag).
     * </p>
     *
     * @return the parameter name
     */
    String name() default "";

    /**
     * A human-readable title for the parameter.
     * <p>
     * This is a short, user-friendly display name for the parameter.
     * </p>
     *
     * @return the parameter title
     */
    String title() default "";

    /**
     * A human-readable description of the parameter.
     * <p>
     * This description will be included in the tool's JSON Schema to help
     * clients understand what this parameter is for.
     * </p>
     *
     * @return the parameter description
     */
    String description() default "";

    /**
     * Whether this parameter is required.
     * <p>
     * By default, parameters are considered required unless they have a default
     * value or are annotated with framework-specific optional annotations.
     * </p>
     *
     * @return true if the parameter is required
     */
    boolean required() default true;

    /**
     * Default value for this parameter when not provided by the client.
     * <p>
     * The value should be provided as a string and will be converted to the
     * appropriate type by the framework implementation.
     * </p>
     *
     * @return the default value as a string
     */
    String defaultValue() default "";
}
