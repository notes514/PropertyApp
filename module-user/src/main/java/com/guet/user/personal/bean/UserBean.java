package com.guet.user.personal.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author dhxstart
 * @date 2022/2/14 22:23
 */
public class UserBean implements Serializable {
    private Integer userId;
    private String username;
    private String nickname;
    private List<Integer> roleIds;
    private List<String> menuList;
    private List<String> permissionList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public List<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<String> menuList) {
        this.menuList = menuList;
    }

    public List<String> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<String> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", roleIds=" + roleIds +
                ", menuList=" + menuList +
                ", permissionList=" + permissionList +
                '}';
    }
}
