package com.github.divineForce.core;

import com.github.divineForce.core.classes.CharacterClass;
import com.github.divineForce.database.FieldType;
import com.github.divineForce.database.annotation.DatabaseColumn;
import com.github.divineForce.database.annotation.DatabaseTable;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Character interface.
 * 
 * @author Thiefbrain
 * 
 */
@DatabaseTable("character")
public interface Character
{

    /**
     * Character ID
     * 
     * @return int ID
     */
    @DatabaseColumn(value = "id", type = FieldType.AUTO_KEY)
    int getId();

    /**
     * Sets the charcter-id
     * 
     * @param id
     *            int
     */
    void setId(int id);

    /**
     * Gets the level of the character
     * 
     * @return int level
     */
    @DatabaseColumn(value = "level", type = FieldType.VALUE)
    int getLevel();

    /**
     * Sets the level of the character
     * 
     * @param level
     *            int new level
     */
    void setLevel(int level);

    /**
     * Returns the player name this character instance belongs to
     * 
     * @return String player name
     */
    @DatabaseColumn(value = "player_name", type = FieldType.VALUE)
    String getPlayerName();

    /**
     * Returns the player entity this character instance belongs to
     * 
     * @return {@link EntityPlayer}
     */
    EntityPlayer getPlayerEntity();

    /**
     * Gets the character class of the character.
     * 
     * @return {@link CharacterClass}
     */
    CharacterClass getCharacterClass();

    /**
     * Sets the character class for the current character
     * 
     * @param characterClass
     *            {@link CharacterClass}
     */
    void setCharacterClass(CharacterClass characterClass);

}
