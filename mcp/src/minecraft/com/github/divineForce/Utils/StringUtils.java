package com.github.divineForce.Utils;

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

        for (int i = 0; i < array.length; i++)
        {
            if (needle.equalsIgnoreCase(array[i]))
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
    public static String nn(Object o, String def)
    {
        return (o == null ? def : o.toString());
    }

}
