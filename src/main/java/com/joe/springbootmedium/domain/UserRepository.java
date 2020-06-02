package com.joe.springbootmedium.domain;

import org.hibernate.secure.spi.JaccService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
