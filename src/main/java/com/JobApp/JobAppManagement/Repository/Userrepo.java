package com.JobApp.JobAppManagement.Repository;


import com.JobApp.JobAppManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepo extends JpaRepository<User,Integer> {

    User findByUsername(String username);
}
