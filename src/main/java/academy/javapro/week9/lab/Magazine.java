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
            throw new IllegalArgumentException("Title cannot be empty or null");
        }
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Issue number must be positive");
        }
        if (publicationDate == null || publicationDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Publication date cannot be null or empty");
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
        return issueNumber;
    }

    /**
     * Gets the publication date of the magazine.
     * @return the publication date
     */
    public String getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getItemType() {
        return "Magazine";
    }

    @Override
    public String getUniqueIdentifier() {
        return title + "-" + issueNumber;
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
        int result = title.hashCode();
        result = 31 * result + issueNumber;
        return result;
    }
}
