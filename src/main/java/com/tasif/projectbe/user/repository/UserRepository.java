package com.tasif.projectbe.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasif.projectbe.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByUserEmail(String userEmail);
	public boolean existsByUserEmail(String userEmail);
}
