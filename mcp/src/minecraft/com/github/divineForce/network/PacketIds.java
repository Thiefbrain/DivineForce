package com.github.divineForce.network;

import com.github.divineForce.core.Identifiable;

/**
 * Enumeration of packets ids
 * 
 * @author Thiefbrain
 * 
 */
public enum PacketIds implements Identifiable<Short>
{
    PACKET_VERSION(0);

    //
    private short id;

    private PacketIds(final int id)
    {
        this.id = (short) id;
    }

    /**
     * Returns the id as integer value
     * 
     * @return int
     */
    @Override
    public Short getId()
    {
        return id;
    }
}
