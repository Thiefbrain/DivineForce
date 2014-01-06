package com.github.divineForce.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Database caching implementation
 * 
 * @author Thiefbrain
 * @since
 */
public abstract class DatabaseCache
{

    private List<String> relevantTables = new ArrayList<>();

    protected DatabaseCache()
    {
        addRelevantTables();
    }

    protected void addRelevantTable(String table)
    {
        relevantTables.add(table);
    }

    protected abstract void addRelevantTables();

    public abstract void clearCache();

}
