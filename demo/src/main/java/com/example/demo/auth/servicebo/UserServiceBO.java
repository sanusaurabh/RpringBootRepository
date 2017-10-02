package com.example.demo.auth.servicebo;

import com.example.demo.auth.model.User;

public interface UserServiceBO {
	void save(User user);

    User findByUsername(String username);

}
