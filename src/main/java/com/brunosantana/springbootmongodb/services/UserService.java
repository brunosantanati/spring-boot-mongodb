package com.brunosantana.springbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunosantana.springbootmongodb.domain.User;
import com.brunosantana.springbootmongodb.dto.UserDTO;
import com.brunosantana.springbootmongodb.repository.UserRepository;
import com.brunosantana.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> optional = repo.findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User userParam) {
		User userUpdated = findById(userParam.getId());
		updateData(userUpdated, userParam);
		return repo.save(userUpdated);
	}
	
	private void updateData(User userToBeUpdated, User userParam) {
		userToBeUpdated.setName(userParam.getName());
		userToBeUpdated.setEmail(userParam.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
