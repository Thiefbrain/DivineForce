package com.github.divineForce.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.github.divineForce.DivineForce;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

import net.minecraft.network.packet.Packet250CustomPayload;

public class NetworkHelper
{

    /**
     * Sends a packet containing the installed version of this mod to the client
     * 
     * @param player
     */
    public static void sendModInfoPacketToPlayer(final Player player) throws IOException
    {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        dataOutputStream.writeShort(PacketIds.PACKET_VERSION.getId());
        dataOutputStream.writeUTF(DivineForce.VERSION);

        final Packet250CustomPayload packet = newPacket();
        packet.data = byteArrayOutputStream.toByteArray();
        packet.length = byteArrayOutputStream.size();

        PacketDispatcher.sendPacketToPlayer(packet, player);

        dataOutputStream.close();
        byteArrayOutputStream.close();
    }

    /**
     * Sends a packet containing the installed client version of this mod to the client
     */
    public static void sendModInfoPacketToServer() throws IOException
    {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        dataOutputStream.writeShort(PacketIds.PACKET_VERSION.getId());
        dataOutputStream.writeUTF(DivineForce.VERSION);

        final Packet250CustomPayload packet = newPacket();
        packet.data = byteArrayOutputStream.toByteArray();
        packet.length = byteArrayOutputStream.size();

        PacketDispatcher.sendPacketToServer(packet);

        dataOutputStream.close();
        byteArrayOutputStream.close();
    }

    /**
     * Creates a new packet within the mod channel and returns it
     * 
     * @return {@link Packet250CustomPayload}
     */
    protected static Packet250CustomPayload newPacket()
    {
        final Packet250CustomPayload packet = new Packet250CustomPayload();

        packet.channel = DivineForce.ID;

        return packet;
    }

    private NetworkHelper()
    {
    }

}
