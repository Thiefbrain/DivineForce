package com.github.divineForce.core;

/**
 * Represents an identifyable class
 * 
 * @author Thiefbrain
 * 
 * @param <T>
 *            The type of the id
 */
public interface Identifiable<T>
{

    /**
     * Returns the ID of the element
     * 
     * @return T id
     */
    T getId();

}
