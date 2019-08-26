package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.Author;

/**
 * @author      Madhuraj Singh <madhuraj.gwl@gmail.com>
 * @version     0.1   (current version number of program)
 * @since       0.1   (the version of the package this class was first added to)
 * 
 * @Description This interface is to implement JpaRepository functionalities for Author operations
 */
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	
	/*
	 * @Modifying
	 * 
	 * @Query("update Author auth set auth.name = ?1, auth.email = ?2 where auth.id = ?3"
	 * ) void updateAuthorById(String name, String email, Integer auther_id);
	 */

}
