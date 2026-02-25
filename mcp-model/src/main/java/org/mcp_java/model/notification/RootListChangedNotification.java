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
 * Notification that the list of roots has changed.
 * Servers should re-fetch the root list.
 *
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/client/roots#root-list-changes">MCP Specification - Root List Changes</a>
 */
public record RootListChangedNotification() {

    /**
     * Creates a root list changed notification.
     *
     * @return new notification
     */
    public static RootListChangedNotification create() {
        return new RootListChangedNotification();
    }
}
