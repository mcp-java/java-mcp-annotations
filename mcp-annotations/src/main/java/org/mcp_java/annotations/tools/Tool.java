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
 * <h2>Return Type Handling</h2>
 * <p>
 * The annotated method can return various types that will be converted to MCP tool responses:
 * </p>
 * <ul>
 * <li>String - Converted to a text content response</li>
 * <li>Content implementations - Used directly in the response</li>
 * <li>List of Content or String - Multiple content items in the response</li>
 * <li>Other types - Encoded according to framework-specific rules (typically as JSON)</li>
 * </ul>
 *
 * <h2>Schema Generation</h2>
 * <p>
 * Input and output schemas can be automatically generated from method signatures or
 * explicitly configured using {@link #inputSchema()} and {@link #outputSchema()}.
 * </p>
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
     * Each tool must have a unique name. This is intended for programmatic or logical use,
     * but may be used for UI display as a fallback if {@link #title()} is not present.
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
     * Icon for the tool.
     *
     * @return the icon configuration
     */
    Icon icon() default @Icon;

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
     * When enabled, the output schema is also generated automatically from the return type.
     * </p>
     *
     * @return true if structured content should be used
     * @see #outputSchema()
     */
    boolean structuredContent() default false;

    /**
     * Configuration for input schema generation and validation.
     * <p>
     * The input schema defines the expected structure of tool arguments and can be used
     * for validation by clients.
     * </p>
     *
     * @return the input schema configuration
     */
    InputSchema inputSchema() default @InputSchema;

    /**
     * Configuration for output schema generation and validation.
     * <p>
     * The output schema defines the structure of tool results with structured content.
     * This is particularly useful when a tool method returns complex objects directly.
     * </p>
     *
     * @return the output schema configuration
     * @see #structuredContent()
     */
    OutputSchema outputSchema() default @OutputSchema;

    /**
     * Nested annotation for tool icons.
     */
    @Target(ElementType.ANNOTATION_TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Icon {
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

    /**
     * Configuration for input schema generation.
     * <p>
     * The input schema is generated from the tool method's parameter types
     * and can be customized using this annotation.
     * </p>
     */
    @Target(ElementType.ANNOTATION_TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface InputSchema {
        /**
         * The generator class. Implementation classes must be CDI beans. Qualifiers are ignored.
         * <p>
         * By default, the built-in generator is used.
         */
        String generator() default "";
    }

    /**
     * Configuration for output schema generation.
     * <p>
     * The output schema defines the structure of structured content returned by the tool.
     * </p>
     */
    @Target(ElementType.ANNOTATION_TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface OutputSchema {
        /**
         * The class from which the schema is generated.
         * <p>
         * If {@link Tool#structuredContent()} is set to {@code true} then the return type may be used for schema generation.
         */
        Class<?> from() default OutputSchema.class;

        /**
         * The generator class. Implementation classes must be CDI beans. Qualifiers are ignored.
         * <p>
         * By default, the built-in generator is used.
         */
        String generator() default "";
    }
}
