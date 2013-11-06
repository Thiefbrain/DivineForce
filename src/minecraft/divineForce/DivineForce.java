package divineForce;

import java.util.logging.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.logging.ILogAgent;
import net.minecraft.logging.LogAgent;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

/**
 * The base mod class, called by forge for initialization.
 * 
 * @author Thiefbrain
 */
@Mod(modid=DivineForce.ID, name=DivineForce.NAME, version=DivineForce.VERSION)
@NetworkMod(clientSideRequired=true)
public class DivineForce 
{

	/** The ID used by forge */
	public static final String ID = "DivineForce";
	/** The name of the mod (used by logging) */
	public static final String NAME = "Divine Force";
	/** The version of the mod (will be shown at the modinfo on the client) */
	public static final String VERSION = "1.0.0";
	
    /** The instance of this class (used by Forge) */
    @Instance(value = DivineForce.NAME)
    public static DivineForce instance;
   
    /** Tells forge where to look for the proxies */
    @SidedProxy(clientSide="divineForce.Client.ClientProxy", serverSide="divineForce.CommonProxy")
    public static CommonProxy proxy;
   
    /** The logger. */
    private static Logger logger = FMLLog.getLogger();
    
    /**
     * Called before initialization.
     * 
     * @param event {@link FMLPreInitializationEvent}
     */
    @EventHandler 
    public void preInit(FMLPreInitializationEvent event) 
    {
    }
    
    /**
     * The main initialization.
     * 
     * @param event {@link FMLInitializationEvent}
     */
    @EventHandler
    public void load(FMLInitializationEvent event) 
    {
        proxy.registerRenderers();
        getLogger().info("Initializing Divine Force...");
    }
    
    /**
     * After initialization.
     * 
     * @param event {@link FMLPostInitializationEvent}
     */
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {
    }
    
    /**
     * Gets the logger.
     * 
     * @return {@link Logger} logger
     */
    public static Logger getLogger()
    {
    	return logger;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
    	return "[Divine Force base class]";
    }
}