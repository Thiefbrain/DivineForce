package com.github.divineForce.Core;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.github.divineForce.Database.DatabaseManager;

import net.minecraft.entity.player.EntityPlayer;

/**
 * The Character factory class.
 * 
 * @author Thiefbrain
 */
public final class CharacterFactory
{
    /** The instance */
    private static final CharacterFactory INSTANCE = new CharacterFactory();

    /** Characters mapped to player entities */
    private final Map<EntityPlayer, CharacterImpl> characters = new HashMap<EntityPlayer, CharacterImpl>();

    /**
     * Returns the instance.
     * 
     * @return {@link CharacterFactory} instance
     */
    public static CharacterFactory getInstance()
    {
        return CharacterFactory.INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    private CharacterFactory()
    {
    }

    /**
     * Loads a character by the given entity
     * 
     * @param playerEntity
     *            {@link EntityPlayer} The entity.
     * @throws ClassNotFoundException
     *             when the H2 library couldn't be loaded
     * @throws SQLException
     *             on SQL error
     */
    public void loadCharacterByEntity(final EntityPlayer playerEntity) throws ClassNotFoundException, SQLException
    {
        // we don't need to load data if it's already loaded
        if (!characters.containsKey(playerEntity))
        {
            final Connection connection = DatabaseManager.getInstance().getConnection("characters");

            connection.close();
        }
    }

    /**
     * Creates a new character and returns the object.
     * 
     * @param playerEntity
     *            {@link EntityPlayer} The entity.
     * @param characterClass
     *            {@link AbstractCharacterClass} The class.
     * @return {@link CharacterImpl} The character object
     */
    public CharacterImpl newCharacter(final EntityPlayer playerEntity, final AbstractCharacterClass characterClass)
    {
        final CharacterImpl character = new CharacterImpl(playerEntity, characterClass);

        characters.put(playerEntity, character);

        return character;
    }
}
