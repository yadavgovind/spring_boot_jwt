package com.blog.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.Comment;
import com.blog.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * @comment      Madhuraj Singh <madhuraj.gwl@gmail.com>
 * @version     0.1   (current version number of program)
 * @since       0.1   (the version of the package this class was first added to)
 */
@RestController
@RequestMapping("/api/comment")
@Api(value="/comment",description="Comments on topic and post",produces ="application/json")
public class CommentController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	private CommentService commentService;
	
	/**
	 * This method is to create Comment.                           
	 *
	 * @param  Comment comment -Object of Comment Class with all values          
	 * @return ResponseEntity<Comment> -Having status of operation and data created is returned in response.
	 */
	 @PostMapping
	 @ApiOperation("Returns list of all Comments in the system.")
	    public ResponseEntity<Comment> saveComment(@RequestBody Comment commenter){		 
		 Comment comment=commentService.save(commenter);
		 logger.debug("Added:: " + comment);
		 return new ResponseEntity<Comment>(comment, HttpStatus.CREATED);
	    }
	 
 	/**
	 * This method is to get particular Comment.                           
	 *
	 * @param  Integer id 			      Pass id of Comment to fetch it          
	 * @return ResponseEntity<Comment>     Having status of operation and data created is returned in response.
	 */
	 @ApiOperation(value="get Comment",response=Comment.class)
	    @ApiResponses(value={
	    @ApiResponse(code=200,message="Comment Details Retrieved",response=Comment.class),
	    @ApiResponse(code=500,message="Internal Server Error"),
	    @ApiResponse(code=404,message="Comment not found")
	})
	 @GetMapping(value = "/{id}")
		public ResponseEntity<Comment> getCommentById(@PathVariable("id") Integer id) {
		Comment comment = commentService.getComment(id);
			if (comment == null) {
				logger.debug("Comment with id " + id + " does not exists");
				return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Comment>(comment, HttpStatus.OK);
		}
	 	 
	 /**
	 * This method is to get all the Comments.                           
	 *
	 * @param  No Param        
	 * @return ResponseEntity<Comment>   Having status of operation and data created is returned in response.
	 */
	 @GetMapping
	    public ResponseEntity<List<Comment>> getAllComments(){
		 		List<Comment> commentList=	commentService.getComments();
		 		if (commentList.isEmpty()) {
		 			logger.debug("Comment does not exists");
					return new ResponseEntity<List<Comment>>(HttpStatus.NO_CONTENT);
				}
		 		logger.debug("Found " + commentList.size() + " Comments");
				logger.debug(Arrays.toString(commentList.toArray()));
		 return new ResponseEntity<List<Comment>>(commentList, HttpStatus.OK);
	    }
	 
	 /**
	 * This method is to update the Comment.                           
	 *
	 * @param  Comment comment 			Object of Comment Class with all values          
	 * @return ResponseEntity<Comment>   Having status of operation and with no data is returned in response.
	 */
	 @PutMapping
		public ResponseEntity<Void> updateComment(@RequestBody Comment comment) {
			Comment existingAuth = commentService.getComment(comment.getComment_id());
			if (existingAuth == null) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			} else {
				commentService.save(comment);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		}
	 
 	/**
	 * This method is to delete particular Comment.                           
	 *
	 * @param  Integer id 			       Pass id of Comment to delete it          
	 * @return ResponseEntity<Comment>     Having status of operation and with no is returned in response.
	 */
	 @DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> deleteComment(@PathVariable("id") Integer id) {
			Comment comment = commentService.getComment(id);

			if (comment == null) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			} else {
				commentService.deleteComment(id);
				return new ResponseEntity<Void>(HttpStatus.GONE);
			}

		}

}