package divineForce;

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
@Mod(modid="DivineForce", name="Divine Force", version="1.0.0")
@NetworkMod(clientSideRequired=true)
public class DivineForce {

	/** The instance of this class (used by Forge) */
    @Instance(value = "DivineForce")
    public static DivineForce instance;
   
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="divineForce.client.ClientProxy", serverSide="divineForce.CommonProxy")
    public static CommonProxy proxy;
   
    /**
     * Called before initialization.
     * 
     * @param event {@link FMLPreInitializationEvent}
     */
    @EventHandler 
    public void preInit(FMLPreInitializationEvent event) {
        // Stub Method
    }
    
    /**
     * The main initialization.
     * 
     * @param event {@link FMLInitializationEvent}
     */
    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.registerRenderers();
    }
    
    /**
     * After initialization.
     * 
     * @param event {@link FMLPostInitializationEvent}
     */
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
    }
}