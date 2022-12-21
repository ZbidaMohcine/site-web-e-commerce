package com.springcourse.springcor.dao;


import com.springcourse.springcor.entity.TestEntity;
import com.springcourse.springcor.repository.TestRepo;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TestDao {

    @Autowired
    private TestRepo testRepo;

    public String getName() {
        return "My name is Abd AbuGhazaleh";
    }

    public List<TestEntity> getUsers() {
        return this.testRepo.findAll();
    }

    public Optional<TestEntity> getUserById(Integer userId) {
        return this.testRepo.findById(userId);
    }


    public String deleteUserById(Integer userId) {
        Optional<TestEntity> user = this.getUserById(userId);
        if (user.isPresent()) {
            this.testRepo.deleteById(user.get().getUser_id());
            return "User Deleted .";
        } else {
            return "User Not Exist !";
        }
    }


    public TestEntity saveUser(TestEntity user) {
        return this.testRepo.save(user);
    }

    public TestEntity updateUser(TestEntity user) {
        Optional<TestEntity> u = this.getUserById(user.getUser_id());
        if (u.isPresent()) {
            return this.testRepo.save(user);
        } else {
            return null;
        }
    }



}
    