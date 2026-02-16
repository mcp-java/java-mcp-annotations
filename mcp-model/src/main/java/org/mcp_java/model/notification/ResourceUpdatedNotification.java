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
package org.mcp_java.model.notification;

/**
 * Notification that a subscribed resource has been updated.
 *
 * @param uri the URI of the resource that was updated
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/resources/#resource-updated">MCP Specification - Resource Updated</a>
 */
public record ResourceUpdatedNotification(
    String uri
) {

    /**
     * Creates a new resource updated notification.
     */
    public ResourceUpdatedNotification {
        if (uri == null || uri.isBlank()) {
            throw new IllegalArgumentException("URI cannot be null or blank");
        }
    }

    /**
     * Creates a resource updated notification.
     *
     * @param uri the resource URI
     * @return new notification
     */
    public static ResourceUpdatedNotification of(String uri) {
        return new ResourceUpdatedNotification(uri);
    }
}
