package org.Clumsy.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

/**
 * Created by slow_time on 2017/7/15.
 */

@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String username;
    private String password;
    private Collection<String> cases;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<String> getCases() {
        return cases;
    }

    public void setCases(Collection<String> cases) {
        this.cases = cases;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}