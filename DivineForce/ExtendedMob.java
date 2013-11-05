package DivineForce;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class ExtendedMob implements IExtendedEntityProperties
{

	public final static String EXT_PROP_NAME = "ExtendedPlayer";


	private EntityMob mob;

	public float baseHealth, health;
	public int level, rarity;
	
	public final float levelModifier = 1 + (float)level/20;
	
	public ExtendedMob(EntityMob mob)
	{
		this.mob = mob;
	}

	public void saveNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = new NBTTagCompound();
	//	properties.setInteger("baseHealth", this.currentMana);
		//properties.setInteger("health", this.maxMana);
		compound.setTag(EXT_PROP_NAME, properties);
	}

	public void loadNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		//this.currentMana = properties.getInteger("CurrentMana");
		//this.maxMana = properties.getInteger("MaxMana");
	}

	public void init(Entity entity, World world)
	{
	}
}
