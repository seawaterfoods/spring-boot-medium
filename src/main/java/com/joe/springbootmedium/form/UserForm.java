package com.joe.springbootmedium.form;

import com.joe.springbootmedium.domain.User;
import org.springframework.beans.BeanUtils;

public class UserForm {

    private String username;
    private String password;
    private String phone;
    private String email;
    private String confirmPasswordId;

    public UserForm() {
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPasswordId() {
        return confirmPasswordId;
    }

    public void setConfirmPasswordId(String confirmPasswordId) {
        this.confirmPasswordId = confirmPasswordId;
    }

    public User convertToUser(){
        User user=new UserFormConvert().convert(this);
        return user;
    }
    private class UserFormConvert implements FormConver<UserForm,User> {
        @Override
        public User convert(UserForm userForm) {
            User user = new User();
            //copyProperties為A物件與B物件之間將有相同係數名的係數複製過去
            // ，若A物件有但B物件沒有則忽略之。
            BeanUtils.copyProperties(userForm, user);
            return user;
        }
    }
}
