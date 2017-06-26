package com.idle.worknine.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.idle.worknine.entity.Blog;
import com.idle.worknine.entity.Item;
import com.idle.worknine.entity.User;
import com.idle.worknine.repository.BlogRepository;
import com.idle.worknine.repository.ItemRepository;
import com.idle.worknine.repository.UserRepository;

@Service
public class UserService {
	
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll(){
		if(logger.isInfoEnabled()){
			logger.info("In UserService Class, findAll() Method");
		}
		return userRepository.findAll();
	}

	public User findByUser(int id) {
		if(logger.isInfoEnabled()){
			logger.info("In UserService Class, findByUser() Method");
		}
		User user = null;
		try{
		user = userRepository.findOne(id);
		List<Blog> blogs = blogRepository.findBlogByUser(user);
		if(blogs != null){
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findItemByBlog(blog, new PageRequest(0, 10, Direction.DESC,"publish_date"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		}else{
			throw new Exception();
		}
		}catch(Exception e){
			logger.debug("User's Blog is empty");
		}
		return user;
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		if(logger.isDebugEnabled()){
			logger.debug("In UserService Class, save() Method");
		}
		userRepository.save(user);
		
	}
	
	
	
}
