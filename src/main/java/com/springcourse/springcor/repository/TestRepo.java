package com.springcourse.springcor.repository;

import com.springcourse.springcor.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

// C r u d  Repository Create read update delete
public interface TestRepo extends JpaRepository<TestEntity , Integer > {

}
