package guru.springframework.spring6webapp.services;

import org.springframework.stereotype.Service;

import guru.springframework.spring6webapp.entities.Book;
import guru.springframework.spring6webapp.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}

}
