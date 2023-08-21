package guru.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring6webapp.entities.Author;
import guru.springframework.spring6webapp.entities.Book;
import guru.springframework.spring6webapp.entities.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Author author1 = new Author();
		author1.setFirstName("James");
		author1.setLastName("Clear");
		
		Book book1 = new Book();
		book1.setTitle("Atomic Habits");
		book1.setIsbn("AH11JC");
		
		Publisher publisher1 = new Publisher();
		publisher1.setPublisherName("Jaico");
		publisher1.setAddress("Mumbai");
		
		Author author1Saved = authorRepository.save(author1);
		Book book1Saved = bookRepository.save(book1);
		Publisher publisher1Saved = publisherRepository.save(publisher1);
		book1Saved.setPublisher(publisher1Saved);
		
		Author author2 = new Author();
		author2.setFirstName("Ryan");
		author2.setLastName("Holiday");
		
		Book book2 = new Book();
		book2.setTitle("Ego is the Enemy");
		book2.setIsbn("EITE22RH");
		
		Publisher publisher2 = new Publisher();
		publisher2.setPublisherName("Penguin");
		publisher2.setAddress("USA");
		
		Author author2Saved = authorRepository.save(author2);
		Book book2Saved = bookRepository.save(book2);
		Publisher publisher2Saved = publisherRepository.save(publisher2);
		book2Saved.setPublisher(publisher2Saved);
		
		author1Saved.getBooks().add(book1Saved);
		author2Saved.getBooks().add(book2Saved);
		book1Saved.getAuthors().add(author1Saved);
		book2Saved.getAuthors().add(author2Saved);
		
		authorRepository.save(author1Saved);
		authorRepository.save(author2Saved);
		bookRepository.save(book1Saved);
		bookRepository.save(book2Saved);
		
		System.out.println("In Bootstrap");
		System.out.println("Author Count: " + authorRepository.count());
		System.out.println("Book Count: " + bookRepository.count());
		System.out.println("Publishers Count: " + publisherRepository.count());
		
	}

	
	
}
