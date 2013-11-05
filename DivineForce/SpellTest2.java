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

public class SpellTest2 extends Spell
{
	public SpellTest2()
	{

	}
	
	public int iconX() 
	{
		return 1;
	}

	public int iconY() 
	{
		return 0;
	}
	
	public float getDamageFromLevel() 
	{
		return Minecraft.getMinecraft().thePlayer.getLevel()*6;//6
	}

	public float getDamageFromAttackDamage() 
	{
		return Minecraft.getMinecraft().thePlayer.attackDamage*0.2F;//0.2
	}
	
	public String getName() 
	{
		return "Thundering Strike";
	}

	public String getDescription() 
	{
		return "A furious strike that deals\n" + (int)this.getDamageFromLevel() + "\247c +(" + (int)this.getDamageFromAttackDamage() + ")\247f true damage and\nstun the target for 2 seconds";
	}
	
	public void doBasicAttack()
	{
		if (Minecraft.getMinecraft().objectMouseOver != null && Minecraft.getMinecraft().objectMouseOver.typeOfHit == EnumMovingObjectType.ENTITY)
        {
			
			target = Minecraft.getMinecraft().objectMouseOver.entityHit;
    		Minecraft.getMinecraft().thePlayer.swingItem();
            Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().thePlayer, target);   
            Minecraft.getMinecraft().thePlayer.attackTimer = Minecraft.getMinecraft().thePlayer.attackSpeed;
            if(target instanceof EntityLivingBase)
            {
            	//((EntityLivingBase) target).setStun(500);
            }
        }
	}
	
	@Override
	public void onSpellTrigger(String username) 
	{
		this.doSpecialAttack(username);
        Random random = new Random();
        int randomInt1 = random.nextInt();
        int randomInt2 = random.nextInt();
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
        DataOutputStream outputStream = new DataOutputStream(bos);
        try {
        	
                outputStream.writeInt(randomInt1);
                outputStream.writeInt(randomInt2);
        } catch (Exception ex) {
                ex.printStackTrace();
        }
        
        Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = "GenericRandom";
        packet.data = bos.toByteArray();
        packet.length = bos.size();
        EntityPlayerMP player;
        player = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(username);
        // player.setStun(20);
        if(player.getLookedEntity() != null) player.getLookedEntity().setStun(555);
        PacketDispatcher.sendPacketToServer(packet);

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
}
