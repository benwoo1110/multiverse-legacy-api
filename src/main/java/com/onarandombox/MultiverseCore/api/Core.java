package com.onarandombox.MultiverseCore.api;

import com.onarandombox.MultiverseCore.utils.AnchorManager;

public interface Core {
    /**
     * Gets the primary class responsible for managing Multiverse Worlds.
     *
     * @return {@link MVWorldManager}.
     */
    MVWorldManager getMVWorldManager();

    /**
     * Gets the {@link AnchorManager}.
     *
     * @return The {@link AnchorManager}
     */
    AnchorManager getAnchorManager();
}
