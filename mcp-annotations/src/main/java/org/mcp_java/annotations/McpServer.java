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
package org.mcp_java.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Binds features (tools, prompts, resources) to a specific MCP server configuration.
 * <p>
 * When declared on a class, all feature methods that do not declare this annotation
 * share the specified server configuration.
 * </p>
 * <p>
 * When declared on a method, it overrides any class-level server binding for that
 * specific feature.
 * </p>
 * <p>
 * Classes annotated with {@code @McpServer} will be scanned for MCP feature annotations
 * by framework implementations.
 * </p>
 *
 * @see org.mcp_java.annotations.tools.Tool
 * @see org.mcp_java.annotations.prompts.Prompt
 * @see org.mcp_java.annotations.resources.Resource
 * @see org.mcp_java.annotations.resources.ResourceTemplate
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface McpServer {

    /**
     * Constant value for the name of the default server.
     */
    String DEFAULT = "<default>";

    /**
     * The name of the server.
     * <p>
     * This is an alias for {@link #name()}. If both are specified, {@code value()} takes precedence.
     * </p>
     * <p>
     * If not specified, a name will be derived from the class name or framework configuration,
     * or {@link #DEFAULT} will be used.
     * </p>
     *
     * @return the server name
     */
    String value() default DEFAULT;

    /**
     * The name of the server.
     * <p>
     * If not specified, a name will be derived from the class name or
     * framework configuration, or {@link #DEFAULT} will be used.
     * </p>
     *
     * @return the server name
     */
    String name() default "";

    /**
     * A description of what this server provides.
     *
     * @return the server description
     */
    String description() default "";

    /**
     * The version of this server.
     *
     * @return the server version
     */
    String version() default "";
}
