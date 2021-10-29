package com.esprit.services;

import java.util.List;

import com.esprit.models.Category;

public interface IServiceCategroy extends IService<Category> {

	List<Category> findByName(String name);
	
}
