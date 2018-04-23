package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Post;

@Mapper
public interface PostDao {
	
	void save(Post post);
	
	void delete(Long postId);
	
	void update(Post post);
	
	Post find(Long postId);
	
	List<Post> findAll();
	
}