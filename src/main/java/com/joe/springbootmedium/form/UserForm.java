package com.joe.springbootmedium.form;

import com.joe.springbootmedium.domain.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserForm {

    public static final String PHONE_REG="^([-_－—\\s\\(]?)([\\(]?)((((0?)|((00)?))(((\\s){0,2})|([-_－—\\s]?)))|(([\\)]?)[+]?))(886)?([\\)]?)([-_－—\\s]?)([\\(]?)[0]?[1-9]{1}([-_－—\\s\\)]?)[1-9]{2}[-_－—]?[0-9]{3}[-_－—]?[0-9]{3}$";

    @NotBlank(message = "寢輸入名稱")
    private String username;

    @Length(min = 6 ,max = 24,message = "密碼須為6~24位之間")
    private String password;

    @Pattern(regexp = PHONE_REG,message = "請輸入正確電話號碼")
    private String phone;

    @Email(message = "請輸入正確的電子信箱")
    @NotBlank(message = "請輸入電子信箱")
    private String email;

    @Length(min = 6 ,max = 24,message = "密碼須為6~24位之間")
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
    public boolean confirmPassword(){
        if (this.password.equals(this.confirmPasswordId)){
            return true;
        }
        return false;
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
