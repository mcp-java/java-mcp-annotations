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
 * Marks a method as providing dynamic MCP resources via URI templates.
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
 * <p>
 * Resource templates use Level 1 RFC 6570 URI template syntax to support dynamic
 * resources where parts of the URI are variable.
 * Method parameters can be configured using {@link ResourceTemplateArg} annotations.
 * </p>
 *
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/resources/#resource-templates">MCP Specification - Resource Templates</a>
 * @see <a href="https://datatracker.ietf.org/doc/html/rfc6570#section-1.2">RFC 6570 - URI Template</a>
 * @see Resource
 * @see ResourceTemplateArg
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResourceTemplate {

    /**
     * Constant value for {@link #name()} indicating that the annotated element's name should be used as-is.
     */
    String ELEMENT_NAME = "<<element name>>";

    /**
     * The unique name of the resource template.
     * <p>
     * Each resource template must have a unique name. This is intended for programmatic or logical use,
     * but may be used for UI display as a fallback if {@link #title()} is not present.
     * </p>
     * <p>
     * By default, the name is derived from the annotated method name.
     * </p>
     *
     * @return the template name
     */
    String name() default ELEMENT_NAME;

    /**
     * A human-readable title for the resource template.
     * <p>
     * This is a short, user-friendly display name for the template.
     * </p>
     *
     * @return the template title
     */
    String title() default "";

    /**
     * A description of what this resource template represents.
     *
     * @return the template description
     */
    String description() default "";

    /**
     * The Level 1 URI template that can be used to construct resource URIs.
     * <p>
     * Examples:
     * </p>
     * <ul>
     * <li>{@code "file:///{path}"}</li>
     * <li>{@code "db:///{database}/tables/{table}"}</li>
     * <li>{@code "api:///{version}/users/{userId}"}</li>
     * </ul>
     *
     * @return the URI template
     * @see <a href="https://datatracker.ietf.org/doc/html/rfc6570#section-1.2">RFC 6570</a>
     */
    String uriTemplate();

    /**
     * The MIME type of this resource template.
     * <p>
     * Examples: {@code "text/plain"}, {@code "application/json"}, {@code "image/png"}
     * </p>
     *
     * @return the MIME type
     */
    String mimeType() default "";

    /**
     * Optional annotations for the client.
     * <p>
     * These provide additional hints to clients about the resource template's metadata.
     * Note that annotations must be declared explicitly to be included in resource metadata.
     * </p>
     *
     * @return the template annotations
     */
    Annotations annotations() default @Annotations(audience = Role.USER, lastModified = "", priority = 0.5);

    /**
     * Nested annotation for resource template metadata annotations.
     * <p>
     * These provide hints to clients about resources from this template.
     * </p>
     */
    @Target(ElementType.ANNOTATION_TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Annotations {
        /**
         * The intended audience for resources from this template.
         */
        Role audience();

        /**
         * The last modification timestamp in ISO 8601 format.
         *
         * @return the last modified timestamp
         */
        String lastModified() default "";

        /**
         * The priority of resources from this template.
         * <p>
         * Higher values indicate higher priority.
         * </p>
         *
         * @return the priority value
         */
        double priority() default 0.5;
    }
}
