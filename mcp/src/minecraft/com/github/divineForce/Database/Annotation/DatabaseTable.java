package com.github.divineForce.database.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The database table annotation. Used to indicate which database table to use. Needed by the {@link StatementBuilder}
 * 
 * @author Thiefbrain
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DatabaseTable
{
    /**
     * The value of the annotation.
     */
    String value();
}
