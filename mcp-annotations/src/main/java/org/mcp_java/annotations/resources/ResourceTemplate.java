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

/**
 * Marks a method as providing dynamic MCP resources via URI templates.
 * <p>
 * Resource templates use RFC 6570 URI template syntax to support dynamic
 * resources where parts of the URI are variable (e.g., {@code "file:///{path}"}).
 * </p>
 *
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/resources/#resource-templates">MCP Specification - Resource Templates</a>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResourceTemplate {

    /**
     * A human-readable name for the resource template.
     *
     * @return the template name
     */
    String name();

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
     * A description of what resources matching this template contain.
     *
     * @return the template description
     */
    String description() default "";

    /**
     * The URI template using RFC 6570 syntax.
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
     */
    String uriTemplate();

    /**
     * The MIME type for resources matching this template.
     * <p>
     * Examples: {@code "text/plain"}, {@code "application/json"}, {@code "image/png"}
     * </p>
     *
     * @return the MIME type
     */
    String mimeType() default "";

    /**
     * Icon for the resource template.
     *
     * @return the icon configuration
     */
    ResourceTemplateIcon icon() default @ResourceTemplateIcon;

    /**
     * Operational annotations providing metadata about resources from this template.
     *
     * @return the template annotations
     */
    ResourceTemplateAnnotations annotations() default @ResourceTemplateAnnotations;

    /**
     * Nested annotation for resource template icons.
     */
    @Target({})
    @Retention(RetentionPolicy.RUNTIME)
    @interface ResourceTemplateIcon {
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
     * Nested annotation for resource template metadata.
     */
    @Target({})
    @Retention(RetentionPolicy.RUNTIME)
    @interface ResourceTemplateAnnotations {
        /**
         * The intended audience for resources from this template.
         *
         * @return the audience
         */
        String audience() default "";

        /**
         * The priority of resources from this template.
         *
         * @return the priority value
         */
        double priority() default 0.0;
    }
}
