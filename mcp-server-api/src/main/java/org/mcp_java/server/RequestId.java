/*
 * Copyright 2026 the original author or authors.
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

package org.mcp_java.server;

/**
 * The ID of an MCP request. The ID of a request can be either a number or a string.
 * <p>
 * Tool, Prompt, Resource, and ResourceTemplate methods can accept this interface as a parameter.
 * It will be automatically injected by the framework implementation before the method is invoked.
 * </p>
 */
public interface RequestId {

    /**
     * The value of the RequestID, either a {@link String} or a {@link Number}.
     * <p>
     * The {@code value} of two RequestIDs must be equal if and only if the JSON values they were created from were equal.
     * 
     * @return the value of the RequestID
     */
    Object value();

    /**
     * Returns a string representation of the RequestId.
     * <p>
     * If the value is a {@code String}, this method returns the string in quotes (").
     * <p>
     * If the value is a {@code Number}, this method returns a string representation of the number.
     * 
     * @return the RequestId as a string
     */
    @Override
    String toString();

    /**
     * Two requestIds are equal if their values are equal and are either both numbers or both strings.
     * 
     * @param other the object with which to compare
     * @return {@code true} if {@code other} is a {@code RequestId} and its value is equal to the value
     * of this object, otherwise {@code false}
     */
    @Override
    boolean equals(Object other);

    /**
     * The hash code of a requestId is the hash code of its value.
     * 
     * @return the hash code of the requestId
     */
    @Override
    int hashCode();
}
