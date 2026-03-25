package org.mcp_java.model.common;

/**
 * A hint about a preferred model name for sampling.
 *
 * @param name the model name hint (e.g., "claude-3-5-sonnet")
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/client/sampling#model-preferences">MCP Specification - Model Preferences</a>
 */
public record ModelHint(String name) {

}
