package com.example.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;

@Controller
public class PostController {
	
	public static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	private PostService postService;
	
	/*
	 * Create a new post
	 */
	@RequestMapping(value = "/posts", method = RequestMethod.POST)
	public String createPost(Model model, @Valid @ModelAttribute("postDto") Post post) {
		logger.info("Creating post >> " + post);
		this.postService.createPost(post);
		return "redirect:/posts";
	}
	
	/*
	 * Delete a post
	 */
	@RequestMapping(value = "/posts/{postId}", method = RequestMethod.DELETE)
	public String deletePost(@PathVariable("postId") Long postId) {
		logger.info("Deleting post id:" + postId);
		this.postService.deletePost(postId);
		return "redirect:/posts";
	}
	
	/*
	 * Update a post
	 */
	@RequestMapping(value = "/posts", method = RequestMethod.PUT)
	public String updatePost(@Valid @ModelAttribute("postDto") Post post) {
		logger.info("Updating post >> " + post);
		this.postService.updatePost(post);
		return "redirect:/posts";
	}
	
	/*
	 * List all posts
	 */
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String listAllPosts(Model model) {
		logger.info("Litsing all posts...");
		Map<String, Object> attributes = this.postService.findAllPosts();
		model.addAllAttributes(attributes);
		return "post-index";
	}
	
	/*
	 * Display post details
	 */
	@RequestMapping(value = "/posts/{postId}", method = RequestMethod.GET)
	public String displayPostDetails(Model model, @PathVariable("postId") Long postId) {
		logger.info("Displaying post details >> postId: " + postId);
		Map<String, Object> attributes = this.postService.findPost(postId);
		model.addAllAttributes(attributes);
		return "post-details";
	}
	
}