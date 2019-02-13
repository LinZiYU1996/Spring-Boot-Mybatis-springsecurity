package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserAndRole {
    private Integer id;

    private Integer userid;

    private Integer roldid;

    public UserAndRole(Integer userID,Integer roleID){
        this.userid = userID;
        this.roldid = roleID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoldid() {
        return roldid;
    }

    public void setRoldid(Integer roldid) {
        this.roldid = roldid;
    }
}