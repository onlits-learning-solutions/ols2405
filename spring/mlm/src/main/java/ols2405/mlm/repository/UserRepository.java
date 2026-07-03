package ols2405.mlm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ols2405.mlm.model.User;

public interface UserRepository extends JpaRepository<User, String> {
    
}
