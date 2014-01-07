package com.github.divineForce;

import java.sql.SQLException;
import java.util.logging.Level;

import com.github.divineForce.core.CharacterFactory;
import com.github.divineForce.utils.StringUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

/**
 * This is the main event handler class. All events are in here.
 * 
 * @author Thiefbrain
 * 
 */
public class DivineForceEventHandler
{

    /**
     * This event handler is called when an entity joins a world.
     * 
     * @param entityJoinWorldEvent
     *            The event
     */
    @ForgeSubscribe
    public final void onEntityJoinWorld(final EntityJoinWorldEvent entityJoinWorldEvent)
    {
        // we only want to handle the player for now
        if (entityJoinWorldEvent.entity instanceof EntityPlayer)
        {
            // get the world
            final World world = entityJoinWorldEvent.world;
            final EntityPlayer player = (EntityPlayer) entityJoinWorldEvent.entity;

            // we only want database handling server-side
            if (world instanceof WorldServer)
            {
                final String worlds = DivineForceConfig.getInstance().getValueAsString("Worlds", "general", "");

                // the world is one of the worlds DivineForce is activated in
                if (StringUtils.arrayContains(worlds.split(","), world.getWorldInfo().getWorldName()))
                {
                    try
                    {
                        CharacterFactory.getInstance().loadCharacterByEntity(player);
                    }
                    catch (final SQLException sqlException)
                    {
                        DivineForce.getLogger().log(Level.SEVERE, "SQL Exception whilst player joining world", sqlException);
                    }
                    catch (final ClassNotFoundException classNotFoundException)
                    {
                        DivineForce.getLogger().log(Level.SEVERE, "Failed to load H2 database driver!", classNotFoundException);
                    }
                }
            }
        }
    }

}
