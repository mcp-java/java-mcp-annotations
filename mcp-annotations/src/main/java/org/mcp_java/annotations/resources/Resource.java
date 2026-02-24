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
package org.mcp_java.annotations.resources;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.mcp_java.model.common.Role;

/**
 * Marks a method as providing an MCP resource.
 * <p>
 * The result of a "resource read" operation is represented as a resource response.
 * The annotated method can return various types that will be converted according to
 * framework-specific rules:
 * </p>
 * <ul>
 * <li>String - Converted to text resource contents</li>
 * <li>byte[] - Converted to blob resource contents</li>
 * <li>ResourceContents implementations - Used directly in the response</li>
 * <li>List of ResourceContents - Multiple content items in the response</li>
 * <li>Other types - Encoded according to framework-specific rules (typically as JSON)</li>
 * </ul>
 *
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/resources/">MCP Specification - Resources</a>
 * @see ResourceTemplate
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Resource {

    /**
     * Constant value for {@link #name()} indicating that the annotated element's name should be used as-is.
     */
    String ELEMENT_NAME = "<<element name>>";

    /**
     * The unique name of the resource.
     * <p>
     * Each resource must have a unique name. This is intended for programmatic or logical use,
     * but may be used for UI display as a fallback if {@link #title()} is not present.
     * </p>
     * <p>
     * By default, the name is derived from the annotated method name.
     * </p>
     *
     * @return the resource name
     */
    String name() default ELEMENT_NAME;

    /**
     * A human-readable title for the resource.
     * <p>
     * This is a short, user-friendly display name for the resource.
     * </p>
     *
     * @return the resource title
     */
    String title() default "";

    /**
     * A description of what this resource represents.
     *
     * @return the resource description
     */
    String description() default "";

    /**
     * The URI of this resource.
     * <p>
     * This is a required field that uniquely identifies the resource.
     * </p>
     *
     * @return the resource URI
     */
    String uri();

    /**
     * The MIME type of this resource, if known.
     * <p>
     * Examples: {@code "text/plain"}, {@code "application/json"}, {@code "image/png"}
     * </p>
     *
     * @return the MIME type
     */
    String mimeType() default "";

    /**
     * The size of the raw resource content, in bytes (before base64 encoding or any
     * tokenization), if known.
     *
     * @return the resource size, or -1 if unknown
     */
    int size() default -1;

    /**
     * Optional annotations for the client.
     * <p>
     * These provide additional hints to clients about the resource's metadata.
     * Note that annotations must be declared explicitly to be included in resource metadata.
     * </p>
     *
     * @return the resource annotations
     */
    Annotations annotations() default @Annotations(audience = Role.USER, lastModified = "", priority = 0.5);

    /**
     * Nested annotation for resource metadata annotations.
     * <p>
     * These provide hints to clients about the resource's audience, modification time, and priority.
     * </p>
     */
    @Target(ElementType.ANNOTATION_TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Annotations {
        /**
         * The intended audience for this resource.
         */
        Role audience();

        /**
         * The last modification timestamp in ISO 8601 format.
         *
         * @return the last modified timestamp
         */
        String lastModified() default "";

        /**
         * The priority of this resource.
         * <p>
         * Higher values indicate higher priority.
         * </p>
         *
         * @return the priority value
         */
        double priority() default 0.5;
    }
}
