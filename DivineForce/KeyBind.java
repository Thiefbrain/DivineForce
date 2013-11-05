package DivineForce;
import java.util.EnumSet;
import java.util.Iterator;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

class KeyBind extends KeyHandler
{
         private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
         public static boolean keyPressed = false;       
         
         public KeyBind(KeyBinding[] keyBindings, boolean[] repeatings)
         {
        	 super(keyBindings, repeatings);
         }
         @Override
         public String getLabel()
         {
             return "DivineForceKey";
         }
         @Override
         public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
         {
        	 keyPressed = true;
         }
         @Override
         public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
         {
        	 keyPressed = false;
         }
         @Override
         public EnumSet<TickType> ticks()
         {
             return tickTypes;
         }
}