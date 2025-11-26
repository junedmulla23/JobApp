package com.JobApp.JobAppManagement.Repository;

import com.JobApp.JobAppManagement.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Jobrepo extends JpaRepository<JobPost,Integer> {



    List<JobPost> findByPostProfileContainingOrPostDescContaining(String keyword, String keyword1);
}
