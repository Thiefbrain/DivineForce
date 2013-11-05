package DivineForce;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;


public class HammerRender extends ExtendedItemRenderer
{
    ModelHammer swordmodel = new ModelHammer();
    double pulse = 0.0D;

    public void renderItem(ItemRenderType type, ItemStack item, Object ... data)
    {
        super.renderItem(type, item, data);
        switch (HammerRender$1.$SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[type.ordinal()])
        {
            case 1: // 3rd person
                GL11.glPushMatrix();
                mc.renderEngine.bindTexture(new ResourceLocation(DivineForce.modid + ":" + "epicsword.png"));

                if (((EntityPlayer)data[1]).getFoodStats().getFoodLevel() < 4 || ((EntityPlayer)data[1]).getHealth() < 4.0F)
                {
                    this.pulse += 0.01D;
                    GL11.glColor3f(1.0F, (float)Math.sin(this.pulse), (float)Math.sin(this.pulse));
                }

                this.scale = 1.5F;
                GL11.glScalef(this.scale, this.scale, this.scale);
                GL11.glRotatef(-180.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(-50.0F, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(-0.05F, 0.5F, -0.43F);
                this.swordmodel.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;

            case 2: // 1st person
                GL11.glPushMatrix();
                mc.renderEngine.bindTexture(new ResourceLocation("subaraki:weapons/Hammer.png"));

                if (((EntityPlayer)data[1]).getFoodStats().getFoodLevel() < 4 || ((EntityPlayer)data[1]).getHealth() < 4.0F)
                {
                    this.pulse += 0.01D;
                    GL11.glColor3f(1.0F, (float)Math.sin(this.pulse), (float)Math.sin(this.pulse));
                }

                this.scale = 1.5F;
                GL11.glScalef(this.scale, this.scale, this.scale);
                GL11.glRotatef(-180.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(-50.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-10.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
                GL11.glTranslatef(-0.1F, 0.5F, -0.5F);
                this.swordmodel.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;

            case 3: //drop
                GL11.glPushMatrix();
                mc.renderEngine.bindTexture(new ResourceLocation("subaraki:weapons/Hammer.png"));
                this.scale = 1.8F;
                GL11.glScalef(this.scale, this.scale, this.scale);
                GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(5.0F, 0.0F, 0.0F, 1.0F);
                GL11.glTranslatef(0.0F, 0.55F, 0.0F);
                this.swordmodel.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
                GL11.glPopMatrix();
                break;

            case 4: //icon
                GL11.glPushMatrix();
                mc.renderEngine.bindTexture(new ResourceLocation("subaraki:weapons/Hammer.png"));
                this.scale = 1.3F;
                GL11.glScalef(this.scale, this.scale, this.scale);
                GL11.glRotatef(200.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-10.0F, 0.0F, 1.0F, 0.0F);
                GL11.glTranslatef(0.0F, 0.55F, 0.0F);
                this.swordmodel.render(0.0625F);
                GL11.glPopMatrix();
        }
        
    }
}
