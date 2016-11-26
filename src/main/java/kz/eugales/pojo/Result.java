/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.eugales.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@javax.persistence.Entity
public class Result {
        
    @JsonProperty(value = "update_id")
    @Id
    private String updateId;
    private Message message;

    public Result() {
    }

    public Result(String updateId) {
        this.updateId = updateId;
    }
    
    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    
    
}
