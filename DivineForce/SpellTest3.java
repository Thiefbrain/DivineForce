package DivineForce;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumMovingObjectType;
import cpw.mods.fml.common.network.PacketDispatcher;

public class SpellTest3 extends Spell
{
	public SpellTest3()
	{
	}
	
	public int iconX() 
	{
		return 2;
	}

	public int iconY() 
	{
		return 0;
	}
	
	public float getDamageFromLevel() 
	{
		return 0;
	}

	public float getDamageFromAttackDamage() 
	{
		return 0;
	}
	
	public String getName() 
	{
		return "Charge";
	}

	public String getDescription() 
	{
		return "";
	}

	@Override
	public int getManaCost() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCooldown() 
	{
		return 40;
	}

	@Override
	public void onSpellTrigger(String username) {
		// TODO Auto-generated method stub	
	}
}
