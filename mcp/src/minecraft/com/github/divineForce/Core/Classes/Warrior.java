package com.github.divineForce.Core.Classes;

import net.minecraft.item.Item;

/**
 * Warrior character class
 * 
 * @author Thiefbrain
 * @since 31 Dec 2013
 */
public class Warrior extends CharacterClass
{

    public Warrior()
    {
        super(CharacterClasses.WARRIOR);
    }

    @Override
    public boolean canUseItem(Item item)
    {
        // TODO: Select items which can be used by the class
        return false;
    }

}
