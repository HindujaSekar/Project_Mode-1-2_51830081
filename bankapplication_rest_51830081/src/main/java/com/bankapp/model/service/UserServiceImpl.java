package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.User;
import com.bankapp.model.repo.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	private UserRepository repo;
	@Autowired
	public UserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}

	@Override
	public User findByEmail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void addUser(User user) {
		repo.save(user);
		
	}

	@Override
	public List<User> findAll() {
		return (List<User>)repo.findAll();
	}

	@Override
	public void blockUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

}
