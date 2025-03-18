package academy.javapro.week9.lab;

/**
 * Represents a magazine in the library system.
 */
public class Magazine implements LibraryItem {
    private final String title;
    private final int issueNumber;
    private final String publicationDate;

    /**
     * Creates a new magazine with the specified details.
     * @param title the title of the magazine
     * @param issueNumber the issue number
     * @param publicationDate the publication date as a string
     */
    public Magazine(String title, int issueNumber, String publicationDate) {
        if (title == null || title.trim().isEmpty()) {
            // TODO: Throw an IllegalArgumentException with the message "Title cannot be null or empty".
        }
        if (issueNumber <= 0) {
            // TODO: Throw an IllegalArgumentException with the message "Issue number must be positive".
        }
        if (publicationDate == null || publicationDate.trim().isEmpty()) {
            // TODO: Throw an IllegalArgumentException with the message "Publication date cannot be null or empty".
        }

        this.title = title;
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
    }

    /**
     * Gets the issue number of the magazine.
     * @return the issue number
     */
    public int getIssueNumber() {
        // TODO: return the issueNumber field.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Gets the publication date of the magazine.
     * @return the publication date
     */
    public String getPublicationDate() {
        // TODO: return the publicationDate field.
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public String getTitle() {
        // TODO: return the title field.
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public String getItemType() {
        // TODO: return "Magazine".
        throw new UnsupportedOperationException("Method not implemented");
    }

    // TODO: Implement the getUniqueIdentifier method from the LibraryItem interface.
    @Override
    public String getUniqueIdentifier() {
        // TODO: Return the title of the magazine followed by a hyphen and the issue number.
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + title + '\'' +
                ", issueNumber=" + issueNumber +
                ", publicationDate='" + publicationDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Magazine magazine = (Magazine) o;
        return issueNumber == magazine.issueNumber && title.equals(magazine.title);
    }

    @Override
    public int hashCode() {
        // TODO: Create int result variable and assign title.hashCode() to it.

        // TODO: Multiply result by 31 and add issueNumber to it.

        // TODO: Return the result.

        throw new UnsupportedOperationException("Method not implemented");
    }
}
