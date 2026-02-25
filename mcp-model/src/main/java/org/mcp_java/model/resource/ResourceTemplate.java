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
package org.mcp_java.model.resource;

/**
 * A template for resources with dynamic URIs.
 *
 * @param uriTemplate the URI template (using RFC 6570 format)
 * @param name        a human-readable name for resources matching this template
 * @param description a description of what resources matching this template contain (optional)
 * @param mimeType    the MIME type for resources matching this template (optional)
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/resources/#resource-templates">MCP Specification - Resource Templates</a>
 */
public record ResourceTemplate(
    String uriTemplate,
    String name,
    String description,
    String mimeType
) {

    /**
     * Creates a new resource template.
     */
    public ResourceTemplate {
        if (uriTemplate == null || uriTemplate.isBlank()) {
            throw new IllegalArgumentException("URI template cannot be null or blank");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Template name cannot be null or blank");
        }
    }

    /**
     * Creates a resource template with all fields.
     *
     * @param uriTemplate the URI template
     * @param name        the template name
     * @param description the description
     * @param mimeType    the MIME type
     * @return a new resource template
     */
    public static ResourceTemplate of(String uriTemplate, String name, String description, String mimeType) {
        return new ResourceTemplate(uriTemplate, name, description, mimeType);
    }

    /**
     * Creates a resource template with just URI template and name.
     *
     * @param uriTemplate the URI template
     * @param name        the template name
     * @return a new resource template
     */
    public static ResourceTemplate of(String uriTemplate, String name) {
        return new ResourceTemplate(uriTemplate, name, null, null);
    }
}
