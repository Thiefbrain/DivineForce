package DivineForce;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler 
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player playerEntity) 
	{
        if (packet.channel.equals("GenericRandom"))
        {
            handleRandom(packet);
        }
	}
    
    private void handleRandom(Packet250CustomPayload packet) 
    {
        DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
        
        int randomInt1;
        int randomInt2;
        randomInt1 = 1;
        randomInt2 = 2;

        System.out.println(randomInt1 + " " + randomInt2);
    }
}