package com.github.divineForce.Core.Classes;

import com.github.divineForce.Internationalization.LanguageManager;

import net.minecraft.item.Item;

/**
 * Warrior character class
 * 
 * @author Thiefbrain
 * @since 31 Dec 2013
 */
public class Arcane extends CharacterClass
{

    public Arcane()
    {
        super(CharacterClasses.ARCANE);
    }

    @Override
    public boolean canUseItem(Item item)
    {
        // TODO: Select items which can be used by the class
        return false;
    }

    @Override
    public String toString()
    {
        return LanguageManager.getInstance().getLanguageString("class.arcane", "Arcane");
    }

}
