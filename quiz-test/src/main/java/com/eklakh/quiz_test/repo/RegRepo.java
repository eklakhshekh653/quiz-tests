package com.eklakh.quiz_test.repo;

import com.eklakh.quiz_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegRepo extends JpaRepository<User, Long> {
}
