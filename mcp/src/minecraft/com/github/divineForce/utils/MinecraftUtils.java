package com.github.divineForce.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

/**
 * Minecraft utility functions
 * 
 * @author Thiefbrain
 * 
 */
public final class MinecraftUtils
{

    /**
     * Checks if the player entity is an operator.
     * 
     * @param player
     *            {@link EntityPlayer} to check
     * @return true if the player is an op, false otherwise
     */
    public static boolean isOp(final EntityPlayer player)
    {
        return isOp(player.getEntityName());
    }

    /**
     * Checks if a player with the given name is an operator.
     * 
     * @param player
     *            The player name
     * @return true if the player with the given name is an op, false otherwise
     */
    public static boolean isOp(final String player)
    {
        return MinecraftServer.getServer().getConfigurationManager().isPlayerOpped(player);
    }

    private MinecraftUtils()
    {
    }

}
