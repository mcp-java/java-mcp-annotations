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
package org.mcp_java.server.tools;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.mcp_java.server.Cancellation;
import org.mcp_java.server.McpRequest;
import org.mcp_java.server.McpServer;
import org.mcp_java.server.content.ContentBlock;
import org.mcp_java.server.progress.Progress;

/**
 * Marks a method as an MCP tool that can be invoked by clients.
 * <p>
 * The method will be exposed as a tool in the MCP server. The tool name can be
 * explicitly specified via the {@link #name()} attribute, or will be derived from
 * the method name if not specified.
 * </p>
 * 
 * <h2>Parameters</h2>
 * <p>
 * Tool methods may have parameters of the following types:
 * <ul>
 * <li>{@link McpRequest} - to access information about the request
 * <li>{@link Cancellation} - to allow processing to be stopped if the client cancels the tool call
 * <li>{@link Progress} - to send progress reports back to the client
 * <li>Implementations may define additional types that can be used as parameters
 * <li><strong>All other parameters</strong> are treated as arguments to the tool.
 * In most cases these parameters must be annotated with {@link ToolArg} with the
 * {@link ToolArg#name() name} attribute set, unless the code was compiled with the
 * {@code -parameters} option.
 * {@code ToolArg} also allows other properties of the argument to be configured.
 * </ul>
 *
 * <h2>Return Type Handling</h2>
 * <p>
 * The annotated method can return various types that will be converted to MCP tool responses:
 * </p>
 * <ul>
 * <li>{@code String} - Converted to a text content response</li>
 * <li>{@link ContentBlock} implementations - Used directly in the response</li>
 * <li>List of {@link ContentBlock} or String - Multiple content items in the response</li>
 * <li>{@link ToolResponse} - Used directly as the response</li>
 * <li>Other types - Encoded according to framework-specific rules (typically as JSON)</li>
 * </ul>
 *
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/tools">MCP Specification - Tools</a>
 * @see ToolArg
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Tool {

    /**
     * Constant value for {@link #name()} indicating that the annotated element's name should be used as-is.
     */
    String ELEMENT_NAME = "<<element name>>";

    /**
     * The unique name of the tool.
     * <p>
     * Each tool bound to the same {@linkplain McpServer MCP server configuration} must have a unique name.
     * This is intended for programmatic or logical use, but may be used for UI display as a fallback if
     * {@link #title()} is not present.
     * </p>
     * <p>
     * By default, the name is derived from the annotated method name.
     * </p>
     *
     * @return the tool name
     */
    String name() default ELEMENT_NAME;

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
     * when and how to use this tool. It serves as a hint to the model.
     * </p>
     *
     * @return the tool description
     */
    String description() default "";

    /**
     * Behavioral hints and annotations for this tool.
     * <p>
     * These provide additional hints to clients about the tool's behavior and characteristics.
     * Note that annotations must be declared explicitly to be included in tool metadata.
     * </p>
     *
     * @return the tool annotations
     */
    Annotations annotations() default @Annotations;

    /**
     * If set to {@code true}, the method return value is converted to JSON and used as
     * structured content in the result.
     * <p>
     * When enabled, the output schema is generated automatically from the return type,
     * or from {@link #outputSchemaFrom()} if set.
     * </p>
     *
     * @return true if structured content should be used
     * @see #outputSchemaFrom()
     */
    boolean structuredContent() default false;

    /**
     * The class to use to generate the output schema for structured content.
     * <p>
     * If a tool returns {@linkplain #structuredContent() structured content}, this method can
     * be used to override the type used to generate the output schema. This is necessary for
     * tool methods that return {@link ToolResponse} and want to include structured content.
     * <p>
     * By default, the output schema is generated from the method return type.
     * 
     * @return the class to use to generate the output schema
     * @see #structuredContent()
     */
    Class<?> outputSchemaFrom() default Void.class;

    /**
     * Nested annotation for tool behavioral hints.
     * <p>
     * These hints help clients understand the tool's behavior and side effects.
     * </p>
     */
    @Target(ElementType.ANNOTATION_TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Annotations {
        /**
         * A human-readable title for the tool.
         *
         * @return the tool title
         */
        String title() default "";

        /**
         * If true, this tool only reads data and does not modify its environment.
         * <p>
         * Default is false, assuming tools may have side effects.
         * </p>
         *
         * @return true if read-only
         */
        boolean readOnlyHint() default false;

        /**
         * If true, this tool may perform destructive updates to its environment.
         * If false, the tool performs only additive updates.
         * <p>
         * Default is true to err on the side of caution.
         * </p>
         *
         * @return true if potentially destructive
         */
        boolean destructiveHint() default true;

        /**
         * If true, calling the tool repeatedly with the same arguments will have no
         * additional effect on its environment (safe to retry).
         * <p>
         * Default is false.
         * </p>
         *
         * @return true if idempotent
         */
        boolean idempotentHint() default false;

        /**
         * If true, this tool may interact with an "open world" of external entities.
         * If false, the tool's domain of interaction is closed.
         * <p>
         * Default is true, assuming tools may interact with external systems.
         * </p>
         *
         * @return true if open world
         */
        boolean openWorldHint() default true;
    }
}
