package DivineForce;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;

public class Events
{
	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event)
	{

		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null)
		ExtendedPlayer.register((EntityPlayer) event.entity);
	
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
			event.entity.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer((EntityPlayer) event.entity));
	}
	
	@ForgeSubscribe
	public void onLivingFallEvent(LivingFallEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer) event.entity);
			//((EntityPlayer) event.entity).setStun(20);
		}
	}
}