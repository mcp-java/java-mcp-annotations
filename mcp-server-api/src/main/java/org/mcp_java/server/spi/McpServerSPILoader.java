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

package org.mcp_java.server.spi;


import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ServiceLoader;

import org.mcp_java.server.content.TextContent;

/**
 * Provides access to the {@link McpServerSPI} implementation.
 * <p>
 * Static constructor methods use {@link #getSPI()} to obtain the {@code McpServerSPI} to create the
 * object.
 * <p>
 * Users should use static constructor methods (e.g. {@link TextContent#of(String)} rather than this
 * interface.
 */
public class McpServerSPILoader {

    private static volatile McpServerSPI instance;
    
    // No default constructor
    private McpServerSPILoader() {}

    /**
     * Returns {@link McpServerSPI}, loading it if necessary.
     * <p>
     * The implementation is loaded using Java's {@link ServiceLoader} mechanism and the classloader
     * of {@code McpServerSPI}.
     *
     * @return the McpServerSPI instance
     * @throws IllegalStateException if no SPI implementation is found
     */
    public static McpServerSPI getSPI() {
        if (instance != null) {
            return instance;
        }
        synchronized (McpServerSPILoader.class) {
            if (instance == null) {
                instance = loadSPI();
            }
        }
        return instance;
    }

    @SuppressWarnings("removal") // SecurityManager deprecated but still available until Java 24
    private static McpServerSPI loadSPI() {
        PrivilegedAction<ServiceLoader<McpServerSPI>> loadSpi = () -> ServiceLoader.load(McpServerSPI.class,
                                                                                         McpServerSPI.class.getClassLoader());
        ServiceLoader<McpServerSPI> loader = AccessController.doPrivileged(loadSpi);
        for (McpServerSPI spi : loader) {
            return spi; // Return the first available implementation
        }
        throw new IllegalStateException("No McpServerSPI implementation found.");
    }
}
