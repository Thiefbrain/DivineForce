package com.github.divineForce.Database.Meta;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.github.divineForce.Database.FieldType;
import com.github.divineForce.Database.Annotation.DatabaseTable;

/**
 * Represents a database table set by the {@link DatabaseTable} annotation
 * 
 * @author Thiefbrain
 */
public class TableMetaData
{
    private String databaseTable;
    private Map<String, ColumnMetaData> columns = new HashMap<String, ColumnMetaData>();

    private TableMetaData(Class<?> argClass)
    {
        databaseTable = argClass.getAnnotation(DatabaseTable.class).value();

        Method[] methods = argClass.getDeclaredMethods();
        for (Method method : methods)
        {
            // we only need getter methods
            if (method.getName().startsWith("get") || (method.getName().startsWith("is") && method.getReturnType() == Boolean.TYPE))
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
    public static TableMetaData getTableMetaData(Class<?> argClass)
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
        Collection<ColumnMetaData> keyColumns = Collections.EMPTY_LIST;

        for (ColumnMetaData column : columns.values())
        {
            if (column.getFieldType() == FieldType.KEY || column.getFieldType() == FieldType.AUTO_KEY)
            {
                keyColumns.add(column);
            }
        }

        return keyColumns;
    }

}
