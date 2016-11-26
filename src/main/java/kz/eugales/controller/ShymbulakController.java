/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.eugales.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adil
 */
@RestController
@PropertySource(value = "classpath:info.properties")
public class ShymbulakController {
   
    @Value("${shymbulak.about}")
    String about;
    
    @RequestMapping(value = "/about")
    public String getAbout(){
        return about ;
    }
}
