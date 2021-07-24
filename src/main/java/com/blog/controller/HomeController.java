/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.controller;

import com.blog.entity.Comments;
import com.blog.entity.Messages;
import com.blog.entity.Post;
import com.blog.entity.Themes;
import com.blog.repository.CommentsRepo;
import com.blog.repository.MessagesRepo;
import com.blog.repository.PostRepo;
import com.blog.repository.ThemesRepo;
import com.blog.service.BlogPageService;
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
public class HomeController {

    @Autowired
    private CommentsRepo commentsRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private BlogPageService blogService;

    @Autowired
    private MessagesRepo messagesRepo;

    @Autowired
    private ThemesRepo themesRepo;

    @RequestMapping("/index")
    public String indexPage(Model model) {
        List<Post> post = postRepo.findAll();
        List<Themes> themes = themesRepo.findAll();

        model.addAttribute("post", post);
        model.addAttribute("themes", themes);
        return "index";
    }

    @RequestMapping("/themes/{name}")
    public String themesPageByName(@PathVariable(value = "name") String name, Model model) {
        List<Post> post = postRepo.findAllByThemesName(name);
        List<Themes> themes = themesRepo.findAll();

        model.addAttribute("themes", themes);
        model.addAttribute("post", post);
        return "searchbytheme";
    }

    @RequestMapping("/")
    public String indexPage2() {
        return "redirect:/index";
    }

    @RequestMapping("/posts/{id}")
    public String singleBlogPost(@PathVariable(value = "id") int id, Post post, Model model) {
        post = postRepo.findById(id);
        List<Themes> themes = themesRepo.findAll();
        List<Comments> commentsList = commentsRepo.findAllByPostId(id);
        
        model.addAttribute("themes", themes);
        model.addAttribute("post", post);
        model.addAttribute("commentsList", commentsList);
        model.addAttribute("commentsize", commentsList.size());
        model.addAttribute("comments", new Comments());
        return "singlepost";
    }

    @PostMapping("/posts/{id}/addcomment")
    public String addCommentHandling(@ModelAttribute Comments comments, @PathVariable(value = "id") int id, Model model, Post post) {
        post = postRepo.findById(id);
        comments.setId(0);
        blogService.saveComment(comments, post);
        return "redirect:/posts/{id}";
    }
//Contant page and a new empty Messages object given to the page

    @RequestMapping("/contact")
    public String contactPage(Model model) {
        model.addAttribute("messages", new Messages());
        return "contact";
    }
//Contact page form handling

    @PostMapping("/contact/sendmessage")
    public String contactPageHangling(@ModelAttribute Messages messages, Model model) {
        messagesRepo.save(messages);
        return "contact";
    }
}
