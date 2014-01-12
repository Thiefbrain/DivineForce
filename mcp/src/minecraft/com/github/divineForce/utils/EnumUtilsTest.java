package com.github.divineForce.utils;

import org.junit.Assert;
import org.junit.Test;

import com.github.divineForce.network.PacketIds;
import com.google.common.annotations.VisibleForTesting;

/**
 * EnumUtils test class
 * 
 * @author Thiefbrain
 * 
 */
@VisibleForTesting
public class EnumUtilsTest
{

    @Test
    public void testGetEnumConstantById()
    {
        Assert.assertEquals(PacketIds.PACKET_VERSION, EnumUtils.getEnumConstantById(PacketIds.class, (short) 0));
    }

}
