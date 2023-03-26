package com.gl.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.BookRepository;
import com.gl.entity.Book;

@Service
public class BookServiceImpl implements BookService {

//	private SessionFactory sessionFactory;
//
//	// create session
//	private Session session;
//
//	@Autowired
//	BookServiceImpl(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//		try {
//			session = sessionFactory.getCurrentSession();
//		} catch (HibernateException e) {
//			session = sessionFactory.openSession();
//		}
//
//	}

//	@Transactional
//	public List<Book> findAll() {
//		
//		Transaction tx = session.beginTransaction();
//
//		// find all the records from the database table
//		List<Book> books = session.createQuery("from Book").list();
//
//		tx.commit();
//
//		return books;
//	}
	
	private BookRepository bookRepository;

	@Autowired
	public BookServiceImpl(BookRepository thebookRepository) {
		bookRepository = thebookRepository;
	}

	@Override
	public List<Book> findAll() {

		List<Book> theBooks = bookRepository.findAll();
		return theBooks;
	}

	@Override
	public Book findById(int theId) {
		Optional<Book> result = bookRepository.findById(theId);

		Book thebook = null;

		if (result.isPresent()) {
			thebook = result.get();
		} else {
			// we didn't find the book
			throw new RuntimeException("Did not find book id - " + theId);
		}

		return thebook;
	}

	@Override
	public void save(Book thebook) {
		bookRepository.save(thebook);
	}

	@Override
	public void deleteById(int theId) {
		bookRepository.deleteById(theId);
	}

}
