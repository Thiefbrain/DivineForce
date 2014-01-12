package com.github.divineForce.core;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;

/**
 * This class handles the items of the mod and provides an API for registering them
 * 
 * @author Thiefbrain
 * 
 */
public final class ItemManager
{

    private static ItemManager instance;

    private final Map<String, Item> modItems = new HashMap<>();

    /**
     * Returns an initialized instance of this class
     * 
     * @return ItemManager
     */
    public static ItemManager getInstance()
    {
        if (instance == null)
        {
            instance = new ItemManager();
        }

        return instance;
    }

    private ItemManager()
    {
    }

    /**
     * Registers an item
     * 
     * @param uniqueName
     * @param textureName
     * @return
     */
    public int registerItem(final String uniqueName, final String textureName)
    {
        if (modItems.containsKey(uniqueName))
        {
            throw new IllegalArgumentException("An item with the unique name " + uniqueName + " already exists");
        }

        return 0;
    }

}
