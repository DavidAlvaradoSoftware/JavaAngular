package com.example.revature.blog.controllers;

import com.example.revature.blog.DAO.Post;
import com.example.revature.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {
    private PostService postService;

    @Autowired
    public void setMyService(PostService postService) {
        this.postService = postService;
    }
    @PostMapping(value = "/blog", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addBlogPost(@RequestBody Post post){
        return postService.createPost(post).toString();
    }

    @GetMapping(value = "/blog/all")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping(value = "/blog")
    public String getSinglePost(@RequestParam Long id){
        Optional<Post> result = postService.getPostById(id);

        return result.isPresent() ? result.get().toString() : "no element found";
    }

    @PutMapping(value = "/blog")
    public String updatePost(@RequestBody Post post){
        return postService.updatePost(post).toString();
    }

    @DeleteMapping(value = "/blog")
    public void deletePost(@RequestParam Long id){
        postService.deletePost(id);
    }

}
