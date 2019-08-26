/**
 *
 */
package com.blog.controller;

import com.blog.dto.UserDTO;
import com.blog.model.DAOUser;
import com.blog.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author govind yadav
 *
 */
@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private JwtUserDetailsService service;

    @GetMapping(value="/",produces = {"text/html"})
    public String welcomeMapping() {
        return "Hi Welcome into blog apis....<a href=\"swagger-ui.html\"> Click here for swagger-ui </a>";
    }

    @PostMapping(value="/register")
    public String saveUser(@RequestBody final UserDTO dto){
        final DAOUser save = this.service.save(dto);
        return "save successfully"+save;
    }
}
