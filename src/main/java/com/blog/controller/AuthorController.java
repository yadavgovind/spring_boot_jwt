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

import com.blog.model.Author;
import com.blog.service.AuthorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * @author      Madhuraj Singh <madhuraj.gwl@gmail.com>
 * @version     0.1   (current version number of program)
 * @since       0.1   (the version of the package this class was first added to)
 */
@RestController
@RequestMapping("/api/author")
@Api(value="/api/author",description="Author Profile",produces ="application/json")
public class AuthorController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	private AuthorService authService;
	
	/**
	 * This method is to create Author.                           
	 *
	 * @param  Author author -Object of Author Class with all values          
	 * @return ResponseEntity<Author> -Having status of operation and data created is returned in response.
	 */
	 @PostMapping
	 @ApiOperation("Returns list of all Authors in the system.")
	    public ResponseEntity<Author> saveAuthor(@RequestBody Author auther){		 
		 Author auth=authService.save(auther);
		 logger.debug("Added:: " + auth);
		 return new ResponseEntity<Author>(auth, HttpStatus.CREATED);
	    }
	 
 	/**
	 * This method is to get particular Author.                           
	 *
	 * @param  Integer id 			      Pass id of Author to fetch it          
	 * @return ResponseEntity<Author>     Having status of operation and data created is returned in response.
	 */
	 @ApiOperation(value="get Author",response=Author.class)
	    @ApiResponses(value={
	    @ApiResponse(code=200,message="Author Details Retrieved",response=Author.class),
	    @ApiResponse(code=500,message="Internal Server Error"),
	    @ApiResponse(code=404,message="Author not found")
	})
	 @GetMapping(value = "/{id}")
		public ResponseEntity<Author> getAuthorById(@PathVariable("id") Integer id) {
		Author auth = authService.getAuthor(id);
			if (auth == null) {
				logger.debug("Author with id " + id + " does not exists");
				return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Author>(auth, HttpStatus.OK);
		}
	 	 
	 /**
	 * This method is to get all the Authors.                           
	 *
	 * @param  No Param        
	 * @return ResponseEntity<Author>   Having status of operation and data created is returned in response.
	 */
	 @GetMapping
	    public ResponseEntity<List<Author>> getAllAuthors(){
		 		List<Author> authorList=	authService.getAuthors();
		 		if (authorList.isEmpty()) {
		 			logger.debug("Author does not exists");
					return new ResponseEntity<List<Author>>(HttpStatus.NO_CONTENT);
				}
		 		logger.debug("Found " + authorList.size() + " Authors");
				logger.debug(Arrays.toString(authorList.toArray()));
		 return new ResponseEntity<List<Author>>(authorList, HttpStatus.OK);
	    }
	 
	 /**
	 * This method is to update the Author.                           
	 *
	 * @param  Author author 			Object of Author Class with all values          
	 * @return ResponseEntity<Author>   Having status of operation and with no data is returned in response.
	 */
	 @PutMapping
		public ResponseEntity<Void> updateAuthor(@RequestBody Author author) {
			Author existingAuth = authService.getAuthor(author.getAuthor_id());
			if (existingAuth == null) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			} else {
				authService.save(author);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		}
	 
 	/**
	 * This method is to delete particular Author.                           
	 *
	 * @param  Integer id 			      Pass id of Author to delete it          
	 * @return ResponseEntity<Author>     Having status of operation and with no is returned in response.
	 */
	 @DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> deleteAuthor(@PathVariable("id") Integer id) {
			Author auth = authService.getAuthor(id);

			if (auth == null) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			} else {
				authService.deleteAuthor(id);
				return new ResponseEntity<Void>(HttpStatus.GONE);
			}

		}

}
