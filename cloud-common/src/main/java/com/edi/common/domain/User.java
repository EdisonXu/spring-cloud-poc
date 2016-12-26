package com.edi.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Edison Xu on 2016/12/26.
 */
public class User implements Serializable{

    private long id;
    private String name;
    private String password;
    private int age;
    private int roleId;
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (getAge() != user.getAge()) return false;
        if (getRoleId() != user.getRoleId()) return false;
        if (!getName().equals(user.getName())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        return getCreateTime() != null ? getCreateTime().equals(user.getCreateTime()) : user.getCreateTime() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + getRoleId();
        result = 31 * result + (getCreateTime() != null ? getCreateTime().hashCode() : 0);
        return result;
    }
}
