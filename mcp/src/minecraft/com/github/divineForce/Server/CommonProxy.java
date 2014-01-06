package com.github.divineForce.server;

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

    /**
     * Used for side-specific initialization code. Called by {@link DivineForce#load(cpw.mods.fml.common.event.FMLInitializationEvent)}
     * 
     * @Side Server
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
    public void preInit(final FMLPreInitializationEvent event, final Configuration config)
    {
    }

    /**
     * Used for clients-side rendering; not used by the Server.
     */
    public void registerRenderers()
    {
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
