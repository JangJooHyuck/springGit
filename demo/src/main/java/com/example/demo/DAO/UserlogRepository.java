package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserlogRepository extends JpaRepository<Userlog, Long> {

    Userlog findFirstByOrderByIdDesc();
}
