package com.github.divineForce.Database;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

            fieldBuilder.append("`").append(column.getValue().getColumn()).append("`");
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
        TableMetaData metaData = TableMetaData.getTableMetaData(argClass);

        StringBuilder sqlStatement = new StringBuilder("INSERT INTO ");
        StringBuilder fieldBuilder = new StringBuilder();
        StringBuilder valuesBuilder = new StringBuilder();

        for (Map.Entry<String, ColumnMetaData> column : metaData.getColumns().entrySet())
        {
            if (fieldBuilder.length() > 0)
            {
                fieldBuilder.append(", ");
            }
            fieldBuilder.append("`").append(column.getValue().getColumn()).append("`");

            ColumnMetaData columnMetaData = column.getValue();
            Class<?> returnType = columnMetaData.getReturnType();
            valuesBuilder.append("'").append(getColumnValue(argInstance, columnMetaData)).append("'");
        }

        sqlStatement.append("`").append(metaData.getTableName()).append("` (");
        sqlStatement.append(fieldBuilder);
        sqlStatement.append(") VALUES (");
        sqlStatement.append(valuesBuilder);
        sqlStatement.append(")");

        return sqlStatement.toString();
    }

    /**
     * Creates an UPDATE statement from the given instance and class
     * 
     * @param argInstance
     *            The instance to get the data from
     * @param argClass
     *            The class or interface representating the database table
     * @return SQL string
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static <T> String buildUpdate(T argInstance, Class<?> argClass) throws InvocationTargetException, IllegalAccessException
    {
        TableMetaData metaData = TableMetaData.getTableMetaData(argClass);

        StringBuilder sqlStatement = new StringBuilder("UPDATE ");
        StringBuilder values = new StringBuilder();

        sqlStatement.append("`").append(metaData.getTableName()).append("`");
        sqlStatement.append(" SET ");

        for (Map.Entry<String, ColumnMetaData> column : metaData.getColumns().entrySet())
        {
            if (values.length() > 0)
            {
                values.append(", ");
            }
            values.append("`").append(column.getValue().getColumn()).append("`");
            values.append(" = '").append(getColumnValue(argInstance, column.getValue())).append("'");
        }

        sqlStatement.append(values);
        sqlStatement.append(" WHERE ");

        Iterator<ColumnMetaData> keyColumnsIterator = metaData.getKeyColumns().iterator();

        while (keyColumnsIterator.hasNext())
        {
            ColumnMetaData keyColumn = keyColumnsIterator.next();
            sqlStatement.append("`").append(keyColumn.getColumn()).append("` = '").append(getColumnValue(argInstance, keyColumn)).append("'");

            if (keyColumnsIterator.hasNext())
            {
                sqlStatement.append(" AND ");
            }
        }

        return sqlStatement.toString();
    }

    /**
     * Builds an SQL delete statement.
     * 
     * @param argInstance
     *            The instance to get the data from
     * @param argClass
     *            The class or interface representating the database table
     * @return SQL string
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static <T> String buildDelete(T argInstance, Class<?> argClass) throws InvocationTargetException, IllegalAccessException
    {
        TableMetaData metaData = TableMetaData.getTableMetaData(argClass);

        StringBuilder sql = new StringBuilder("DELETE FROM ");
        sql.append("`").append(metaData.getTableName()).append("`");

        sql.append(" WHERE ");

        Iterator<ColumnMetaData> keyColumnsIterator = metaData.getKeyColumns().iterator();

        while (keyColumnsIterator.hasNext())
        {
            ColumnMetaData keyColumn = keyColumnsIterator.next();
            sql.append("`").append(keyColumn.getColumn()).append("` = '").append(getColumnValue(argInstance, keyColumn)).append("'");

            if (keyColumnsIterator.hasNext())
            {
                sql.append(" AND ");
            }
        }

        return sql.toString();
    }

    /**
     * Builds an INSERT INTO ... ON DUPLICATE KEY UPDATE statement.
     * 
     * @param argInstance
     *            The instance to get the data from
     * @param argClass
     *            The class representing the database table
     * @return String SQL
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static <T> String buildMerge(T argInstance, Class<?> argClass) throws IllegalAccessException, InvocationTargetException
    {
        StringBuilder sql = new StringBuilder(buildInsert(argInstance, argClass));
        sql.append(" ON DUPLICATE KEY ");
        sql.append(buildUpdate(argInstance, argClass));

        return sql.toString();
    }

    /**
     * Returns the string repesentation of the object
     * 
     * @param argInstance
     * @param argColumn
     * @return
     * @throws InvocationTargetException
     * @throws {@link IllegalAccessException}
     */
    private static <T> String getColumnValue(T argInstance, ColumnMetaData argColumn) throws InvocationTargetException, IllegalAccessException
    {
        Class<?> returnType = argColumn.getReturnType();
        Object object = returnType.cast(argColumn.getGetterMethod().invoke(argInstance, (Object[]) null));

        if (object == null && (argColumn.getFieldType() == FieldType.AUTO_KEY) || argColumn.getFieldType() == FieldType.AUTO_VALUE)
        {
            // TODO: Set key (select from sequence) or value (not sure what to do on AUTO_VALUE)
        }

        return object.toString();
    }
}
