package com.github.divineForce.Core;

import com.github.divineForce.Database.FieldType;
import com.github.divineForce.Database.Annotation.DatabaseColumn;
import com.github.divineForce.Database.Annotation.DatabaseTable;

/**
 * Character interface.
 * 
 * @author Thiefbrain
 * 
 */
@DatabaseTable("character")
public interface Character
{

    @DatabaseColumn(value = "id", type = FieldType.AUTO_KEY)
    int getId();

    void setId(int id);

    @DatabaseColumn(value = "level", type = FieldType.VALUE)
    int getLevel();

    void setLevel(int level);

    @DatabaseColumn(value = "player_name", type = FieldType.VALUE)
    String getPlayerName();

}
