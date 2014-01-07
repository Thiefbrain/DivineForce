package com.github.divineForce.utils;

import java.io.File;

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

    /**
     * Returns the path part for the given file. The path is automatically transformed to an absolute path.
     * 
     * @param file
     *            The {@link File} to get the path part from
     * @return Path as string
     */
    public static String getPathFromFile(final File file)
    {
        return getPathFromFilename(file.getAbsolutePath());
    }

    /**
     * Returns the path part from the given filename
     * 
     * @param filename
     *            Filename as String
     * @return Path as string
     */
    public static String getPathFromFilename(final String filename)
    {
        return filename.substring(0, filename.lastIndexOf(File.separator));
    }

}
