
package com.example.book_management;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private ArrayList<Book> books = new ArrayList<>();

    @PostMapping
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book added successfully";
    }

    @GetMapping
    public ArrayList<Book> getBooks() {
        return books;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id,
                             @RequestBody Book updatedBook) {
        for (Book b : books) {
            if (b.getId() == id) {
                b.setTitle(updatedBook.getTitle());
                b.setAuthor(updatedBook.getAuthor());
                return "Book updated successfully";
            }
        }
        return "Book not found";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                books.remove(b);
                return "Book deleted successfully";
            }
        }
        return "Book not found";
    }
}
