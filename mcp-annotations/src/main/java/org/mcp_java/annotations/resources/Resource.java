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
 * Marks a method or class as providing MCP resources.
 * <p>
 * Resources are data sources that can be read by MCP clients. This annotation
 * can be applied to methods that return resource data, or to classes that
 * provide multiple resources.
 * </p>
 *
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/resources/">MCP Specification - Resources</a>
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Resource {

    /**
     * The URI or URI template for the resource.
     * <p>
     * Can use RFC 6570 URI template syntax for dynamic resources (e.g.,
     * {@code "file:///{path}"}).
     * </p>
     *
     * @return the resource URI or template
     */
    String uri();

    /**
     * A human-readable name for the resource.
     *
     * @return the resource name
     */
    String name();

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
     * A description of what this resource contains.
     *
     * @return the resource description
     */
    String description() default "";

    /**
     * The MIME type of the resource content.
     * <p>
     * Examples: {@code "text/plain"}, {@code "application/json"}, {@code "image/png"}
     * </p>
     *
     * @return the MIME type
     */
    String mimeType() default "";

    /**
     * The size of the resource in bytes.
     *
     * @return the resource size, or -1 if unknown
     */
    long size() default -1;

    /**
     * Icon for the resource.
     *
     * @return the icon configuration
     */
    ResourceIcon icon() default @ResourceIcon;

    /**
     * Operational annotations providing metadata about this resource.
     *
     * @return the resource annotations
     */
    ResourceAnnotations annotations() default @ResourceAnnotations;

    /**
     * Nested annotation for resource icons.
     */
    @Target({})
    @Retention(RetentionPolicy.RUNTIME)
    @interface ResourceIcon {
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
     * Nested annotation for resource metadata.
     */
    @Target({})
    @Retention(RetentionPolicy.RUNTIME)
    @interface ResourceAnnotations {
        /**
         * The intended audience for this resource (e.g., "user", "assistant").
         *
         * @return the audience
         */
        String audience() default "";

        /**
         * The last modification date in ISO 8601 format.
         *
         * @return the modification date
         */
        String modificationDate() default "";

        /**
         * The priority of this resource (higher is more important).
         *
         * @return the priority value
         */
        double priority() default 0.0;
    }
}
