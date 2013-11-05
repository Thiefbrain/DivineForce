package DivineForce;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDivineForce extends Item
{
	public ItemDivineForce(int id) 
	{
		super(id);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(DivineForce.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
}