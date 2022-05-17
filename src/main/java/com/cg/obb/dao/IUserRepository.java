package com.cg.obb.dao;

import com.cg.obb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    public User findByEmail(String email);

    public List<User> findAll();






}
