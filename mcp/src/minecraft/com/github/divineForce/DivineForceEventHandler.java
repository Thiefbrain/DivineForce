package com.github.divineForce;

import java.sql.SQLException;
import java.util.logging.Level;

import com.github.divineForce.Core.CharacterFactory;
import com.github.divineForce.Utils.StringUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
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

            // the world is one of the worlds DivineForce is activated in
            if (StringUtils.arrayContains(DivineForce.getInstance().getWorlds(), world.getWorldInfo().getWorldName()))
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
