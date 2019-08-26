package com.blog;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.blog.model.Author;
import com.blog.repository.AuthorRepository;
import com.blog.service.AuthorService;


/**
 * Test class to test the Author API using Mockito framework
 * 
 * @author      Madhuraj Singh <madhuraj.gwl@gmail.com>
 * @version     0.1   (current version number of program)
 * @since       0.1   (the version of the package this class was first added to)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorApiTest {

	@Autowired
	private AuthorService authorService;
	
	@MockBean
	private AuthorRepository authorRepository;
	
	//Test Case 1 to test getAuthors which returns all the Authors
	@Test
	public void getAuthorsTest() {
		when(authorRepository.findAll())
		.thenReturn(Stream.of(new Author(111,"Madhuraj","madhuraj.gwl@gmail.com"),new Author(112,"Manoj","manoj.gwl@gmail.com"))
		.collect(Collectors.toList()));
		
		assertEquals(2, authorService.getAuthors().size());
	}
	
	//Test Case 2 to test getAuthor which returns particular Author whose id is passed
	@Test
	public void getAuthorTest() {
		
		Integer id=111;
		
		when(authorRepository.findAll())
		.thenReturn(Stream.of(new Author(111,"Madhuraj","madhuraj.gwl@gmail.com"))
		.collect(Collectors.toList()));
		
		assertEquals(1, authorService.getAuthor(id));
	}

}
