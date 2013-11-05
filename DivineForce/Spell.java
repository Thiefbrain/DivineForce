package DivineForce;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumMovingObjectType;

public abstract class Spell
{
	public int cooldownTimer;
	public Entity target;
	public Random rand = new Random();
	public abstract int iconX();
	public abstract int iconY();
	public abstract int getManaCost();
	public abstract int getCooldown();
	public abstract float getDamageFromLevel();
	public abstract float getDamageFromAttackDamage();
	public abstract String getName();
	public abstract String getDescription();
	public abstract void onSpellTrigger(String username);
	
	public Spell()
	{
		
	}
	
	public void run() 
	{
		if(this.cooldownTimer > 0)
		{
			this.cooldownTimer --;
		}
	}
	
	public void triggerSpell(String username)
	{
		if(this.cooldownTimer <= 0)
		{
			this.onSpellTrigger(username);
			this.cooldownTimer = this.getCooldown();
			EntityPlayerMP player = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(username);
		} else
		{
			Minecraft.getMinecraft().theWorld.playSoundAtEntity(Minecraft.getMinecraft().thePlayer, "note.bass", 1.0F, 0F);
		}
	}
	
	public float getTotalDamage()
	{
		return this.getDamageFromLevel() + this.getDamageFromAttackDamage();
	}
	
	public void doBasicAttack()
	{
		if (Minecraft.getMinecraft().objectMouseOver != null && Minecraft.getMinecraft().objectMouseOver.typeOfHit == EnumMovingObjectType.ENTITY)
        {
			target = Minecraft.getMinecraft().objectMouseOver.entityHit;
    		Minecraft.getMinecraft().thePlayer.swingItem();
            Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().thePlayer, target);   
            Minecraft.getMinecraft().thePlayer.attackTimer = Minecraft.getMinecraft().thePlayer.attackSpeed;
        }
	}
	
	public void doSpecialAttack(String username)
	{
		EntityPlayerMP playerMP = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(username);
		playerMP.setSpecialAttackDamage((int)this.getTotalDamage());
		doBasicAttack();
	}
	
	public float getCooldownForRender()
	{
		return ((float)cooldownTimer/this.getCooldown())*16;
	}
}
