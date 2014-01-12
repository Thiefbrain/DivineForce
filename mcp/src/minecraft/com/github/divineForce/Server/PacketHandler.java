package com.github.divineForce.server;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import com.github.divineForce.DivineForce;
import com.github.divineForce.client.ClientPacketHandler;
import com.github.divineForce.network.PacketIds;
import com.github.divineForce.utils.EnumUtils;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

import net.minecraft.client.entity.EntityClientPlayerMP;
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
        if (packet.channel.equals(DivineForce.ID))
        {
            if (player instanceof EntityClientPlayerMP)
            {
                clientPacketHandler.onPacketData(manager, packet, (EntityPlayerSP) player);
            }
            else if (player instanceof EntityPlayerMP)
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
        final DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
        short packetId = -1;

        try
        {
            packetId = dataInputStream.readShort();
        }
        catch (final IOException ioException)
        {
            DivineForce.getLogger().warning("Failed to get packet id from packet. Things might not end up well");
        }

        switch (EnumUtils.getEnumConstantById(PacketIds.class, packetId))
        {
            case PACKET_VERSION:
                setClientVersionForPlayer(player.getEntityName(), dataInputStream);
                break;
            default:
                DivineForce.getLogger().warning("Unknown packet ID " + packetId);
                break;
        }
    }

    /**
     * Saves the installed client version of the client
     * 
     * @param playername
     *            The playername
     * @param dataInputStream
     *            The packet data
     * 
     * @see CommonProxy#setClientVersionForPlayer(String, String)
     */
    private void setClientVersionForPlayer(final String playername, final DataInputStream dataInputStream)
    {
        try
        {
            DivineForce.proxy.setClientVersionForPlayer(playername, dataInputStream.readUTF());
        }
        catch (final IOException ioException)
        {
            DivineForce.getLogger().warning("Failed to read mod version from packet!");
        }
    }
}
