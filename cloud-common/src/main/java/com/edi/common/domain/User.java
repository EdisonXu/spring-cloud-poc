package com.edi.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Edison Xu on 2016/12/26.
 */
public class User extends Entity implements Serializable{

    private Long id;
    private String name;
    private String password;
    private Integer age;
    private Integer roleId;

    public User(){}

    public User(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!getId().equals(user.getId())) return false;
        if (!getName().equals(user.getName())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (getAge() != null ? !getAge().equals(user.getAge()) : user.getAge() != null) return false;
        return getRoleId() != null ? getRoleId().equals(user.getRoleId()) : user.getRoleId() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        result = 31 * result + (getRoleId() != null ? getRoleId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", roleId=" + roleId +
                '}';
    }
}
