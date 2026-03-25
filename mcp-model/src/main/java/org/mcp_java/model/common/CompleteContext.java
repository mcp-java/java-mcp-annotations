package org.mcp_java.model.common;

import java.util.Map;

/**
 * A {@code @CompletePrompt} or {@code @CompleteResourceTemplate} method may accept this class as a parameter. It will be
 * automatically injected before the method is invoked.
 */
public interface CompleteContext {

    /**
     * The previous completions can provide context for subsequent requests.
     *
     * @return the previous completions
     */
    Map<String, String> arguments();

}
