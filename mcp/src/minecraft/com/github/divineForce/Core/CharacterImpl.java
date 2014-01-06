package com.github.divineForce.core;

import com.github.divineForce.core.classes.CharacterClass;

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
    private CharacterClass characterClass;
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
     *            {@link CharacterClass} The character class
     */
    CharacterImpl(final EntityPlayer argPlayer, final CharacterClass argCharacterClass)
    {
        characterClass = argCharacterClass;
        player = argPlayer;
    }

    /**
     * Returns the class of the caracter
     * 
     * @return {@link CharacterClass}
     */
    public final CharacterClass getCharacterClass()
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
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof CharacterImpl))
        {
            return false;
        }
        CharacterImpl other = (CharacterImpl) obj;
        if (characterClass == null)
        {
            if (other.characterClass != null)
            {
                return false;
            }
        }
        else if (!characterClass.equals(other.characterClass))
        {
            return false;
        }
        if (id != other.id)
        {
            return false;
        }
        if (level != other.level)
        {
            return false;
        }
        if (player == null)
        {
            if (other.player != null)
            {
                return false;
            }
        }
        else if (!player.equals(other.player))
        {
            return false;
        }
        return true;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((characterClass == null) ? 0 : characterClass.hashCode());
        result = prime * result + id;
        result = prime * result + level;
        result = prime * result + ((player == null) ? 0 : player.hashCode());
        return result;
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

    @Override
    public EntityPlayer getPlayerEntity()
    {
        return player;
    }

    @Override
    public void setCharacterClass(CharacterClass characterClass)
    {
        this.characterClass = characterClass;
    }
}
