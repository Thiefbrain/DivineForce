package com.github.divineForce.Database.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.divineForce.Database.FieldType;

/**
 * Defines which column the field represents.
 * 
 * @author Thiefbrain
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DatabaseColumn
{
    /**
     * The value of the annotation
     */
    String value();

    /**
     * The type of the column
     */
    FieldType type();
}
