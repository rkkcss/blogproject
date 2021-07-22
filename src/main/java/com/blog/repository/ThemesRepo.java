/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.repository;

import com.blog.entity.Themes;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dani
 */
public interface ThemesRepo extends CrudRepository<Themes, Integer> {
    List<Themes> findAll();
}
