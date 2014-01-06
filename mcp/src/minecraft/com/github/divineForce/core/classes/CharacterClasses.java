package com.github.divineForce.core.classes;

/**
 * IDs for the charcter classes
 * 
 * @author Thiefbrain
 * @since 31 Dec 2013
 */
public enum CharacterClasses
{
    WARRIOR(100), ARMS(110), BERSERKER(120), GUARDIAN(130),
    ROGUE(200), FIGHTER(201), ASSASSIN(202), SNIPER(203),
    MAGE(300), ARCANE(301), ELEMENTAL(302), HOLY(303);

    private int id;

    private CharacterClasses(int argId)
    {
        id = argId;
    }

    /**
     * Returns the ID
     * 
     * @return int
     */
    public int getId()
    {
        return id;
    }
}
