package DivineForce;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHammer extends ModelBase
{
    ModelRenderer HammerBase;
    ModelRenderer Deco1;
    ModelRenderer Deco2;
    ModelRenderer Deco3;
    ModelRenderer handle;
    ModelRenderer head;
    ModelRenderer deco4;
    ModelRenderer deco5;
    ModelRenderer Backhead;
    ModelRenderer bheaddeco;
    ModelRenderer HeadDeco;
    ModelRenderer pist1;
    ModelRenderer pist2;
    ModelRenderer pist3;
    ModelRenderer pist4;

    public ModelHammer()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.HammerBase = new ModelRenderer(this, 6, 18);
        this.HammerBase.addBox(-0.5F, 0.0F, -0.5F, 3, 2, 2);
        this.HammerBase.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HammerBase.setTextureSize(64, 32);
        this.HammerBase.mirror = true;
        this.setRotation(this.HammerBase, 0.0F, 0.0F, 0.0F);
        this.Deco1 = new ModelRenderer(this, 6, 28);
        this.Deco1.addBox(0.5F, 0.0F, -1.5F, 1, 2, 1);
        this.Deco1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Deco1.setTextureSize(64, 32);
        this.Deco1.mirror = true;
        this.setRotation(this.Deco1, 0.0F, 0.0F, 0.0F);
        this.Deco2 = new ModelRenderer(this, 6, 28);
        this.Deco2.addBox(0.5F, 0.0F, 1.5F, 1, 2, 1);
        this.Deco2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Deco2.setTextureSize(64, 32);
        this.Deco2.mirror = true;
        this.setRotation(this.Deco2, 0.0F, 0.0F, 0.0F);
        this.Deco3 = new ModelRenderer(this, 6, 24);
        this.Deco3.addBox(0.5F, 2.0F, -0.5F, 1, 1, 2);
        this.Deco3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Deco3.setTextureSize(64, 32);
        this.Deco3.mirror = true;
        this.setRotation(this.Deco3, 0.0F, 0.0F, 0.0F);
        this.handle = new ModelRenderer(this, 0, 15);
        this.handle.addBox(0.5F, -16.0F, 0.0F, 1, 16, 1);
        this.handle.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.handle.setTextureSize(64, 32);
        this.handle.mirror = true;
        this.setRotation(this.handle, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 30, 0);
        this.head.addBox(-1.5F, -20.0F, -3.5F, 5, 5, 4);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.deco4 = new ModelRenderer(this, 11, 29);
        this.deco4.addBox(0.5F, -1.0F, 1.0F, 1, 1, 1);
        this.deco4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.deco4.setTextureSize(64, 32);
        this.deco4.mirror = true;
        this.setRotation(this.deco4, 0.0F, 0.0F, 0.0F);
        this.deco5 = new ModelRenderer(this, 11, 29);
        this.deco5.addBox(0.5F, -1.0F, -1.0F, 1, 1, 1);
        this.deco5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.deco5.setTextureSize(64, 32);
        this.deco5.mirror = true;
        this.setRotation(this.deco5, 0.0F, 0.0F, 0.0F);
        this.Backhead = new ModelRenderer(this, 15, 1);
        this.Backhead.addBox(-1.0F, -19.5F, 1.5F, 4, 4, 2);
        this.Backhead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Backhead.setTextureSize(64, 32);
        this.Backhead.mirror = true;
        this.setRotation(this.Backhead, 0.0F, 0.0F, 0.0F);
        this.bheaddeco = new ModelRenderer(this, 16, 8);
        this.bheaddeco.addBox(-1.5F, -20.0F, 3.5F, 5, 5, 1);
        this.bheaddeco.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bheaddeco.setTextureSize(64, 32);
        this.bheaddeco.mirror = true;
        this.setRotation(this.bheaddeco, 0.0F, 0.0F, 0.0F);
        this.HeadDeco = new ModelRenderer(this, 50, 0);
        this.HeadDeco.addBox(-2.0F, -20.5F, -4.5F, 6, 6, 1);
        this.HeadDeco.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HeadDeco.setTextureSize(64, 32);
        this.HeadDeco.mirror = true;
        this.setRotation(this.HeadDeco, 0.0F, 0.0F, 0.0F);
        this.pist1 = new ModelRenderer(this, 0, 0);
        this.pist1.addBox(-0.9F, -19.0F, 0.0F, 1, 1, 2);
        this.pist1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pist1.setTextureSize(64, 32);
        this.pist1.mirror = true;
        this.setRotation(this.pist1, 0.0F, 0.0F, 0.0F);
        this.pist2 = new ModelRenderer(this, 0, 0);
        this.pist2.addBox(-0.9F, -17.0F, 0.0F, 1, 1, 2);
        this.pist2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pist2.setTextureSize(64, 32);
        this.pist2.mirror = true;
        this.setRotation(this.pist2, 0.0F, 0.0F, 0.0F);
        this.pist3 = new ModelRenderer(this, 0, 0);
        this.pist3.addBox(1.9F, -17.0F, 0.0F, 1, 1, 2);
        this.pist3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pist3.setTextureSize(64, 32);
        this.pist3.mirror = true;
        this.setRotation(this.pist3, 0.0F, 0.0F, 0.0F);
        this.pist4 = new ModelRenderer(this, 0, 0);
        this.pist4.addBox(1.9F, -19.0F, 0.0F, 1, 1, 2);
        this.pist4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pist4.setTextureSize(64, 32);
        this.pist4.mirror = true;
        this.setRotation(this.pist4, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.render(f5);
    }

    public void render(float f5)
    {
        this.HammerBase.render(f5);
        this.Deco1.render(f5);
        this.Deco2.render(f5);
        this.Deco3.render(f5);
        this.handle.render(f5);
        this.head.render(f5);
        this.deco4.render(f5);
        this.deco5.render(f5);
        this.Backhead.render(f5);
        this.bheaddeco.render(f5);
        this.HeadDeco.render(f5);
        this.pist1.render(f5);
        this.pist2.render(f5);
        this.pist3.render(f5);
        this.pist4.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
    }
}
