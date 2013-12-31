package com.github.divineForce.Utils;

public class StringUtils
{

    /**
     * Converts a object to a string. If the object is null, a empty string will be returned
     * 
     * @param o
     *            The {@link Object} to convert
     * @return String representation of the object
     */
    public static String nn(final Object o)
    {
        return (o == null ? "" : o.toString());
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
}
