package DivineForce;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.EnumSet;
import java.util.Random;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
public class PlayerTickHandler implements ITickHandler
{
	private final EnumSet<TickType> ticksToGet;
	
	public PlayerTickHandler(EnumSet<TickType> ticksToGet)
	{
	         this.ticksToGet = ticksToGet;
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
         playerTick((EntityPlayer)tickData[0]);
	}
	
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
	}
	
	@Override
	public EnumSet<TickType> ticks()
	{
         return ticksToGet;
	}
	
	@Override
	public String getLabel()
	{
		return "DivineForcePlayerTick";
	}
	
	public static void playerTick(EntityPlayer player)
	{
         Side side = FMLCommonHandler.instance().getEffectiveSide();
         if(KeyBind.keyPressed)
         {
           //  if (side == Side.SERVER) 
             {
	             EntityPlayerMP playerMP = (EntityPlayerMP) player;
	         //    playerMP.setStun(20);
             }
         }
	}
}