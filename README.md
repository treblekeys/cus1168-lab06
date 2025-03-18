# Java Generics Lab: Implementing a Type-Safe Collection System

### Learning Objectives

- Apply Java interface implementation techniques
- Work with generic classes provided in a pre-existing codebase
- Create robust model classes with appropriate validation
- Understand how type parameters (`T`, `E`) are used in generic classes

#### Prerequisites

- Basic understanding of Java syntax and OOP concepts
- Familiarity with Java interfaces and implementation
- Understanding of how generics work with collections

#### Task Description

In this lab you will implement three key components of a simple magazine collection system:

1. The `LibraryItem` interface that defines common behavior
2. The `Magazine` class that implements this interface
3. The `Repository<T>` generic class that stores and manages collections of items

The Main class has been provided to test your implementation.

#### Detailed Requirements

- Create an interface named `LibraryItem` with the following methods:
    - `String getTitle()` - Returns the title of the item
    - `String getItemType()` - Returns the type of the item
    - `String getUniqueIdentifier()` - Returns a unique identifier for the item
- Implement a `Magazine` class that implements the `LibraryItem` interface with:
    - Fields:
        - `title` (String)
        - `issueNumber` (int)
        - `publicationDate` (String)
    - Constructor validation:
        - Title cannot be null or empty
        - Issue number must be positive
        - Publication date cannot be null or empty
    - Methods:
        - Getters for all fields
        - `getItemType()` should return "Magazine"
        - `getUniqueIdentifier()` should return title + "-" + issueNumber
        - Proper `toString()`, `equals()`, and `hashCode()` implementations
- Implement a generic `Repository<T>` class that can:
    - Store items in an `ArrayList`
    - Add items (with null validation)
    - Remove items
    - Find items using a Predicate
    - Get all items (as an unmodifiable list)
    - Count items
    - Check if the repository contains an item

#### Technical Requirements

- All fields should be `final` (immutable objects)
- Include proper validation with exception messages
- Follow Java naming conventions and best practices
- Include JavaDoc comments for all classes and methods

#### Project Setup

- Open the project in your IDE
- Locate the starter code at: `academy.javapro.week9.lab`
- Implement the required classes and interface
  ```
  ├── LibraryItem.java (you implement)
  ├── Magazine.java (you implement)
  ├── Repository.java (you implement)
  ├── Main.java (provided)
  ```
- Do not modify the package structure or class name
- Implement the required functionality in the TODOs provided
- Remember to remove TODO comments after completing the implementation


#### Testing Your Implementation

The provided `Main` class demonstrates how your implementation should work:

