package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.Author;
import com.blog.repository.AuthorRepository;

/**
 * @author      Madhuraj Singh <madhuraj.gwl@gmail.com>
 * @version     0.1   (current version number of program)
 * @since       0.1   (the version of the package this class was first added to)
 * 
 * @Description This interface is to implement JpaRepository functionalities for Author operations
 */
@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authRepo;
	
	 public Author save(Author author) {
	        return this.authRepo.save(author);
	    }
	 
	 public Author getAuthor(Integer  id) {
		return authRepo.findById(id).get();
	 }
	 
	 public List<Author> getAuthors() {
		 return this.authRepo.findAll();
	 }
	 
	 public void updateAuthor(Author auth) {
		/*
		 * int id=auth.getAuthor_id(); 
		 * String name=auth.getName();
		 * String email=auth.getEmail();
		 */
		 
		 //this.authRepo.updateAuthorById(name,email,id);
		 this.authRepo.save(auth);
	 }
	 
	 public void deleteAuthor(Integer Auth_id) {
		 this.authRepo.deleteById(Auth_id);
	 }
}
