package com.github.divineForce.client;

import com.github.divineForce.DivineForce;
import com.github.divineForce.DivineForceConfig;
import com.github.divineForce.internationalization.LanguageManager;
import com.github.divineForce.server.CommonProxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraftforge.common.Configuration;

/**
 * The client proxy
 * 
 * @author Thiefbrain
 * 
 */
public final class ClientProxy extends CommonProxy
{

    /** The language to use */
    private final String language = "en_US";

    /**
     * {@inheritDoc}
     * 
     * @Side Client
     * @see com.github.divineForce.server.CommonProxy#init()
     */
    @Override
    public void init(final FMLInitializationEvent event)
    {
        LanguageManager.getInstance().loadLanguage(language); // TODO: Add configurable language
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.github.divineForce.server.CommonProxy#preInit(FMLPreInitializationEvent, Configuration)
     */
    @Override
    public void preInit(final FMLPreInitializationEvent event, final DivineForceConfig config)
    {
        DivineForce.getLogger().info("pre init client");
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.github.divineForce.server.CommonProxy#registerRenderers()
     */
    @Override
    public void registerRenderers()
    {
        // This is for rendering
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "[Divine Force client proxy]";
    }
}
