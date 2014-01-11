package com.github.divineForce.database;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

import com.github.divineForce.database.meta.ColumnMetaData;
import com.github.divineForce.database.meta.TableMetaData;
import com.github.divineForce.utils.StringUtils;

/**
 * This class builds SQL statement for the given instance and class. <b>Note:</b> The DatabaseTable and DatabaseColumn annotations must be there!
 * 
 * @author Thiefbrain
 * 
 */
public class StatementBuilder
{

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
    public static <T> String buildDelete(final T argInstance, final Class<?> argClass) throws InvocationTargetException, IllegalAccessException
    {
        final TableMetaData metaData = TableMetaData.getTableMetaData(argClass);

        final StringBuilder sql = new StringBuilder("DELETE FROM ");
        appendField(sql, metaData.getTableName());

        sql.append(" WHERE ");

        final Iterator<ColumnMetaData> keyColumnsIterator = metaData.getKeyColumns().iterator();

        while (keyColumnsIterator.hasNext())
        {
            final ColumnMetaData keyColumn = keyColumnsIterator.next();
            appendField(sql, keyColumn.getColumn());
            sql.append(" = ");
            appendValue(sql, getColumnValue(argInstance, keyColumn));

            if (keyColumnsIterator.hasNext())
            {
                sql.append(" AND ");
            }
        }

        return sql.toString();
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
    public static <T> String buildInsert(final T argInstance, final Class<?> argClass) throws InvocationTargetException, IllegalAccessException
    {
        final TableMetaData metaData = TableMetaData.getTableMetaData(argClass);

        final StringBuilder sqlStatement = new StringBuilder("INSERT INTO ");
        final StringBuilder fieldBuilder = new StringBuilder();
        final StringBuilder valuesBuilder = new StringBuilder();

        for (final Map.Entry<String, ColumnMetaData> column : metaData.getColumns().entrySet())
        {
            if (fieldBuilder.length() > 0)
            {
                fieldBuilder.append(", ");
            }

            final ColumnMetaData columnMetaData = column.getValue();

            appendField(fieldBuilder, columnMetaData.getColumn());
            appendValue(valuesBuilder, getColumnValue(argInstance, columnMetaData));
        }

        appendField(sqlStatement, metaData.getTableName());
        sqlStatement.append(" (");
        sqlStatement.append(fieldBuilder);
        sqlStatement.append(") VALUES (");
        sqlStatement.append(valuesBuilder);
        sqlStatement.append(")");

        return sqlStatement.toString();
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
    public static <T> String buildMerge(final T argInstance, final Class<?> argClass) throws IllegalAccessException, InvocationTargetException
    {
        final StringBuilder sql = new StringBuilder(buildInsert(argInstance, argClass));
        sql.append(" ON DUPLICATE KEY ");
        sql.append(buildUpdate(argInstance, argClass));

        return sql.toString();
    }

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
    public static String buildSelect(final Class<?> argClass, final String filter) throws IllegalArgumentException
    {
        final StringBuilder sqlStatement = new StringBuilder("SELECT ");
        final StringBuilder fieldBuilder = new StringBuilder();

        final TableMetaData metaData = TableMetaData.getTableMetaData(argClass);

        for (final Map.Entry<String, ColumnMetaData> column : metaData.getColumns().entrySet())
        {
            if (fieldBuilder.length() > 0)
            {
                fieldBuilder.append(", ");
            }

            fieldBuilder.append("`").append(column.getValue().getColumn()).append("`");
        }

        sqlStatement.append(fieldBuilder);
        sqlStatement.append(" FROM `").append(metaData.getTableName()).append("`");
        sqlStatement.append(" WHERE " + filter);

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
    public static <T> String buildUpdate(final T argInstance, final Class<?> argClass) throws InvocationTargetException, IllegalAccessException
    {
        final TableMetaData metaData = TableMetaData.getTableMetaData(argClass);

        final StringBuilder sqlStatement = new StringBuilder("UPDATE ");
        final StringBuilder values = new StringBuilder();

        appendField(sqlStatement, metaData.getTableName());
        sqlStatement.append(" SET ");

        for (final Map.Entry<String, ColumnMetaData> column : metaData.getColumns().entrySet())
        {
            if (values.length() > 0)
            {
                values.append(", ");
            }

            final ColumnMetaData columnMetaData = column.getValue();

            appendField(values, columnMetaData.getColumn());
            values.append(" = ");
            appendValue(values, getColumnValue(argInstance, columnMetaData));
        }

        sqlStatement.append(values);
        sqlStatement.append(" WHERE ");

        final Iterator<ColumnMetaData> keyColumnsIterator = metaData.getKeyColumns().iterator();

        while (keyColumnsIterator.hasNext())
        {
            final ColumnMetaData keyColumn = keyColumnsIterator.next();
            appendField(sqlStatement, keyColumn.getColumn());
            sqlStatement.append(" = ");
            appendValue(sqlStatement, getColumnValue(argInstance, keyColumn));

            if (keyColumnsIterator.hasNext())
            {
                sqlStatement.append(" AND ");
            }
        }

        return sqlStatement.toString();
    }

    /**
     * Appends an escaped field name to the string builder.
     * 
     * @param stringBuilder
     *            The {@link StringBuilder} to append to
     * @param fieldname
     *            The fieldname to escape
     */
    private static void appendField(final StringBuilder stringBuilder, final String fieldname)
    {
        stringBuilder.append('`');
        stringBuilder.append(fieldname);
        stringBuilder.append('`');
    }

    /**
     * Appends a value enclosed by single-quotes to the string builder
     * 
     * @param stringBuilder
     *            The {@link StringBuilder} to append to
     * @param value
     *            The fieldname to escape
     */
    private static void appendValue(final StringBuilder stringBuilder, String value)
    {
        value = value.replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        value = value.replace("'", "\'").replace("\"", "\\\"").replace((char) 0, ' ');

        stringBuilder.append('\'');
        stringBuilder.append(value);
        stringBuilder.append('\'');
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
    private static <T> String getColumnValue(final T argInstance, final ColumnMetaData argColumn) throws InvocationTargetException, IllegalAccessException
    {
        final Class<?> returnType = argColumn.getReturnType();
        final Object object = returnType.cast(argColumn.getGetterMethod().invoke(argInstance, (Object[]) null));

        if (object == null && (argColumn.getFieldType() == FieldType.AUTO_KEY || argColumn.getFieldType() == FieldType.AUTO_VALUE))
        {
            // TODO: Set key (select from sequence) or value (not sure what to do on AUTO_VALUE)
        }

        return StringUtils.nn(object);
    }
}
