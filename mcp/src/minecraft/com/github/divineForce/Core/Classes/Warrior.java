package com.github.divineForce.core.classes;

import com.github.divineForce.internationalization.LanguageManager;

import net.minecraft.item.Item;

/**
 * Warrior character class
 * 
 * @author Thiefbrain
 * @since 31 Dec 2013
 */
public final class Warrior extends CharacterClass
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

    @Override
    public String toString()
    {
        return LanguageManager.getInstance().getLanguageString("class.warrior", "Warrior");
    }

}
