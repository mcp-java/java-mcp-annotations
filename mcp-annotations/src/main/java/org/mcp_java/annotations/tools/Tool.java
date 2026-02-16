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
 * Marks a method as an MCP tool that can be invoked by clients.
 * <p>
 * The method will be exposed as a tool in the MCP server. The tool name can be
 * explicitly specified via the {@link #name()} attribute, or will be derived from
 * the method name if not specified.
 * </p>
 * <p>
 * Method parameters can be further configured using {@link ToolArg} annotations.
 * </p>
 *
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/tools/">MCP Specification - Tools</a>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Tool {

    /**
     * The name of the tool.
     * <p>
     * If not specified, the method name will be used.
     * </p>
     *
     * @return the tool name
     */
    String name() default "";

    /**
     * A human-readable title for the tool.
     * <p>
     * This is a short, user-friendly display name for the tool.
     * </p>
     *
     * @return the tool title
     */
    String title() default "";

    /**
     * A human-readable description of what the tool does.
     * <p>
     * This description will be sent to MCP clients to help them understand
     * when and how to use this tool.
     * </p>
     *
     * @return the tool description
     */
    String description() default "";

    /**
     * Icon for the tool.
     *
     * @return the icon configuration
     */
    ToolIcon icon() default @ToolIcon;

    /**
     * Operational annotations providing hints about this tool's behavior.
     *
     * @return the tool annotations
     */
    ToolAnnotations annotations() default @ToolAnnotations;

    /**
     * Nested annotation for tool icons.
     */
    @Target({})
    @Retention(RetentionPolicy.RUNTIME)
    @interface ToolIcon {
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

    /**
     * Nested annotation for tool behavior hints.
     */
    @Target({})
    @Retention(RetentionPolicy.RUNTIME)
    @interface ToolAnnotations {
        /**
         * Hint that this tool only reads data and does not modify state.
         *
         * @return true if read-only
         */
        boolean readOnlyHint() default false;

        /**
         * Hint that this tool performs destructive operations.
         *
         * @return true if destructive
         */
        boolean destructiveHint() default false;

        /**
         * Hint that this tool is idempotent (safe to retry).
         *
         * @return true if idempotent
         */
        boolean idempotentHint() default false;

        /**
         * Hint that this tool operates in an open world (may have side effects).
         *
         * @return true if open world
         */
        boolean openWorldHint() default false;
    }
}
