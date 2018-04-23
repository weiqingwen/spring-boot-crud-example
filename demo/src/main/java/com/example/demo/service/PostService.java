package com.example.demo.service;

import java.util.Map;

import com.example.demo.model.Post;

public interface PostService {

	void createPost(Post post);
	
	void deletePost(Long postId);
	
	void updatePost(Post post);
	
	Map<String, Object> findPost(Long postId);
	
	Map<String, Object> findAllPosts();
	
}