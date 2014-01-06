package com.github.divineForce.database.meta;

import java.lang.reflect.Method;

import com.github.divineForce.database.FieldType;
import com.github.divineForce.database.annotation.DatabaseColumn;

/**
 * Represents a column defined by the {@link DatabaseColumn} annotation.
 * 
 * @author Thiefbrain
 */
public class ColumnMetaData
{
    private final String column;
    private final FieldType fieldType;
    private final Method getterMethod;
    private boolean isReadonly;
    private final Class<?> returnType;
    private Method setterMethod;

    public ColumnMetaData(final Method argGetterMethod)
    {
        getterMethod = argGetterMethod;
        column = argGetterMethod.getAnnotation(DatabaseColumn.class).value();
        fieldType = argGetterMethod.getAnnotation(DatabaseColumn.class).type();
        returnType = argGetterMethod.getReturnType();

        String property = argGetterMethod.getName().replace("get", "").replace("is", "");
        try
        {
            setterMethod = argGetterMethod.getClass().getMethod("set" + property, returnType);
            isReadonly = false;
        }
        catch (Exception exception)
        {
            setterMethod = null;
            isReadonly = true;
        }
    }

    /**
     * @return FieldType
     */
    public FieldType getFieldType()
    {
        return fieldType;
    }

    /**
     * @return Column name
     */
    public String getColumn()
    {
        return column;
    }

    /**
     * @return getter method
     */
    public Method getGetterMethod()
    {
        return getterMethod;
    }

    /**
     * @return true if value is readonly
     */
    public boolean isReadonly()
    {
        return isReadonly;
    }

    /**
     * @return the return type
     */
    public Class<?> getReturnType()
    {
        return returnType;
    }

    /**
     * @return setter method
     */
    public Method getSetterMethod()
    {
        return setterMethod;
    }

}
