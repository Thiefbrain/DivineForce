package DivineForce;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBerserkerArmor extends ModelBiped
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;

    public ModelBerserkerArmor(float par1, float par2, int par3, int par4)
    {
        this.textureWidth = 65;
        this.textureHeight = 64;
        this.Shape1 = new ModelRenderer(this, 0, 40);
        this.Shape1.addBox(4.0F, -8.0F, 0.0F, 1, 3, 3, par1 / 2.0F);
        this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape1.setTextureSize(65, 64);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
        this.Shape2 = new ModelRenderer(this, 0, 32);
        this.Shape2.addBox(5.0F, -8.5F, 0.5F, 1, 2, 2, par1 / 2.0F);
        this.Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape2.setTextureSize(65, 64);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
        this.Shape3 = new ModelRenderer(this, 0, 36);
        this.Shape3.addBox(6.0F, -10.0F, 1.0F, 1, 3, 1, par1 / 2.0F);
        this.Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape3.setTextureSize(65, 64);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
        this.Shape4 = new ModelRenderer(this, 0, 40);
        this.Shape4.addBox(-5.0F, -8.0F, -1.0F, 1, 3, 3, par1 / 2.0F);
        this.Shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape4.setTextureSize(65, 64);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
        this.Shape5 = new ModelRenderer(this, 0, 32);
        this.Shape5.addBox(-6.0F, -8.5F, -0.5F, 1, 2, 2, par1 / 2.0F);
        this.Shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape5.setTextureSize(65, 64);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
        this.Shape6 = new ModelRenderer(this, 8, 39);
        this.Shape6.addBox(-1.0F, -3.0F, -2.5F, 5, 2, 5, par1);
        this.Shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape6.setTextureSize(65, 64);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, 0.0F, 0.0F, 0.3490659F);
        this.Shape7 = new ModelRenderer(this, 10, 32);
        this.Shape7.addBox(0.0F, -5.5F, -0.5F, 1, 3, 1, par1 / 2.0F);
        this.Shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape7.setTextureSize(65, 64);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, 0.0F, 0.0F, 0.4014257F);
        this.Shape8 = new ModelRenderer(this, 14, 32);
        this.Shape8.addBox(1.0F, -5.5F, -0.5F, 1, 2, 1, par1 / 2.0F);
        this.Shape8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape8.setTextureSize(65, 64);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, 0.0F, 0.0F, 0.8203047F);
        this.Shape9 = new ModelRenderer(this, 8, 39);
        this.Shape9.addBox(-4.0F, -3.0F, -2.5F, 5, 2, 5, par1);
        this.Shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape9.setTextureSize(65, 64);
        this.Shape9.mirror = true;
        this.setRotation(this.Shape9, 0.0F, 0.0F, -0.3490659F);
        this.Shape10 = new ModelRenderer(this, 14, 32);
        this.Shape10.addBox(-2.0F, -5.5F, -0.5F, 1, 2, 1, par1 / 2.0F);
        this.Shape10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape10.setTextureSize(65, 64);
        this.Shape10.mirror = true;
        this.setRotation(this.Shape10, 0.0F, 0.0F, -0.8203047F);
        this.Shape11 = new ModelRenderer(this, 10, 32);
        this.Shape11.addBox(-1.0F, -5.5F, -0.5F, 1, 3, 1, par1 / 2.0F);
        this.Shape11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape11.setTextureSize(65, 64);
        this.Shape11.mirror = true;
        this.setRotation(this.Shape11, 0.0F, 0.0F, -0.3490659F);
        this.bipedRightArm.addChild(this.Shape11);
        this.bipedRightArm.addChild(this.Shape10);
        this.bipedRightArm.addChild(this.Shape9);
        this.bipedLeftArm.addChild(this.Shape8);
        this.bipedLeftArm.addChild(this.Shape7);
        this.bipedLeftArm.addChild(this.Shape6);
        this.bipedHead.addChild(this.Shape1);
        this.bipedHead.addChild(this.Shape2);
        this.bipedHead.addChild(this.Shape3);
        this.bipedHead.addChild(this.Shape4);
        this.bipedHead.addChild(this.Shape5);
    }

    public void showHorns(boolean show)
    {
        this.Shape1.showModel = this.Shape2.showModel = this.Shape3.showModel = this.Shape4.showModel = this.Shape5.showModel = show;
    }

    public void showSpaulders(boolean show)
    {
        this.Shape6.showModel = this.Shape7.showModel = this.Shape8.showModel = this.Shape9.showModel = this.Shape10.showModel = this.Shape11.showModel = show;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
