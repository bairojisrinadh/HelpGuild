package com.idle.worknine.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idle.worknine.entity.Blog;
import com.idle.worknine.entity.Item;
import com.idle.worknine.entity.Role;
import com.idle.worknine.entity.User;
import com.idle.worknine.repository.BlogRepository;
import com.idle.worknine.repository.ItemRepository;
import com.idle.worknine.repository.RoleRepository;
import com.idle.worknine.repository.UserRepository;

@Transactional
@Service
public class InitDbService {
	
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init(){
		if(logger.isDebugEnabled()){
			logger.debug("In InitDbService Class, init() Method");
		}
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogdetails = new Blog();
		blogdetails.setName("HelpGuild");
		blogdetails.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogdetails.setUser(userAdmin);
		blogRepository.save(blogdetails);
		
		
		Item item1 = new Item();
		item1.setBlog(blogdetails);
		item1.setTitle("First");
		item1.setLink("http://www.javavids.com");
		item1.setPulishDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogdetails);
		item2.setTitle("Second");
		item2.setLink("http://www.javavids.com");
		item2.setPulishDate(new Date());
		itemRepository.save(item2);
		
	}
	
	
}
