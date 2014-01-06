package com.github.divineForce.core.classes;

import com.github.divineForce.internationalization.LanguageManager;

import net.minecraft.item.Item;

public class Mage extends CharacterClass
{

    public Mage()
    {
        super(CharacterClasses.MAGE);
    }

    @Override
    public boolean canUseItem(Item item)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String toString()
    {
        return LanguageManager.getInstance().getLanguageString("class.mage", "Mage");
    }

}
