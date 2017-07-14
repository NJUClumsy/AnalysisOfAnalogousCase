package org.Clumsy.entity;

import javax.persistence.*;

/**
 * Created by slow_time on 2017/7/14.
 */
@Entity
@Table(name = "user_info", schema = "ClumsyTest")
public class UserInfoPO {
    private int id;
    private String userName;
    private String password;

    public UserInfoPO(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public UserInfoPO() {
    }

    @Id
    @Column(name = "id", nullable = false)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userName", nullable = false, length = 16)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 16)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoPO that = (UserInfoPO) o;

        if (id != that.id) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
