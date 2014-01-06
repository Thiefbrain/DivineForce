package com.github.divineForce.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.github.divineForce.core.classes.CharacterClass;
import com.github.divineForce.core.classes.CharacterClasses;
import com.github.divineForce.database.DatabaseCache;
import com.github.divineForce.database.DatabaseManager;
import com.github.divineForce.database.StatementBuilder;

import net.minecraft.entity.player.EntityPlayer;

/**
 * The Character factory class.
 * 
 * @author Thiefbrain
 */
public final class CharacterFactory extends DatabaseCache
{
    /** The instance */
    private static final CharacterFactory INSTANCE = new CharacterFactory();

    /** Characters mapped to player entities */
    private final Map<EntityPlayer, Character> characters = new HashMap<EntityPlayer, Character>();

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
     * Loads a character by the given entity into the memory.
     * 
     * @param playerEntity
     *            {@link EntityPlayer} The entity.
     * @throws ClassNotFoundException
     *             when the H2 library couldn't be loaded
     * @throws SQLException
     *             on SQL error
     * @return true if the character could be loaded, false otherwise
     */
    public boolean loadCharacterByEntity(final EntityPlayer playerEntity) throws ClassNotFoundException, SQLException
    {
        return loadCharacterByEntity(playerEntity, false);
    }

    /**
     * Loads a character by the given entity into the memory or optionally creates a new. Returns false if and only if a character could not be found for the
     * given entity and a new one should not be created
     * 
     * @param playerEntity
     *            {@link EntityPlayer} player entity
     * @param createNew
     *            boolean whether to create a new character or not
     * @return true
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean loadCharacterByEntity(final EntityPlayer playerEntity, boolean createNew) throws ClassNotFoundException, SQLException
    {
        boolean success = false;

        // we don't need to load data if it's already loaded
        if (!characters.containsKey(playerEntity))
        {
            final Connection connection = DatabaseManager.getInstance().getConnection("characters");

            String statement = StatementBuilder.buildSelect(Character.class, "player_name = '" + playerEntity.getEntityName() + "'");
            ResultSet resultSet = DatabaseManager.getInstance().sqlSelect(statement, connection);

            Character character = null;

            if (resultSet.next())
            {
                character = newCharacter(playerEntity, null);

                character.setId(resultSet.getInt("id"));
                character.setLevel(resultSet.getInt("level"));
            }
            else if (createNew)
            {
                character = newCharacter(playerEntity, null);

                character.setLevel(1);
            }

            if (character != null)
            {
                characters.put(playerEntity, character);
                success = true;
            }

            resultSet.close();
            connection.close();
        }

        return success;
    }

    /**
     * Creates a new character and returns the object.
     * 
     * @param playerEntity
     *            {@link EntityPlayer} The entity.
     * @param characterClass
     *            {@link CharacterClass} The class.
     * @return {@link CharacterImpl} The character object
     */
    public CharacterImpl newCharacter(final EntityPlayer playerEntity, final CharacterClass characterClass)
    {
        final CharacterImpl character = new CharacterImpl(playerEntity, characterClass);

        characters.put(playerEntity, character);

        return character;
    }

    @Override
    protected void addRelevantTables()
    {
        addRelevantTable("character");
    }

    @Override
    public void clearCache()
    {

    }
}
