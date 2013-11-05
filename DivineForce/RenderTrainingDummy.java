package DivineForce;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderTrainingDummy extends RenderBiped
{
	public static ResourceLocation texture = new ResourceLocation("DivineForce","textures/mobs/TrainingDummy.png");
	
	public RenderTrainingDummy(ModelBiped var1, float shadow)
    {
		super(var1, shadow);
    }
	
    protected ResourceLocation getEntityTexture(Entity entity) 
    {
    	return texture;
   	}
}
