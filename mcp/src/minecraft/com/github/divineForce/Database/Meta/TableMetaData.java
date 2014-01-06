package com.github.divineForce.database.meta;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.github.divineForce.database.FieldType;
import com.github.divineForce.database.annotation.DatabaseColumn;
import com.github.divineForce.database.annotation.DatabaseTable;

/**
 * Represents a database table set by the {@link DatabaseTable} annotation
 * 
 * @author Thiefbrain
 */
public class TableMetaData
{
    private final String databaseTable;
    private final Map<String, ColumnMetaData> columns = new HashMap<String, ColumnMetaData>();

    private TableMetaData(final Class<?> argClass)
    {
        databaseTable = argClass.getAnnotation(DatabaseTable.class).value();

        final Method[] methods = argClass.getDeclaredMethods();
        for (final Method method : methods)
        {
            // we only need getter methods
            if (method.isAnnotationPresent(DatabaseColumn.class) && method.getName().startsWith("get")
                    || (method.getName().startsWith("is") && method.getReturnType() == Boolean.TYPE))
            {
                columns.put(method.getName().replace("get", "").replace("is", ""), new ColumnMetaData(method));
            }
        }
    }

    /**
     * Gets the meta data.
     * 
     * @param argClass
     *            The class
     * @return {@link TableMetaData} instance
     */
    public static TableMetaData getTableMetaData(final Class<?> argClass)
    {
        if (argClass.isAnnotationPresent(DatabaseTable.class))
        {
            return new TableMetaData(argClass);
        }
        else
        {
            throw new IllegalArgumentException("The specified class doesn't have a DatabaseTable annotation.");
        }
    }

    /**
     * Returns a map with all columns.
     * 
     * @return Map
     */
    public Map<String, ColumnMetaData> getColumns()
    {
        return columns;
    }

    public String getTableName()
    {
        return databaseTable;
    }

    /**
     * Returns all columns which are keys.
     * 
     * @return Collection
     */
    public Collection<ColumnMetaData> getKeyColumns()
    {
        final Collection<ColumnMetaData> keyColumns = Collections.EMPTY_LIST;

        for (final ColumnMetaData column : columns.values())
        {
            if (column.getFieldType() == FieldType.KEY || column.getFieldType() == FieldType.AUTO_KEY)
            {
                keyColumns.add(column);
            }
        }

        return keyColumns;
    }

}
