package com.github.divineForce.Client;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

/**
 * The client-side packet handler.
 * 
 * @author Thiefbrain
 */
public class ClientPacketHandler
{
    /**
     * Handles packets client-side
     * 
     * @param manager
     *            The network manager
     * @param packet
     *            The packet
     * @param player
     *            The player
     * 
     * @see cpw.mods.fml.common.network.IPacketHandler#onPacketData(INetworkManager, Packet250CustomPayload, Player)
     */
    public void onPacketData(final INetworkManager manager, final Packet250CustomPayload packet, final EntityPlayerSP player)
    {

    }
}
