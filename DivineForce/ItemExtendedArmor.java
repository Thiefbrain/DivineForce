package DivineForce;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemExtendedArmor extends ItemArmor
{

    public ItemExtendedArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
    {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.setMaxDamage(-1);
    }
    
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(DivineForce.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
