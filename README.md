# Library Management System

This project is a simple **Library Management System** implemented in Java. It allows for managing a collection of books (referred to as "publications" in the code) and provides basic operations such as adding books, checking availability, issuing and returning books, and printing a list of available books.

## Project Structure

### Classes

1. **Book**
   - Represents a book/publication in the library with the following attributes:
     - ISBN Code (`isbnCode`)
     - Title (`bookTitle`)
     - Author (`writer`)
     - Publication Year (`releaseYear`)
     - Availability Status (`availableStatus`)
   - Provides getter and setter methods for all attributes.
   - Includes a `toString()` method to display book details.

2. **Library**
   - Represents the library which manages a collection of `Book` objects.
   - Provides methods to:
     - Add a book to the library.
     - Check if a book is available based on its ISBN.
     - Issue a book (mark it as unavailable).
     - Return a book (mark it as available).
     - Print all available books in the library.

### Test Class

3. **LibraryTest**
   - A set of unit tests using **JUnit 5** to verify the functionality of the `Library` class.
   - Tests include:
     - Adding books to the library.
     - Checking if books are available.
     - Issuing a book and handling errors for already issued or non-existent books.
     - Returning a book and handling errors for non-issued or non-existent books.
     - Printing a list of available books.

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/library-management-system.git



2. **Navigate to the project directory**:
cd library-management-system

3. Compile the code (if using the command line):
   javac -cp .:junit-platform-console-standalone-1.7.0.jar Library.java Book.java LibraryTest.java

4. Run the tests using JUnit 5:
   java -jar junit-platform-console-standalone-1.7.0.jar -cp . --scan-classpath


**Requirements**
1.Java 8 or later
2.JUnit 5 for running the test cases
