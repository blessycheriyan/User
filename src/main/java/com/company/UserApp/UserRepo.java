package com.company.UserApp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends  JpaRepository<User, Integer> {

}
