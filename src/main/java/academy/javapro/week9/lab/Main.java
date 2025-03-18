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

