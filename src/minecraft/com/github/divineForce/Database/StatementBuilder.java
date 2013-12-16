package com.github.divineForce.Database;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import com.github.divineForce.Database.Meta.ColumnMetaData;
import com.github.divineForce.Database.Meta.TableMetaData;

/**
 * This class builds SQL statement for the given instance and class. <b>Note:</b> The DatabaseTable and DatabaseColumn annotations must be there!
 * 
 * @author Thiefbrain
 * 
 */
public class StatementBuilder
{

    /**
     * Builds an SQL select statement for the given class
     * 
     * @param instance
     *            The instance of the class
     * @param argClass
     *            The class
     * @return {@link Pair} with the statement
     * @throws IllegalArgumentException
     *             if this class has no @DatabaseTable annotation.
     */
    public static <T> Pair<String, List<?>> buildSelectStatement(T instance, Class<?> argClass) throws IllegalArgumentException
    {
        Pair<String, List<?>> statement = null;
        StringBuilder sqlStatement = new StringBuilder("SELECT ");
        StringBuilder fieldBuilder = new StringBuilder();

        TableMetaData metaData = TableMetaData.getTableMetaData(argClass);

        for (Map.Entry<String, ColumnMetaData> column : metaData.getColumns().entrySet())
        {
            if (fieldBuilder.length() > 0)
            {
                fieldBuilder.append(", ");
            }

            fieldBuilder.append(column.getKey());
        }

        sqlStatement.append(fieldBuilder);
        sqlStatement.append(" FROM ").append(metaData.getTableName());

        return statement;
    }
}
