package DivineForce;

import java.util.EnumSet;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = DivineForce.modid, name = "DivineForce", version = "Beta 1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels={"GenericRandom"}, packetHandler = PacketHandler.class)
public class DivineForce
{
	public static final String modid = "DivineForce";
	
	public static Block DivineForceBlock;
	public static Item trainingDummyPlacer;
	public static Item commonSword1;
	public static Item commonSword2;
	public static Item commonSword3;
	public static Item commonSword4;	
	public static Item rareSword1;
	public static Item rareSword2;
	public static Item rareSword3;
	public static Item rareSword4;	
	public static Item epicSword1;
	public static Item epicSword2;
	public static Item epicSword3;
	public static Item epicSword4;
	public static Item testArmor;
	public Minecraft minecraft = ModLoader.getMinecraftInstance();
	
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new Events());
		TickRegistry.registerTickHandler(new PlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.SERVER);
		KeyBinding[] key = {new KeyBinding("Name of Button", Keyboard.KEY_G)};
        boolean[] repeat = {false};
        KeyBindingRegistry.registerKeyBinding(new KeyBind(key, repeat));
		DivineForceBlock = new BlockDivineForce(500, Material.rock).setUnlocalizedName("DivineForceBlock");
		
		GameRegistry.registerBlock(DivineForceBlock, modid + DivineForceBlock.getUnlocalizedName().substring(5));
		
		trainingDummyPlacer = new ItemTrainingDummyPlacer(5013).setUnlocalizedName("trainingDummyPlacer");
		commonSword1 = new ItemExtendedSword(5000).setUnlocalizedName("commonSword1");
		commonSword2 = new ItemExtendedSword(5001).setUnlocalizedName("commonSword2");
		commonSword3 = new ItemExtendedSword(5002).setUnlocalizedName("commonSword3");
		commonSword4 = new ItemExtendedSword(5003).setUnlocalizedName("commonSword4");
		rareSword1 = new ItemExtendedSword(5004).setUnlocalizedName("rareSword1");
		rareSword2 = new ItemExtendedSword(5005).setUnlocalizedName("rareSword2");
		rareSword3 = new ItemExtendedSword(5006).setUnlocalizedName("rareSword3");
		rareSword4 = new ItemExtendedSword(5007).setUnlocalizedName("rareSword4");
		epicSword1 = new ItemExtendedSword(5008).setUnlocalizedName("epicSword1");
		epicSword2 = new ItemExtendedSword(5009).setUnlocalizedName("epicSword2");
		epicSword3 = new ItemExtendedSword(5010).setUnlocalizedName("epicSword3");
		epicSword4 = new ItemExtendedSword(5011).setUnlocalizedName("epicSword4");
		testArmor = new ItemExtendedArmor(5012, EnumArmorMaterial.GOLD, 4, 1).setUnlocalizedName("testArmor");

		GameRegistry.registerItem(commonSword1, modid + commonSword1.getUnlocalizedName().substring(5));	
		GameRegistry.registerItem(commonSword2, modid + commonSword2.getUnlocalizedName().substring(5));	
		GameRegistry.registerItem(commonSword3, modid + commonSword3.getUnlocalizedName().substring(5));	
		GameRegistry.registerItem(commonSword4, modid + commonSword4.getUnlocalizedName().substring(5));	
		GameRegistry.registerItem(rareSword1, modid + rareSword1.getUnlocalizedName().substring(5));	
		GameRegistry.registerItem(rareSword2, modid + rareSword2.getUnlocalizedName().substring(5));	
		GameRegistry.registerItem(rareSword3, modid + rareSword3.getUnlocalizedName().substring(5));	
		GameRegistry.registerItem(rareSword4, modid + rareSword4.getUnlocalizedName().substring(5));	
		GameRegistry.registerItem(epicSword1, modid + epicSword1.getUnlocalizedName().substring(5));	
		GameRegistry.registerItem(epicSword2, modid + epicSword2.getUnlocalizedName().substring(5));	
		GameRegistry.registerItem(epicSword3, modid + epicSword3.getUnlocalizedName().substring(5));	
		GameRegistry.registerItem(epicSword4, modid + epicSword4.getUnlocalizedName().substring(5));	
		GameRegistry.registerItem(testArmor, modid + testArmor.getUnlocalizedName().substring(5));	
																	
		LanguageRegistry.addName(DivineForceBlock, "DivineForce Block");
		LanguageRegistry.addName(commonSword1, "Broken Sword");
		LanguageRegistry.addName(commonSword2, "Greatsword");
		LanguageRegistry.addName(commonSword3, "Warhammer");
		LanguageRegistry.addName(commonSword4, "Longsword");		
		LanguageRegistry.addName(rareSword1, "Greatsword");
		LanguageRegistry.addName(rareSword2, "Longsword");
		LanguageRegistry.addName(rareSword3, "Claymore");
		LanguageRegistry.addName(rareSword4, "Greatsword");
		LanguageRegistry.addName(epicSword1, "Rage-Possessed Greatsword");
		LanguageRegistry.addName(epicSword2, "Thunderig Longsword");
		LanguageRegistry.addName(epicSword3, "Void Sabre");
		LanguageRegistry.addName(epicSword4, "Ardent Claymore");
		LanguageRegistry.addName(testArmor, "test armor");
		
		MinecraftForgeClient.registerItemRenderer(epicSword3.itemID, new HammerRender());	
		
		EntityRegistry.registerModEntity(EntityTrainingDummy.class, "TrainingDummy", 5, this, 100, 10, true);

		RenderingRegistry.registerEntityRenderingHandler(EntityTrainingDummy.class, new RenderTrainingDummy(new ModelTrainingDummy(), 0.4F));
		
		LanguageRegistry.instance().addStringLocalization("entity.DivineForce.TrainingDummy.name", "Training Dummy");
		
		DivineForceCrafting.loadRecipes();
	}
}