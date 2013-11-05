package DivineForce;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class EntityDamageFX extends EntityFX
{
    public int Damage;
    public boolean isCrit;
    public boolean isSpecial;
    public float scaleEffect;
    
    public EntityDamageFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, int damage, boolean special, boolean crit)
    {
        super(par1World, par2, par4, par6, par8, par10, par12);

        try
        {
            this.Damage = damage;
            this.isCrit = crit;
            this.isSpecial = special;
            this.setSize(0.2F, 0.2F);
            this.yOffset = this.height * 1.1F;
            this.setPosition(par2, par4, par6);
          	this.motionY = Minecraft.getMinecraft().thePlayer.getDistanceToEntity(this) < 16 ? 0.06F : 0.2F;
          	float f = Minecraft.getMinecraft().thePlayer.getDistanceToEntity(this);
          	if(f < 6)
          		this.motionY = 0.03F;
          	else if (f < 12)
          		this.motionY = 0.1F;
          	else
          		this.motionY = 0.2F;
            if(this.isCrit)
            {
            	motionY = 0;
            	this.scaleEffect = 8F;
            } else
            {
            	this.scaleEffect = 1;
            }
        	//this.motionZ = rand.nextDouble()/33 - rand.nextDouble()/33;
            //this.motionX = rand.nextDouble()/33 - rand.nextDouble()/33;
            this.motionX = 0;
            this.motionZ = 0;
            if(Minecraft.getMinecraft().thePlayer != null)
            {
            	this.particleScale = 0.3F + Minecraft.getMinecraft().thePlayer.getDistanceToEntity(this)/2F * scaleEffect;
            }else
            {
            	this.particleScale = 1;
            }           
            this.particleMaxAge = this.isCrit ? 20 : 25;
            this.particleAge = 0;
        }
        catch (Throwable var16)
        {
            this.setDead();
        }
    }

    public int getFXLayer()
    {
        return 3;
    }

    @SideOnly(Side.CLIENT)
    public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        try
        {
        	if(this.isCrit && scaleEffect > 2)
        	{
        		scaleEffect -= 0.5;
        	}
            if(Minecraft.getMinecraft().thePlayer != null)
            {
            	this.particleScale = 0.3F + Minecraft.getMinecraft().thePlayer.getDistanceToEntity(this)/2F * scaleEffect;
            }
            
        	this.rotationYaw = -Minecraft.getMinecraft().renderViewEntity.rotationYaw;
            this.rotationPitch = Minecraft.getMinecraft().renderViewEntity.rotationPitch;
            float ex = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)par2 - interpPosX);
            float locY = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)par2 - interpPosY);
            float locZ = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)par2 - interpPosZ);
            GL11.glPushMatrix();
            GL11.glDepthFunc(GL11.GL_ALWAYS);
            GL11.glTranslatef(ex, locY, locZ);
            GL11.glRotatef(this.rotationYaw, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(this.rotationPitch, 1.0F, 0.0F, 0.0F);
            GL11.glScalef(-1.0F, -1.0F, 1.0F);
            GL11.glScaled((double)this.particleScale * 0.008D, (double)this.particleScale * 0.008D, (double)this.particleScale * 0.008D);
            FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
            Minecraft.getMinecraft().entityRenderer.disableLightmap(0.0D);
            int color = this.isSpecial ? 0xffff30 : 0xffffff;
            fontRenderer.drawStringWithShadow(String.valueOf(this.Damage), -MathHelper.floor_float((float)fontRenderer.getStringWidth(this.Damage + "") / 2.0F), -MathHelper.floor_float((float)fontRenderer.FONT_HEIGHT / 2.0F), color);
            Minecraft.getMinecraft().entityRenderer.enableLightmap(0.0D);
            GL11.glDepthFunc(GL11.GL_LEQUAL);
            GL11.glPopMatrix();
        }
        catch (Throwable var12)
        {
            this.setDead();
        }
    }
}
