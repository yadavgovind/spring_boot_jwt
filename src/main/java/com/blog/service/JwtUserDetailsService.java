package com.blog.service;

import com.blog.dto.UserDTO;
import com.blog.model.DAOUser;
import com.blog.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final DAOUser user = this.userRepository.findByUsername(username);
        if (user!=null) {
            return new User(user.getUsername(),user.getPassword(),
                            new ArrayList<>());
            //            return new User("govind","$2a$10$4bWwmQQMlSkExK2P1SMZZe5dmOdcTQK9UUFdRWxVvcSmgerD5NfuW",
            //                            new ArrayList<>());

        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public DAOUser save(final UserDTO user) {
        final DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(this.bcryptEncoder.encode(user.getPassword()));
        return this.userRepository.save(newUser);
    }

}