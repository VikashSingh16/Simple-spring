package com.example.restful.webservice.restfulwebservices.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restful.webservice.restfulwebservices.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
