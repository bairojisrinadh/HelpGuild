package com.idle.worknine.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.idle.worknine.entity.Blog;
import com.idle.worknine.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findItemByBlog(Blog blog, Pageable pageable);

}
