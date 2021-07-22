/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.repository;

import com.blog.entity.Blogger;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dani
 */
public interface BloggerRepo extends CrudRepository<Blogger, Integer> {
    List<Blogger> findAll();

    public Blogger findByName(String username);
}
