package com.example.pressRelize.service.interfaces;

import com.example.pressRelize.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    List<Post> getPost();

    Post getById(Long id);

    Post insert(Post post);

    void deletePost(Long id);

    void updatePost(Long id , Post updatePost);

    void deletePostAfterMouth(Long id);


}
