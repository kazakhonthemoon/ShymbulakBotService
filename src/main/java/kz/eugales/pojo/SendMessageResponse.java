/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.eugales.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Id;

/**
 *
 * @author Adil
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@javax.persistence.Entity
public class SendMessageResponse {
    @Id
    private int id;
    private String ok;
    private Message result;

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public Message getResult() {
        return result;
    }

    public void setResult(Message result) {
        this.result = result;
    }
    
    
}
