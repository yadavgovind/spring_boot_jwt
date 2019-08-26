package com.blog.repository;

import com.blog.model.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DAOUser, Integer>{

    DAOUser findByUsername( String username);
}
