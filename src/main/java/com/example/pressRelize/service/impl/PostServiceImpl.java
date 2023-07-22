package com.example.pressRelize.service.impl;

import com.example.pressRelize.expections.PostNotFoundException;
import com.example.pressRelize.model.Post;
import com.example.pressRelize.model.Status;
import com.example.pressRelize.repository.PostRepo;
import com.example.pressRelize.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    private Status status;

    @Override
    public List<Post> getPost() {
//        return postRepo.findByTimerSendMessageIsLessThan(new Timestamp(System.nanoTime()));
        return postRepo.findAll();
    }


    @Override
    public Post getById(Long id) {
        return postRepo.getById(id);
    }

    @Override
    public Post insert(Post post) {
        post.setPostCreatedTime(new Timestamp(new Date().getTime()));
        return postRepo.save(post);
    }

    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }


    @Override
    @Scheduled(cron = "0 0 0 1 * ?")
    public void deletePostAfterMouth(Long id) {
        List<Post> allpost = postRepo.findAll();
        Timestamp currentTime = new Timestamp(new Date().getTime());
        long mouth = 2629743;
        for (Post post : allpost) {
            if ((currentTime.getTime() - post.getPostCreatedTime().getTime()) >= mouth) {
                postRepo.deleteById(id);
            }
        }
    }

    @Override
    public void updatePost(Long id, Post updatedPost) {
        Timestamp currentTime = new Timestamp(new Date().getTime());
        long maxTimeForEditMessage = 36000;// const
        Post post = postRepo.findById(id).orElseThrow(() -> new PostNotFoundException("Post not found by id"));
        if (post != null && (currentTime.getTime() - post.getPostCreatedTime().getTime()) > maxTimeForEditMessage) {
            post.setTitle(updatedPost.getTitle());
            post.setDescription(updatedPost.getDescription());
            postRepo.save(post);
        }
    }
}
