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
package org.mcp_java.model.content;

import org.mcp_java.model.common.Annotations;
import org.mcp_java.model.resource.ResourceContents;

/**
 * An embedded resource that can be included as content.
 *
 * @param type        the content type (always "resource")
 * @param resource    the embedded resource contents
 * @param annotations optional annotations
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/basic/messages/#embedded-resource">MCP Specification - Embedded Resource</a>
 */
public record EmbeddedResource(
    String type,
    ResourceContents resource,
    Annotations annotations
) implements ContentBlock {

    /**
     * Creates a new embedded resource.
     */
    public EmbeddedResource {
        if (!"resource".equals(type)) {
            throw new IllegalArgumentException("Type must be 'resource'");
        }
        if (resource == null) {
            throw new IllegalArgumentException("Resource cannot be null");
        }
    }

    /**
     * Creates an embedded resource without annotations.
     *
     * @param resource the resource contents
     * @return a new embedded resource
     */
    public static EmbeddedResource of(ResourceContents resource) {
        return new EmbeddedResource("resource", resource, null);
    }

    /**
     * Creates an embedded resource with annotations.
     *
     * @param resource    the resource contents
     * @param annotations the annotations
     * @return a new embedded resource
     */
    public static EmbeddedResource of(ResourceContents resource, Annotations annotations) {
        return new EmbeddedResource("resource", resource, annotations);
    }
}
