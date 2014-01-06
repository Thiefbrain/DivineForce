package com.github.divineForce.utils;

/**
 * Some string utils
 * 
 * @author Thiefbrain
 * 
 */
public final class StringUtils
{

    // empty constructor to prevent instance creation
    private StringUtils()
    {
    }

    /**
     * Returns true if the String array contains a string.
     * 
     * @param array
     *            The String-Array
     * @param needle
     *            The String to look for
     * @return true if the array contains the string, false otherwise
     */
    public static boolean arrayContains(final String[] array, String needle)
    {
        needle = nn(needle);

        for (final String element : array)
        {
            if (needle.equalsIgnoreCase(element.trim()))
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Converts a object to a string. If the object is null, a empty string will be returned
     * 
     * @param o
     *            The {@link Object} to convert to a string
     * @return String representation of the object
     */
    public static String nn(final Object o)
    {
        return nn(o, "");
    }

    /**
     * Converts a object to a string or returns the default value if the object is null
     * 
     * @param o
     *            The {@link Object} to convert to a string
     * @param def
     *            The default {@link String}
     * @return
     */
    public static String nn(final Object o, final String def)
    {
        return (o == null ? def : o.toString());
    }

}
