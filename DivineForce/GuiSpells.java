package DivineForce;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSpells extends GuiScreen
{
    /**
     * x size of the inventory window in pixels. Defined as float, passed as int
     */
    private float xSize_lo;

    /**
     * y size of the inventory window in pixels. Defined as float, passed as int.
     */
    private float ySize_lo;
    
    public final int xSize = 176;
    public final int ySize = 166;
    public int guiLeft;
    public int guiTop;
    protected String buttonText1;
    private static final ResourceLocation field_110408_a = new ResourceLocation("divineforceassets","textures/guis/guispellinventory.png");
    private Spell selectedSpell;
    public GuiSpells(EntityPlayer par1EntityPlayer)
    {
        super();
        this.allowUserInput = true;
        par1EntityPlayer.addStat(AchievementList.openInventory, 1);     
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.buttonList.clear();
        this.buttonList.add(new GuiSmoothButton(2, this.width/3 + 3, 48, 85, 20, "Spells"));
        this.buttonList.add(new GuiSmoothButton(2, this.width/3 + this.xSize - 88, 48, 86, 20, "Masteries"));
        //this.buttonList.add(new GuiSmoothButton(2, this.width/3 + 6, 74, 20, 20, "<-"));
        //this.buttonList.add(new GuiSmoothButton(2, this.width/3 + this.xSize -90, 60, 18, 20, "->"));
        guiLeft = (this.width - this.xSize) / 2;
        guiTop = (this.height - this.ySize) / 2;
        super.initGui();
    }

	public void drawScreen(int mouseX, int mouseY, float partialTicks) 
	{
		drawDefaultBackground();
		drawGUIBackground();
		drawSpellsList();
		drawStats();
		if(this.selectedSpell != null)
		{
			drawToolTip(this.selectedSpell);
		}	
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
	
	private void drawGUIBackground()
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(field_110408_a);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, 176, 166);
	}
	
	private void drawSpellsList()
	{
		EntityPlayer thePlayer = mc.thePlayer;
        this.mc.getTextureManager().bindTexture(new ResourceLocation("divineforceassets","textures/guis/guispells.png"));
        for(int i = 0; i < thePlayer.spellList.length; i++)
        {
        	if(thePlayer.spellList[i] != null)
        	{
        		this.drawTexturedModalRect(8 + this.guiLeft + i*18, this.guiTop + 9, thePlayer.spellList[i].iconX() * 16, thePlayer.spellList[i].iconY() * 16, 16, 16);
        	}
        }
        for(int i = 0; i < thePlayer.spellBar.length; i++)
        {
        	if(thePlayer.spellBar[i] != null)
        	{
        		this.drawTexturedModalRect(8 + this.guiLeft + 18 + i*18, this.guiTop + 40, thePlayer.spellBar[i].iconX() * 16, thePlayer.spellBar[i].iconY() * 16, 16, 16);        		
        	}
        }
        if(this.selectedSpell != null)
        {
        	this.drawTexturedModalRect(8 + this.guiLeft, this.guiTop + 65, selectedSpell.iconX() * 16, selectedSpell.iconY() * 16, 16, 16);
        }
	}
	
	private Spell getHoveredSpell(int mouseX, int mouseY)
	{
		Spell spell = null;
		for(int i = 0; i < mc.thePlayer.spellList.length; i++)
		{
			if(this.isMouseOverArea(mouseX, mouseY, 187+i*18, 76, 16, 16) && mc.thePlayer.spellList[i] != null)
			{
				spell = mc.thePlayer.spellList[i];
			}
		}
		return spell;
	}

	protected void mouseClicked(int mouseX, int mouseY, int button) 
	{
		super.mouseClicked(mouseX, mouseY, button);
		if(button == 0)
		{
			if(this.getHoveredSpell(mouseX, mouseY) != null)
			{
				this.selectedSpell = this.getHoveredSpell(mouseX, mouseY);
			}
			for(int i = 0; i < 7; i++)
			{
				if(this.isMouseOverArea(mouseX, mouseY, 205+i*18, 107, 16, 16))
				{
					mc.thePlayer.spellBar[i] = this.selectedSpell;
					this.selectedSpell = null;
				}
			}
		}
	}	
		
	private void drawToolTip(Spell spell)
	{
		EntityPlayer thePlayer = mc.thePlayer;
		String desc[] = spell.getDescription().split("\n");
		FontRenderer fontrenderer = mc.fontRenderer;
        this.fontRenderer.drawString(spell.getName(), 28 + this.guiLeft, 70 + this.guiTop, 0x30ffff);
		for (int i=0;i<desc.length;i++)
		{
			this.fontRenderer.drawString(desc[i], 10 + this.guiLeft, 77 + 9 + 9*i + this.guiTop, 0xffffff);
		}
	}

	private void drawStats()
	{
        FontRenderer fontrenderer = mc.fontRenderer;
        this.mc.getTextureManager().bindTexture(new ResourceLocation("divineforceassets","textures/guis/gui.png"));
        this.drawTexturedModalRect(this.xSize + 5 + this.guiLeft, this.guiTop, 122, 0, 134, 166);
        String critChance = "" + (double)((int)(mc.thePlayer.criticalChance*10))/10 + "%";
        String haste = "" + (double)((int)(mc.thePlayer.getHaste()*10))/10 + "%";
        String desc = "Lvl 50 Warrior";
        String hp = "" + (int)mc.thePlayer.getMaxHealth(); 
        String damage = "" + (int)mc.thePlayer.attackDamage;
        this.fontRenderer.drawString(desc, 250 - fontrenderer.getStringWidth(desc)/2 + this.guiLeft, 10 + this.guiTop, 0xffff00);
        this.fontRenderer.drawString("Max HP :", 185 + this.guiLeft, 45 + this.guiTop, 0xffff00);
        this.fontRenderer.drawString(hp, 308 - fontrenderer.getStringWidth(hp) + this.guiLeft, 45 + this.guiTop, 0xffffff);      
        this.fontRenderer.drawString("Damage : ", 185 + this.guiLeft, 80 + this.guiTop, 0xffff00);
        this.fontRenderer.drawString(damage, 308 - fontrenderer.getStringWidth(damage) + this.guiLeft, 80 + this.guiTop, 0xffffff);
        this.fontRenderer.drawString("Crit Chance : ", 185 + this.guiLeft, 115 + this.guiTop, 0xffff00);
        this.fontRenderer.drawString("" + critChance, 308 - fontrenderer.getStringWidth(critChance) + this.guiLeft, 115 + this.guiTop, 0xffffff);
        this.fontRenderer.drawString("Haste : ", 185 + this.guiLeft, 150 + this.guiTop, 0xffff00);
        this.fontRenderer.drawString("" + haste, 308 - fontrenderer.getStringWidth(haste) + this.guiLeft, 150 + this.guiTop, 0xffffff);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("divineforceassets","textures/guis/guispells.png"));
	}
	
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.id == 0)
        {
            this.mc.displayGuiScreen(new GuiAchievements(this.mc.statFileWriter));
        }

        if (par1GuiButton.id == 1)
        {
            this.mc.displayGuiScreen(new GuiStats(this, this.mc.statFileWriter));
        }

        if (par1GuiButton.id == 2)
        {
        	this.mc.thePlayer.attackDamage++;
    		EntityPlayerMP playerMP = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(this.mc.thePlayer.username);
        }    
    }
    
	@Override
	protected void keyTyped(char key, int keyCode) 
	{
		if (keyCode == 1 || key == 'E' || key == 'e')
			mc.thePlayer.closeScreen();
	}
	
	private boolean isMouseOverArea(int mouseX, int mouseY, int posX, int posY, int sizeX, int sizeY) 
	{
		return (mouseX>=posX && mouseX<posX + sizeX && mouseY>=posY && mouseY<posY + sizeY);
	}
}
