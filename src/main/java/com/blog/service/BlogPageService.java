/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.service;

import com.blog.entity.Comments;
import com.blog.entity.Post;
import com.blog.repository.CommentsRepo;
import com.blog.repository.PostRepo;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dani
 */
@Service
public class BlogPageService {

    @Autowired
    PostRepo postRepo;
    
    @Autowired
    CommentsRepo commentsRepo;

    public List<Comments> findAllCommentsByPostId(int id){
        List<Comments> comments = commentsRepo.findAllByPostId(id);
        return comments;
    }
    
    public void saveComment(Comments comments, Post post){
        comments.setPosted(new Date());
        comments.setPost(post);
        commentsRepo.save(comments);
    }
}
