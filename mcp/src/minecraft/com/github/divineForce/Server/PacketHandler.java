package com.github.divineForce.server;

import com.github.divineForce.DivineForce;
import com.github.divineForce.client.ClientPacketHandler;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

/**
 * The packet handler (as well as server side handling).
 * 
 * @author Thiefbrain
 */
public class PacketHandler implements IPacketHandler
{

    /** The client packet handler */
    private final ClientPacketHandler clientPacketHandler = new ClientPacketHandler();

    /**
     * {@inheritDoc}
     * 
     * @see cpw.mods.fml.common.network.IPacketHandler#onPacketData(INetworkManager, Packet250CustomPayload, Player)
     */
    @Override
    public final void onPacketData(final INetworkManager manager, final Packet250CustomPayload packet, final Player player)
    {
        if (packet.channel.equals("DivineForce"))
        {
            if (DivineForce.SIDE == Side.CLIENT)
            {
                clientPacketHandler.onPacketData(manager, packet, (EntityPlayerSP) player);
            }
            else if (DivineForce.SIDE == Side.SERVER)
            {
                this.handlePacket(manager, packet, (EntityPlayerMP) player);
            }
            else
            {
                DivineForce.getLogger().warning("Unknown side! Bukkit maybe?");
            }
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString()
    {
        return "[DivineForce packet handler]";
    }

    /**
     * Handles the packet serverside.
     * 
     * @param manager
     *            {@link INetworkManager} The network manager
     * @param packet
     *            {@link Packet250CustomPayload} The packet
     * @param player
     *            {@link EntityPlayerMP} The player
     */
    private void handlePacket(final INetworkManager manager, final Packet250CustomPayload packet, final EntityPlayerMP player)
    {

    }

}
