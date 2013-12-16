package com.github.divineForce.Core;

import net.minecraft.entity.player.EntityPlayer;

/**
 * The character class.
 * 
 * @author Thiefbrain
 */
public class CharacterImpl implements Character
{
    /** The id in the database */
    private int id;
    /** The class of the character */
    private final AbstractCharacterClass characterClass;
    /** The level of the character */
    private int level = 1;
    /** The player entity */
    private final EntityPlayer player;

    /**
     * Creates a new character with the specified class, level and player entity.
     * 
     * @param argPlayer
     *            {@link EntityPlayer} the player to create a character on
     * @param argCharacterClass
     *            {@link AbstractCharacterClass} The character class
     */
    CharacterImpl(final EntityPlayer argPlayer, final AbstractCharacterClass argCharacterClass)
    {
        characterClass = argCharacterClass;
        player = argPlayer;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#equals(Object)
     */
    @Override
    public final boolean equals(final Object another)
    {
        if (!(another instanceof CharacterImpl))
        {
            return false;
        }

        // we assume that the instance is the same if the entity is the same
        if (((CharacterImpl) another).getPlayer().entityId == this.getPlayer().entityId)
        {
            return true;
        }

        return false;
    }

    /**
     * Returns the class of the caracter
     * 
     * @return {@link AbstractCharacterClass}
     */
    public final AbstractCharacterClass getCharacterClass()
    {
        return characterClass;
    }

    @Override
    public int getId()
    {
        return id;
    }

    /**
     * Returns the level of the character
     * 
     * @return int The level
     */
    public final int getLevel()
    {
        return level;
    }

    /**
     * Returns the player entity this character belongs to.
     * 
     * @return {@link EntityPlayer}
     */
    public final EntityPlayer getPlayer()
    {
        return player;
    }

    /**
     * Gets the name of the player
     * 
     * @return The player name
     */
    @Override
    public String getPlayerName()
    {
        return player.getEntityName();
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode()
    {
        final int prime = 31;
        int hash = prime;

        hash += characterClass.hashCode() * prime;
        hash += level * prime;
        hash += player.hashCode() * prime;

        return hash;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString()
    {
        return "[CharacterClass of " + this.player.getDisplayName() + "]";
    }

    @Override
    public void setId(int argId)
    {
        id = argId;
    }

    @Override
    public void setLevel(int argLevel)
    {
        level = argLevel;
    }
}
