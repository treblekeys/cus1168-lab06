package academy.javapro.week9.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * A generic repository for storing and retrieving items of type T.
 * @param <T> the type of items stored in this repository
 */
public class Repository<T> {
    // TODO: Add a private final List field called items that stores items of type T.
    /**
     * Constructs a new empty repository.
     */
    public Repository() {
        // TODO: Initialize the items field with a new ArrayList.
    }

    /**
     * Adds an item to the repository.
     * @param item the item to add
     * @return true if the item was added successfully
     * @throws IllegalArgumentException if the item is null
     */
    public boolean add(T item) {
        // TODO: Throw an IllegalArgumentException with the message "Item cannot be null" if the item is null.

        // TODO: Add the item to the items list and return the result.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Removes an item from the repository.
     * @param item the item to remove
     * @return true if the item was removed successfully
     */
    public boolean remove(T item) {
        // TODO: Remove the item from the items list and return the result.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Finds items that match the given predicate.
     * @param predicate the condition to match
     * @return a list of matching items
     * @throws IllegalArgumentException if the predicate is null
     */
    public List<T> find(Predicate<T> predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate cannot be null");
        }
        // TODO:  Return a list of items using stream().filter(predicate).collect(Collectors.toList()) on the items list.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Gets all items in the repository.
     * @return an unmodifiable list of all items
     */
    public List<T> getAll() {
        // TODO: Return an unmodifiable list of items using Collections.unmodifiableList(items).
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Counts the number of items in the repository.
     * @return the count of items
     */
    public int count() {
        // TODO: Return the size of the items list.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Checks if an item is in the repository.
     * @param item the item to check
     * @return true if the repository contains the item
     */
    public boolean contains(T item) {
        // TODO: Return true if the items list contains the item.
        throw new UnsupportedOperationException("Method not implemented");
    }
}