package com.JobApp.JobAppManagement.Service;


import com.JobApp.JobAppManagement.Model.User;
import com.JobApp.JobAppManagement.Repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class Registerservice {

    @Autowired
    private Userrepo userrepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);

    public User register(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println(user.getPassword());

        return userrepo.save(user);
    }

    public List<User> getalluser() {
        return userrepo.findAll();
    }
}
