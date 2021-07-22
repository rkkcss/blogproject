/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.repository;

import com.blog.entity.Comments;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dani
 */
public interface CommentsRepo extends CrudRepository<Comments, Integer> {
    List<Comments> findAll();
    List<Comments> findAllByPostId(int id);
}
