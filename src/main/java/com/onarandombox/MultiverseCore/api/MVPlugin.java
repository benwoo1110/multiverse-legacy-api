package com.onarandombox.MultiverseCore.api;

import com.onarandombox.MultiverseCore.MultiverseCore;

/**
 * This interface is implemented by every official Multiverse-plugin.
 */
public interface MVPlugin {
    /**
     * Adds This plugin's version information to the buffer and returns the new string.
     *
     * @param buffer The string that contains Core and all other MV plugins' versions.
     *
     * @return A modified buffer that contains this MVPlugin's version information.
     *
     * @deprecated This is now deprecated, nobody needs it any longer.
     */
    @Deprecated
    String dumpVersionInfo(String buffer);

    /**
     * Gets the reference to MultiverseCore.
     *
     * @return A valid {@link com.onarandombox.MultiverseCore}.
     */
    MultiverseCore getCore();

    /**
     * Sets the reference to MultiverseCore.
     *
     * @param core A valid {@link com.onarandombox.MultiverseCore}.
     */
    void setCore(MultiverseCore core);

    /**
     * Allows Multiverse or a plugin to query another Multiverse plugin to see what version its protocol is. This
     * number
     * should change when something will break the code.
     *
     * @return The Integer protocol version.
     */
    int getProtocolVersion();
}
