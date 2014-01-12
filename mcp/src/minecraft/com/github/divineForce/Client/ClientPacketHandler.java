package com.github.divineForce.client;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import com.github.divineForce.DivineForce;
import com.github.divineForce.network.PacketIds;
import com.github.divineForce.utils.EnumUtils;

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
        final DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(packet.data));

        short packetId = -1;

        try
        {
            packetId = dataInputStream.readShort();
        }
        catch (final IOException ioException)
        {
            DivineForce.getLogger().warning("Could not read packet id. Things might not end well.");
        }

        switch (EnumUtils.getEnumConstantById(PacketIds.class, packetId))
        {
            case PACKET_VERSION:
                setRemoteVersion(dataInputStream);
                break;
            default:
                DivineForce.getLogger().warning("Unknown packet ID " + packetId);
        }
    }

    private void setRemoteVersion(final DataInputStream inputStream)
    {
        try
        {
            ((ClientProxy) DivineForce.proxy).setRemoteVersion(inputStream.readUTF());
        }
        catch (final IOException ioException)
        {
            DivineForce.getLogger().warning("Failed to fetch remote mod version!");
        }
    }
}
