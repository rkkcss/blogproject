/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.controller;

import com.blog.entity.Blogger;
import com.blog.entity.Messages;
import com.blog.entity.Post;
import com.blog.entity.Themes;
import com.blog.repository.BloggerRepo;
import com.blog.repository.MessagesRepo;
import com.blog.repository.PostRepo;
import com.blog.repository.ThemesRepo;
import com.blog.service.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Dani
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ThemesRepo themesRepo;

    @Autowired
    BloggerRepo bloggerRepo;

    @Autowired
    PostRepo postRepo;

    @Autowired
    AdminService adminService;

    @Autowired
    MessagesRepo messagesRepo;

    @RequestMapping("/admin")
    public String adminPage(Blogger blogger, Model model) {

        model.addAttribute("blogger", blogger);
        return "/admin/admin";
    }

    @RequestMapping("/createblogpost")
    public String page(Model model) {
        List<Themes> postcategories = themesRepo.findAll();
        model.addAttribute("postcategories", postcategories);
        model.addAttribute("post", new Post());
        model.addAttribute("themes", new Themes());
        return "/admin/createblogpost";
    }
//add theme to db handler

    @PostMapping("/createblogpost/addtheme")
    public String addThemeHandler(@ModelAttribute Themes themes, Model model) {
        themesRepo.save(themes);
        return "redirect:/admin/createblogpost";
    }

//Create blog post submit button handling
    @PostMapping("/createposthandling")
    public String createPostHandling(@ModelAttribute Post post, Model model, Blogger blogger) {
        adminService.createPostHandling(post, adminService.getLoggedInBlogger());
        return "redirect:/admin/createblogpost";
    }
//Admin edit blog posts page. This page lists all posts

    @RequestMapping("/editblogpost")
    public String editBlogPost(Model model) {
        List<Post> blogposts = postRepo.findAll();
        model.addAttribute("blogposts", blogposts);
        return "/admin/editblogpost";
    }
//Here can edit the choosen post, then update

    @RequestMapping("/editblogpost/{id}")
    public String editBlog(@PathVariable(value = "id") int id, Model model, Post post) {
        post = postRepo.findById(id);
        List<Themes> postcategories = themesRepo.findAll();
        model.addAttribute("postcategories", postcategories);
        model.addAttribute("post", post);
        return "/admin/editblog";
    }
//delete blogpost by blog id

    @RequestMapping("/deleteblogpost/{id}")
    public String deleteBlogPost(@PathVariable(value = "id") int id, Model model, Post post) {
        postRepo.deleteById(id);
        return "redirect:/admin/admin";
    }

    @RequestMapping("/messages")
    public String messagesPage(Model model) {
        List<Messages> messages = messagesRepo.findAll();
        model.addAttribute("messages", messages);
        return "/admin/messages";
    }

    //check blog posts how it looks after created
    @RequestMapping("/checkblogposts")
    public String checkBlogPosts(Model model) {
        List<Messages> messages = messagesRepo.findAll();
        model.addAttribute("messages", messages);
        return "/admin/checkblogposts";
    }
}
