package org.example;

import java.util.ArrayList;
import java.util.List;

// Class representing a Library with publications
public class Library {
    private List<Book> publications;

    // Constructor to initialize Library with an empty list of publications
    public Library() {
        publications = new ArrayList<>();
    }

    // Method to add a publication to the library
    public void addBook(Book publication) {
        publications.add(publication);
    }

    public int getPublications() {
        return publications.size();
    }
}