```java
package academy.javapro.week9.lab;

import java.util.List;

/**
 * Main class to test the library management system implementation.
 */
public class Main {
    public static void main(String[] args) {
        // Create a repository for magazines
        Repository<Magazine> magazineRepository = new Repository<>();

        // Create several magazine instances
        Magazine magazine1 = new Magazine("National Geographic", 243, "June 2023");
        Magazine magazine2 = new Magazine("Time", 156, "April 2023");
        Magazine magazine3 = new Magazine("Wired", 92, "May 2023");

        // Add magazines to the repository
        magazineRepository.add(magazine1);
        magazineRepository.add(magazine2);
        magazineRepository.add(magazine3);

        System.out.println("=== Magazine Repository Demo ===");
        System.out.println("Added magazines to repository. Count: " + magazineRepository.count());

        // Print all magazines
        System.out.println("\nAll magazines:");
        for (Magazine magazine : magazineRepository.getAll()) {
            System.out.println("- " + magazine);
        }

        // Find magazines by title (contains a keyword)
        System.out.println("\nMagazines containing \"Geo\" in the title:");
        List<Magazine> geoMagazines = magazineRepository.find(
                magazine -> magazine.getTitle().contains("Geo"));
        for (Magazine magazine : geoMagazines) {
            System.out.println("- " + magazine);
        }

        // Find magazines published after a certain issue number
        System.out.println("\nMagazines with issue number > 100:");
        List<Magazine> recentMagazines = magazineRepository.find(
                magazine -> magazine.getIssueNumber() > 100);
        for (Magazine magazine : recentMagazines) {
            System.out.println("- " + magazine);
        }

        // Test the equals method by adding a duplicate magazine
        System.out.println("\nAdding duplicate magazine...");
        Magazine duplicateMagazine = new Magazine("National Geographic", 243, "June 2023");
        System.out.println("Is magazine already in repository? " +
                magazineRepository.contains(duplicateMagazine));
        magazineRepository.add(duplicateMagazine);
        System.out.println("Repository count is still: " + magazineRepository.count());

        System.out.println("\nDemonstrating getItemType() and getUniqueIdentifier():");
        for (Magazine magazine : magazineRepository.getAll()) {
            System.out.println("- Item Type: " + magazine.getItemType());
            System.out.println("  Unique ID: " + magazine.getUniqueIdentifier());
            System.out.println("  Title: " + magazine.getTitle());
            System.out.println();
        }

        // We could also demonstrate finding a magazine by its unique identifier
        String searchId = magazine1.getUniqueIdentifier();
        System.out.println("Finding magazine with ID: " + searchId);
        List<Magazine> foundMagazines = magazineRepository.find(
                magazine -> magazine.getUniqueIdentifier().equals(searchId));
        if (!foundMagazines.isEmpty()) {
            System.out.println("Found: " + foundMagazines.get(0));
        }

        // Test exception handling
        try {
            Magazine invalidMagazine = new Magazine("", 1, "January 2023");
            System.out.println("This should not print!");
        } catch (IllegalArgumentException e) {
            System.out.println("\nCaught expected exception: " + e.getMessage());
        }

        try {
            Magazine invalidMagazine = new Magazine("Test", -5, "January 2023");
            System.out.println("This should not print!");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
```

#### Expected Output

When your implementation is run with the provided Main class, it should produce output similar to:

```
=== Magazine Repository Demo ===
Added magazines to repository. Count: 3

All magazines:
- Magazine{title='National Geographic', issueNumber=243, publicationDate='June 2023'}
- Magazine{title='Time', issueNumber=156, publicationDate='April 2023'}
- Magazine{title='Wired', issueNumber=92, publicationDate='May 2023'}

Magazines containing "Geo" in the title:
- Magazine{title='National Geographic', issueNumber=243, publicationDate='June 2023'}

Magazines with issue number > 100:
- Magazine{title='National Geographic', issueNumber=243, publicationDate='June 2023'}
- Magazine{title='Time', issueNumber=156, publicationDate='April 2023'}

Adding duplicate magazine...
Is magazine already in repository? true
Repository count is still: 3

Demonstrating getItemType() and getUniqueIdentifier():
- Item Type: Magazine
  Unique ID: National Geographic-243
  Title: National Geographic

- Item Type: Magazine
  Unique ID: Time-156
  Title: Time

- Item Type: Magazine
  Unique ID: Wired-92
  Title: Wired

Finding magazine with ID: National Geographic-243
Found: Magazine{title='National Geographic', issueNumber=243, publicationDate='June 2023'}

Caught expected exception: Title cannot be null or empty
Caught expected exception: Issue number must be positive
```

## Implementation Tips

### For LibraryItem Interface

- Keep it simple - just define the three required methods
- Add appropriate JavaDoc comments to explain each method's purpose

### For Magazine Class

- Make all fields final to ensure immutability
- Validate all inputs in the constructor before assigning to fields
- Override `equals()` and `hashCode()` based on title and issueNumber
- Format the `toString()` method to clearly show all magazine details

### For Repository<T> Class

- Use a generic type parameter `T` to allow for type-safe collection
- Return unmodifiable collections from `getAll()` to prevent external modification
- Use Java streams and Predicates for the `find()` method
- Consider edge cases in all methods (null items, empty repositories, etc.)

### Tips for Success

- Start with the correct order of implementation: `LibraryItem`, `Magazine`, `Repository`
- Start by understanding how the provided generic classes work.
- Examine the `Main` class to understand what methods your implementations need to handle.
- Test your implementation thoroughly with the provided `Main` class.
