package kz.eugales;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.annotation.PostConstruct;
import kz.eugales.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:info.properties")
public class MyBean {

    @Value("${shymbulak.about}")
    private  String prop;
    
    @Value("${aa.info}")
    private  String aainfo;
    
    @Value("${aa.start}")
    private  String aastart;
    
    
    //private ResultRepository resultRepository;

    public MyBean() {}
    
    @PostConstruct
    public void init(){
        System.out.println(prop);
    }
    
    public String getProp() {
        return prop;
    }

    public String getAainfo() {
        return aainfo;
    }

    public void setAainfo(String aainfo) {
        this.aainfo = aainfo;
    }

    public String getAastart() {
        return aastart;
    }

    public void setAastart(String aastart) {
        this.aastart = aastart;
    }
    
}
