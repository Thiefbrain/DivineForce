package com.github.divineForce.Core.Classes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;

/**
 * Representation of the character classes
 * 
 * @author Thiefbrain
 * @since 31 Dec 2013
 */
public abstract class CharacterClass
{

    /**
     * IDs for the character classes
     * 
     * @author Thiefbrain
     * @since 31 Dec 2013
     */
    public static enum CharacterClasses
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

    protected int classId;
    private static Map<CharacterClasses, CharacterClass> instances = new HashMap<>();

    protected CharacterClass(final CharacterClasses classId)
    {
        this.classId = classId.getId();
        instances.put(classId, this);
    }

    /**
     * Returns the character class with the given ID or null if it isn't loaded
     * 
     * @param characterClass
     *            The ID of the character class
     * @return The instance of the character class or null
     */
    public static CharacterClass getCharacterClass(CharacterClasses characterClass)
    {
        return instances.get(characterClass);
    }

    /**
     * Returns true if the class can use a specific item
     * 
     * @param item
     *            {@link Item} The item
     * @return true if it can use the item, false otherwise
     */
    public abstract boolean canUseItem(final Item item);

    /**
     * Returns true if the class is a subclass (not one of Warrior, Rogue or Mage)
     * 
     * @return true or false
     */
    public boolean isSubclass()
    {
        return (classId % 100 > 0);
    }

    /**
     * Returns true if the class is subclass of the other class
     * 
     * @param otherClass
     *            {@link CharacterClass}
     * @return true or false
     */
    public boolean isSubclassOf(final CharacterClass otherClass)
    {
        return ((int) otherClass.classId / 100 == (int) classId / 100 && otherClass.classId / 100.0f < classId / 100.0f);
    }
}
