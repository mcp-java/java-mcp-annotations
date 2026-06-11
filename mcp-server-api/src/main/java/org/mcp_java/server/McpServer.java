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
package org.mcp_java.server;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Binds features (tools, prompts, resources) to a named MCP server configuration.
 * <p>
 * Features can be bound to multiple server configurations by declaring this annotation multiple times.
 * <p>
 * When declared on a class, all feature methods that do not declare this annotation
 * share the specified server configurations.
 * <p>
 * When declared on a method, it overrides any class-level server binding for that
 * specific feature.
 * <p>
 * How MCP server configurations are declared and specified is implementation dependent.
 * It's expected that implementations will provide some way of configuring the name,
 * description and path of each MCP server configuration.
 *
 * @see org.mcp_java.server.tools.Tool
 * @see org.mcp_java.server.prompts.Prompt
 * @see org.mcp_java.server.resources.Resource
 * @see org.mcp_java.server.resources.ResourceTemplate
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(McpServer.McpServers.class)
public @interface McpServer {

    /**
     * Constant value for the name of the default server.
     */
    String DEFAULT = "<default>";

    /**
     * The name of the server configuration the annotated features are bound to.
     * <p>
     * If not specified, they will be linked to the default configuration.
     *
     * @return the server configuration name
     */
    String value() default DEFAULT;
    
    /**
     * Container annotation for {@link McpServer}
     */
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface McpServers {
        McpServer[] value();
    }
}
