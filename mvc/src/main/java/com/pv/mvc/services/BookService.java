package com.pv.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pv.mvc.models.Book;
import com.pv.mvc.repositories.BookRepository;

@Service
public class BookService {
	// inject book repository - book repository instance - will call all methods
	// adding the book repository as a dependency
	private final BookRepository bookRepository;
	
	
	//dependency injection
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // updates a book
    // use the setter methods from the domain model
//    public Book updateBook(id, title, desc, lang, numOfPages) {
//    	Long id = Book.setId(Long);
//    	String title = Book.setTitle(String);
//    	String desc = Book.setDescription(String description);
//    	Book.setLanguage(String language);
//    	Book.setNumberOfPages(String numberOfPages);
//    	return bookRepository.save(b);
//    }
    
    // updates a book
    public Book updateBook(Book b) {
    	Long id = Book.setId(Long);
    	String title = Book.setTitle(String);
    	String desc = Book.setDescription(String);
    	String lang = Book.setLanguage(String);
    	Integer numOfPages = Book.setNumOfPages(Integer);
    	return bookRepository.save(b);
    }
    
    
    
    // deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    
    
}
