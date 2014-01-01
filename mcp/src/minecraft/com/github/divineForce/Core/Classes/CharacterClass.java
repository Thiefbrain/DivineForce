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
     * @param argCharacterClass
     *            The ID of the character class
     * @return The instance of the character class or null
     */
    public final static CharacterClass getCharacterClass(CharacterClasses argCharacterClass)
    {
        CharacterClass characterClass = instances.get(argCharacterClass);

        if (characterClass == null)
        {
            switch (argCharacterClass)
            {
                case ARCANE:
                    characterClass = new Arcane();
                    break;
                case ARMS:
                    characterClass = new Arms();
                    break;
                case ASSASSIN:
                    characterClass = new Assassin();
                    break;
                case BERSERKER:
                    characterClass = new Berserker();
                    break;
                case ELEMENTAL:
                    characterClass = new Elemental();
                    break;
                case FIGHTER:
                    characterClass = new Fighter();
                    break;
                case GUARDIAN:
                    characterClass = new Guardian();
                    break;
                case HOLY:
                    characterClass = new Holy();
                    break;
                case MAGE:
                    characterClass = new Mage();
                    break;
                case ROGUE:
                    characterClass = new Rogue();
                    break;
                case SNIPER:
                    characterClass = new Sniper();
                    break;
                case WARRIOR:
                    characterClass = new Warrior();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown Class-ID " + argCharacterClass);
            }
        }

        return characterClass;
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
    public final boolean isSubclass()
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
    public final boolean isSubclassOf(final CharacterClass otherClass)
    {
        return (otherClass.classId / 100 == classId / 100 && otherClass.classId / 100.0f < classId / 100.0f);
    }

    /**
     * Returns the name of the class as string
     */
    @Override
    public abstract String toString();
}
