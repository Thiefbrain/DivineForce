package DivineForce;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityTrainingDummy extends EntityMob
{
    public EntityTrainingDummy(World par1World)
    {
        super(par1World);
        this.setLevel(1);
        this.setRarity(1);
        this.setHealth(this.getMaxHealth());
    }

    public float getMaxHealth()
    {
    	return 500000;
    }
    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.0D);
    }

    protected String getHurtSound()
    {
        return "step.wood";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "step.wood";
    }
    
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
		System.out.println(" Burning : " + this.isBurning() + "Stuned : "  + this.isStuned() + " isRemote : " + worldObj.isRemote);
		
    }
/*
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

        if (itemstack != null && itemstack.itemID == Item.bucketEmpty.itemID && !par1EntityPlayer.capabilities.isCreativeMode)
        {
            if (itemstack.stackSize-- == 1)
            {
                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(Item.bucketMilk));
            }
            else if (!par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.bucketMilk)))
            {
                par1EntityPlayer.dropPlayerItem(new ItemStack(Item.bucketMilk.itemID, 1, 0));
            }

            return true;
        }
        else
        {
            return super.interact(par1EntityPlayer);
        }
    }
*/
  

}
