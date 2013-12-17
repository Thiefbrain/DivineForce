package com.github.divineForce.Database;

import java.lang.reflect.InvocationTargetException;
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
     * @return SQL Statement
     * @throws IllegalArgumentException
     *             if this class has no @DatabaseTable annotation.
     */
    public static String buildSelectStatement(Class<?> argClass) throws IllegalArgumentException
    {
        StringBuilder sqlStatement = new StringBuilder("SELECT ");
        StringBuilder fieldBuilder = new StringBuilder();

        TableMetaData metaData = TableMetaData.getTableMetaData(argClass);

        for (Map.Entry<String, ColumnMetaData> column : metaData.getColumns().entrySet())
        {
            if (fieldBuilder.length() > 0)
            {
                fieldBuilder.append(", ");
            }

            fieldBuilder.append("`").append(column.getKey()).append("`");
        }

        sqlStatement.append(fieldBuilder);
        sqlStatement.append(" FROM ").append(metaData.getTableName());

        return sqlStatement.toString();
    }

    /**
     * Build an insert statement for the given class with the given instance.
     * 
     * @param argInstance
     *            The instance to get the values from
     * @param argClass
     *            The class to get the MySQL table and columns from
     * @return The statement
     * @throws InvocationTargetException
     *             If the getter method throws an exception
     * @throws IllegalAccessException
     *             If the getter method is not accessible
     */
    public static <T> String buildInsert(T argInstance, Class<?> argClass) throws InvocationTargetException, IllegalAccessException
    {
        Pair<String, List<?>> statement;
        StringBuilder sqlStatement = new StringBuilder("INSERT INTO ");
        StringBuilder fieldBuilder = new StringBuilder();
        StringBuilder valuesBuilder = new StringBuilder();

        TableMetaData metaData = TableMetaData.getTableMetaData(argClass);

        for (Map.Entry<String, ColumnMetaData> column : metaData.getColumns().entrySet())
        {
            if (fieldBuilder.length() > 0)
            {
                fieldBuilder.append(", ");
            }
            fieldBuilder.append("`").append(column.getKey()).append("`");

            ColumnMetaData columnMetaData = column.getValue();
            Class<?> returnType = columnMetaData.getReturnType();
            valuesBuilder.append("'").append(returnType.cast((columnMetaData.getGetterMethod().invoke(argInstance, (Object[]) null)))).append("'");
        }

        sqlStatement.append("`").append(metaData.getTableName()).append("` (");
        sqlStatement.append(fieldBuilder);
        sqlStatement.append(") VALUES (");
        sqlStatement.append(valuesBuilder);
        sqlStatement.append(")");

        return sqlStatement.toString();
    }
}
