package com.idle.worknine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idle.worknine.entity.Blog;
import com.idle.worknine.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

	List<Blog> findBlogByUser(User user);
}
