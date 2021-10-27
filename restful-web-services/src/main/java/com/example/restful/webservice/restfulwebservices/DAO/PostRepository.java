package com.example.restful.webservice.restfulwebservices.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restful.webservice.restfulwebservices.bean.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}