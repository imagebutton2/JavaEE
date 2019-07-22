package com.gjz.travel.dao.impl;

import com.gjz.travel.dao.UserDao;
import com.gjz.travel.domain.User;

public class test {
    public static void main(String[] args) {
        User user=new User(1,"11111111","12345678","gjz","2018/7/22","男","13345678111","1046509851@qq.com","0","asdasdadad");
        System.out.println(user);
        UserDao userDao=new UserDaoImpl();
        //userDao.saveUser(user);


    }
}
