package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.Comment;
import com.blog.repository.CommentRepository;

/**
 * @comment      Madhuraj Singh <madhuraj.gwl@gmail.com>
 * @version     0.1   (current version number of program)
 * @since       0.1   (the version of the package this class was first added to)
 * 
 * @Description This interface is to implement JpaRepository functionalities for Comment operations
 */
@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepo;
	
	 public Comment save(Comment comment) {
	        return this.commentRepo.save(comment);
	    }
	 
	 public Comment getComment(Integer  id) {
		return commentRepo.findById(id).get();
	 }
	 
	 public List<Comment> getComments() {
		 return this.commentRepo.findAll();
	 }
	 
	 public void updateComment(Comment comment) {
		 this.commentRepo.save(comment);
	 }
	 
	 public void deleteComment(Integer id) {
		 this.commentRepo.deleteById(id);
	 }
}

