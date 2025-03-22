package academy.javapro.week9.lab;

/**
 * Interface for library items with common methods for all library items.
 */
public interface LibraryItem {
    /**
     * Gets the title of the library item.
     * @return the title as a String
     */
    String getTitle();

    /**
     * Gets the type of the library item (e.g., "Book", "Magazine").
     * @return the item type as a String
     */
    String getItemType();

    /**
     * Gets a unique identifier for the library item.
     * @return the unique identifier as a String
     */
    String getUniqueIdentifier();
}
