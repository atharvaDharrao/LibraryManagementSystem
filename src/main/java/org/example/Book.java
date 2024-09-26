package org.example;

// Class representing a Book with attributes isbnCode, bookTitle, writer, and releaseYear
public class Book {
    private String isbnCode;
    private String bookTitle;
    private String writer;
    private int releaseYear;
    private boolean availableStatus;

    // Constructor to initialize Book object
    public Book(String isbnCode, String bookTitle, String writer, int releaseYear) {
        this.isbnCode = isbnCode;
        this.bookTitle = bookTitle;
        this.writer = writer;
        this.releaseYear = releaseYear;
        this.availableStatus = true;  // Books are available by default when added
    }

    // Getters and setters for book attributes
    public String getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(boolean availableStatus) {
        this.availableStatus = availableStatus;
    }

    // Method to display book details
    @Override
    public String toString() {
        return "Book [isbnCode=" + isbnCode + ", bookTitle=" + bookTitle + ", writer=" + writer + ", releaseYear=" + releaseYear + "]";
    }
}





