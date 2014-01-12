package com.github.divineForce.server;

import java.util.HashMap;
import java.util.Map;

import com.github.divineForce.DivineForce;
import com.github.divineForce.DivineForceConfig;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraftforge.common.Configuration;

/**
 * The proxy class for server code. Note: This applies to the standalone server, not the integrated one.
 * 
 * @author Thiefbrain
 */
public class CommonProxy
{

    private final Map<String, String> playerVersions = new HashMap<>();

    /**
     * Used for side-specific initialization code. Called by {@link DivineForce#load(cpw.mods.fml.common.event.FMLInitializationEvent)}
     * 
     * @param event
     *            {@link FMLInitializationEvent}
     */
    public void init(final FMLInitializationEvent event)
    {
    }

    /**
     * Used for side-specific pre-initialization code. Called by {@link DivineForce#preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent)}
     * 
     * @param event
     *            {@link FMLPreInitializationEvent}
     * @param config
     *            {@link Configuration}
     */
    public void preInit(final FMLPreInitializationEvent event, final DivineForceConfig config)
    {
    }

    /**
     * Used for clients-side rendering; not used by the Server.
     */
    public void registerRenderers()
    {
    }

    /**
     * Saves the installed mod version of the player in a map
     * 
     * @param player
     *            The playername
     * @param version
     *            The installed version
     */
    public void setClientVersionForPlayer(final String player, final String version)
    {
        playerVersions.put(player, version);
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "[Divine Force common proxy]";
    }

}
