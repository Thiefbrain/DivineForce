package com.github.divineForce;

import java.io.File;
import java.util.logging.Logger;

import com.github.divineForce.server.CommonProxy;
import com.github.divineForce.server.PacketHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.relauncher.Side;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;

/**
 * The base mod class, called by forge for initialization.
 * 
 * @author Thiefbrain
 */
@Mod(modid = DivineForce.ID, name = DivineForce.NAME, version = DivineForce.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { "DivineForce" }, packetHandler = PacketHandler.class)
public final class DivineForce
{

    /** The ID used by forge */
    public static final String ID = "DivineForce";
    /** The name of the mod (used by logging) */
    public static final String NAME = "Divine Force";
    /** The version of the mod (will be shown at the modinfo on the client) */
    public static final String VERSION = "1.0.0";

    /** The side of the mod (either server or client) */
    public static final Side SIDE = FMLCommonHandler.instance().getEffectiveSide();

    /** The instance of this class (used by Forge) */
    @Instance(value = DivineForce.NAME)
    public static DivineForce instance;

    /** Tells forge where to look for the proxies */
    @SidedProxy(clientSide = "com.github.divineForce.client.ClientProxy", serverSide = "com.github.divineForce.server.CommonProxy")
    public static CommonProxy proxy;

    /** The logger. */
    private static Logger logger = FMLLog.getLogger();

    /** The directory containing all data. */
    private String dataDirectory;

    /** The timeout after caches are cleared */
    private int cacheClearTimeout;

    /**
     * Gets the singleton instance of this class.
     * 
     * @return The instance of this class
     */
    public static DivineForce getInstance()
    {
        return instance;
    }

    /**
     * Gets the logger.
     * 
     * @return {@link Logger} logger
     */
    public static Logger getLogger()
    {
        return DivineForce.logger;
    }

    /**
     * Gets the directory where all data is stored. This already contains the path seperator.
     * 
     * @return The absolute path to the data directory.
     */
    public final String getDataDirectory()
    {
        return dataDirectory;
    }

    /**
     * The main initialization.
     * 
     * @param event
     *            {@link FMLInitializationEvent}
     */
    @EventHandler
    public final void load(final FMLInitializationEvent event)
    {
        DivineForce.getLogger().info("Initializing Divine Force...");
        // register the renders
        DivineForce.proxy.registerRenderers();
        DivineForce.proxy.init(event);

        // register the event handler
        MinecraftForge.EVENT_BUS.register(new DivineForceEventHandler());

        DivineForce.getLogger().info("Divine Force initialized!");
    }

    /**
     * After initialization.
     * 
     * @param event
     *            {@link FMLPostInitializationEvent}
     */
    @EventHandler
    public void postInit(final FMLPostInitializationEvent event)
    {
    }

    /**
     * Called before initialization. Configuration is loaded here
     * 
     * @param event
     *            {@link FMLPreInitializationEvent}
     */
    @EventHandler
    public final void preInit(final FMLPreInitializationEvent event)
    {
        dataDirectory = event.getSuggestedConfigurationFile().getAbsolutePath() + "DivineForce" + File.pathSeparator;

        // load config
        final Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        final DivineForceConfig divineForceConfig = DivineForceConfig.init(config);

        DivineForce.proxy.preInit(event, divineForceConfig);

        config.save();
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString()
    {
        return "[Divine Force base class]";
    }
}
