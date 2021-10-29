package com.esprit.services;

import com.esprit.models.Category;
import java.util.List;
import com.esprit.models.Session;

public interface IServiceSession extends IService<Session> {

	List<Session> findByName(String name);
	List<Session> findByCategory(int category_id);

}
