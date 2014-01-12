package com.github.divineForce.utils;

import com.github.divineForce.core.Identifiable;

/**
 * Enumeration utils
 * 
 * @author Thiefbrain
 * 
 */
public class EnumUtils
{

    /**
     * Returns an enumeration value for the given value.
     * 
     * @param enumeration
     *            The enumeration (must implement {@link Identifiable})
     * @param value
     *            The value to find
     * @return The enumeration member or null if a enum member could not be found
     */
    public static <T extends Enum<T> & Identifiable<E>, E extends Object> T getEnumConstantById(final Class<T> enumeration, final E value)
    {
        for (final T constant : enumeration.getEnumConstants())
        {
            if (constant.getId().equals(value))
            {
                return constant;
            }
        }

        return null;
    }

    private EnumUtils()
    {
    }
}
