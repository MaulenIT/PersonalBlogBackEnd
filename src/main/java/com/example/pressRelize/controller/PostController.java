package com.example.pressRelize.controller;

import com.example.pressRelize.model.Post;
import com.example.pressRelize.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("api/allPost")
    public List<Post> getAllPost() {
        return postService.getPost();
    }

    @GetMapping("api/post/{id}")
    public Post getPostById(@PathVariable("id") Long postId){
        return postService.getById(postId);
    }

    @PostMapping("api/createPost")
    public Post createPost(@RequestBody Post post){
        return postService.insert(post);
    }

    @PutMapping("api/editMessage/{id}")
    public void update(@PathVariable("id") Long id ,@RequestBody Post post){
        postService.updatePost(id , post);
    }

    @DeleteMapping("api/delete/{id}")
    public void deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
    }

    @DeleteMapping("/deletePostAfterMouth/{id}")
    public void deletePostAfterMounth(@PathVariable("id") Long id){
        postService.deletePostAfterMouth(id);
    }
}
