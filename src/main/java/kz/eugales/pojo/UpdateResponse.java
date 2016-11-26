/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.eugales.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Id;

/**
 *
 * @author Adil
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@javax.persistence.Entity
public class UpdateResponse {
    @Id
    private int id;
    private String ok;
    private List<Result> result;

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
    
   
    
    
}
