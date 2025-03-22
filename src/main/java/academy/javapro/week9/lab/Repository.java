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
    private final List<T> items;
    /**
     * Constructs a new empty repository.
     */
    public Repository() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds an item to the repository.
     * @param item the item to add
     * @return true if the item was added successfully
     * @throws IllegalArgumentException if the item is null
     */
    public boolean add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (!items.contains(item)) {
            return items.add(item);
        }
        return false;
    }

    /**
     * Removes an item from the repository.
     * @param item the item to remove
     * @return true if the item was removed successfully
     */
    public boolean remove(T item) {
        return items.remove(item);
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
        return items.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * Gets all items in the repository.
     * @return an unmodifiable list of all items
     */
    public List<T> getAll() {
        return Collections.unmodifiableList(items);
    }

    /**
     * Counts the number of items in the repository.
     * @return the count of items
     */
    public int count() {
       return items.size();
    }

    /**
     * Checks if an item is in the repository.
     * @param item the item to check
     * @return true if the repository contains the item
     */
    public boolean contains(T item) {
        return items.contains(items);
    }
}