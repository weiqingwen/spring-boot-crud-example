package com.example.demo.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.PostDao;
import com.example.demo.model.Post;
import com.example.demo.service.PostService;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService{

	@Autowired
	private PostDao postDao;

	@Override
	public void createPost(Post post) {
		post.setCreationDate(new Timestamp(System.currentTimeMillis()));
		this.postDao.save(post);
	}

	@Override
	public void deletePost(Long postId) {
		this.postDao.delete(postId);
	}

	@Override
	public void updatePost(Post post) {
		this.postDao.update(post);
	}
	
	@Override
	public Map<String, Object> findPost(Long postId) {
		Map<String, Object> attributes = new HashMap<>();
		Post post = this.postDao.find(postId);
		attributes.put("post", post);
		return attributes;
	}
	
	@Override
	public Map<String, Object> findAllPosts() {
		Map<String, Object> attributes = new HashMap<>();
		List<Post> allPosts = this.postDao.findAll();
		// all posts
		attributes.put("posts", allPosts);
		// provide a new data transfer object
		attributes.put("postDto", new Post());
		return attributes;
	}
	
}
