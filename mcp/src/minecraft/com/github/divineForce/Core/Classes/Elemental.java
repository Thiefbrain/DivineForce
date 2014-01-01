package com.github.divineForce.Core.Classes;

import com.github.divineForce.Internationalization.LanguageManager;

import net.minecraft.item.Item;

public class Elemental extends CharacterClass
{

    public Elemental()
    {
        super(CharacterClasses.ELEMENTAL);
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
        return LanguageManager.getInstance().getLanguageString("class.elemental", "Elemental");
    }

}
