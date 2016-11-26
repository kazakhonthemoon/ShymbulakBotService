/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.eugales.repository;

import kz.eugales.pojo.Result;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Adil
 */
public interface ResultRepository extends JpaRepository<Result, Integer> {
    
}
