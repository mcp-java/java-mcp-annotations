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
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Adds custom metadata fields to the {@code _meta} object in MCP definitions.
 * <p>
 * This annotation can be used on {@link Tool}, {@link Prompt}, {@link Resource},
 * or {@link ResourceTemplate} methods to add custom metadata that will be
 * included in the {@code _meta} field of the definition sent to clients.
 * </p>
 * <p>
 * Example:
 * </p>
 * <pre>
 * &#64;MetaField(name = "version", value = "1.0")
 * &#64;MetaField(prefix = "myapp.io/", name = "customField", value = "customValue")
 * &#64;Tool(name = "myTool", description = "Example tool")
 * public String myTool() {
 *     return "result";
 * }
 * </pre>
 *
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic#_meta">MCP Specification - Metadata</a>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(MetaField.MetaFields.class)
public @interface MetaField {

    /**
     * Optional prefix for the metadata key.
     * <p>
     * Must be a series of labels separated by dots ({@code .}), followed by a slash ({@code /}).
     * Labels must start with a letter and end with a letter or digit; interior characters can be
     * letters, digits, or hyphens ({@code -}).
     * </p>
     * <p>
     * Some prefixes are reserved for the MCP spec, e.g. {@code modelcontextprotocol.io/} or
     * {@code tools.mcp.com/}.
     * </p>
     * <p>
     * Examples: {@code "modelcontextprotocol.io/"}, {@code "myapp.io/"}
     * </p>
     *
     * @return the key prefix
     */
    String prefix() default "";

    /**
     * The name of the metadata field.
     * <p>
     * Must begin and end with an alphanumeric character ({@code [a-z0-9A-Z]}).
     * May contain hyphens ({@code -}), underscores ({@code _}), dots ({@code .}), and
     * alphanumerics in between.
     * </p>
     *
     * @return the field name
     */
    String name();

    /**
     * The type of the metadata value.
     *
     * @return the value type
     */
    Type type() default Type.STRING;

    /**
     * The value of the metadata field as a string.
     * <p>
     * The value will be converted to the appropriate type based on {@link #type()}.
     * </p>
     *
     * @return the field value
     */
    String value();

    /**
     * The type of metadata value.
     */
    enum Type {
        /**
         * String value.
         */
        STRING,

        /**
         * Integer value.
         */
        INT,

        /**
         * Boolean value.
         */
        BOOLEAN,

        /**
         * JSON value (complex structure).
         */
        JSON
    }

    /**
     * Container annotation for multiple {@link MetaField} annotations.
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface MetaFields {
        /**
         * The metadata fields.
         *
         * @return array of metadata fields
         */
        MetaField[] value();
    }
}
