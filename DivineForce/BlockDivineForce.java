package DivineForce;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDivineForce extends Block
{
	public BlockDivineForce(int id, Material material) 
	{
		super(id, material);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(DivineForce.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}