package com.security.SpringSecurity.Repo;

import com.security.SpringSecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users,Integer> {

    Users findByUsername (String username);
}
