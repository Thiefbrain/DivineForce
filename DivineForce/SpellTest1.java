package DivineForce;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumMovingObjectType;


public class SpellTest1 extends Spell
{
	public SpellTest1()
	{
		
	}
	
	public int iconX() 
	{
		return 0;
	}

	public int iconY() 
	{
		return 0;
	}

	public float getDamageFromLevel() 
	{
		return Minecraft.getMinecraft().thePlayer.getLevel();
	}

	public float getDamageFromAttackDamage() 
	{
		return Minecraft.getMinecraft().thePlayer.attackDamage*1.4F;
	}
	
	public String getName() 
	{
		return "Fuliginous Strike";
	}

	public String getDescription() 
	{
		return "Strike an ennemy dealing \n" + (int)this.getDamageFromLevel() + "\247c +(" + (int)this.getDamageFromAttackDamage() + ")\247f damage" ;
	}
	
	public void doBasicAttack()
	{
		if (Minecraft.getMinecraft().objectMouseOver != null && Minecraft.getMinecraft().objectMouseOver.typeOfHit == EnumMovingObjectType.ENTITY)
        {
			target = Minecraft.getMinecraft().objectMouseOver.entityHit;
    		Minecraft.getMinecraft().thePlayer.swingItem();
            Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().thePlayer, target);   
            Minecraft.getMinecraft().thePlayer.attackTimer = Minecraft.getMinecraft().thePlayer.attackSpeed;
            for(int i = 0; i < 5; i++)
            	Minecraft.getMinecraft().theWorld.spawnParticle("lava", target.posX, target.posY + target.height/2, target.posZ, rand.nextFloat() - rand.nextFloat(), rand.nextFloat() - rand.nextFloat(), rand.nextFloat() - rand.nextFloat());
        }
	}
	
	public void onSpellTrigger(String username) 
	{
		this.doSpecialAttack(username);
	}

	@Override
	public int getManaCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCooldown() 
	{
		return 160;
	}
}
