/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.service;

import com.blog.entity.Blogger;
import com.blog.entity.Post;
import com.blog.repository.BloggerRepo;
import com.blog.repository.PostRepo;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dani
 */
@Service
public class AdminService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    BloggerRepo bloggerRepo;

    public Blogger getLoggedInBlogger() {
        //get current logged in blogger 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Blogger blogger = bloggerRepo.findByName(currentPrincipalName);
        return blogger;
    }
//when blogger created a new blog post, this method set blogger and create new date then save in to the DB
    public void createPostHandling(Post post, Blogger blogger) {
        post.setBlogger(blogger);
        post.setPosted(new Date());
        postRepo.save(post);
    }
}
