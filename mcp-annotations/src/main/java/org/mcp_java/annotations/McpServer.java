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
 * Marks a class as an MCP server component.
 * <p>
 * Classes annotated with {@code @McpServer} will be scanned for
 * {@link Tool}, {@link Resource}, and {@link Prompt} annotations by
 * framework implementations.
 * </p>
 * <p>
 * This is a marker annotation that can be used by frameworks to identify
 * which classes should be processed for MCP functionality.
 * </p>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface McpServer {

    /**
     * The name of the server.
     * <p>
     * If not specified, a name will be derived from the class name or
     * framework configuration.
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
