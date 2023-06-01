package com.example.revature.blog.repository;

import com.example.revature.blog.DAO.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // Custom query methods can be added here if needed
}
