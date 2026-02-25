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
package org.mcp_java.model.elicitation;

/**
 * A field to collect from the user in an elicitation request.
 *
 * @param name        the unique name of the field
 * @param type        the type of input (e.g., "text", "password", "number")
 * @param label       the label to display for this field
 * @param description optional description or help text
 * @param required    whether this field is required
 * @param defaultValue optional default value
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/utilities/elicitation/#elicitation-field">MCP Specification - Elicitation Field</a>
 */
public record ElicitationField(
    String name,
    String type,
    String label,
    String description,
    boolean required,
    String defaultValue
) {

    /**
     * Creates a new elicitation field.
     */
    public ElicitationField {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Field name cannot be null or blank");
        }
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Field type cannot be null or blank");
        }
        if (label == null || label.isBlank()) {
            throw new IllegalArgumentException("Field label cannot be null or blank");
        }
    }

    /**
     * Creates a required text field.
     *
     * @param name  the field name
     * @param label the field label
     * @return new elicitation field
     */
    public static ElicitationField requiredText(String name, String label) {
        return new ElicitationField(name, "text", label, null, true, null);
    }

    /**
     * Creates an optional text field.
     *
     * @param name  the field name
     * @param label the field label
     * @return new elicitation field
     */
    public static ElicitationField optionalText(String name, String label) {
        return new ElicitationField(name, "text", label, null, false, null);
    }

    /**
     * Creates a required password field.
     *
     * @param name  the field name
     * @param label the field label
     * @return new elicitation field
     */
    public static ElicitationField requiredPassword(String name, String label) {
        return new ElicitationField(name, "password", label, null, true, null);
    }

    /**
     * Creates a field with all properties.
     *
     * @param name         the field name
     * @param type         the field type
     * @param label        the field label
     * @param description  the field description
     * @param required     whether required
     * @param defaultValue the default value
     * @return new elicitation field
     */
    public static ElicitationField of(String name, String type, String label, String description,
                                      boolean required, String defaultValue) {
        return new ElicitationField(name, type, label, description, required, defaultValue);
    }
}
