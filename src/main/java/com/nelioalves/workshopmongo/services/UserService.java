package com.nelioalves.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElse(null); 
    }
    
    public User insert(User obj) {
    	return repository.insert(obj);
    }
    
    public void delete(String id) {
        User user = findById(id);
        if (user != null) {
            repository.delete(user);
        }
        
    }
    
    public User update(User obj) {
        Optional<User> newObj = repository.findById(obj.getId());
        if (newObj.isPresent()) {
            updateData(newObj.get(), obj);
            return repository.save(newObj.get());
        } else {
            return null; 
        }
    }

    private void updateData(User newObj, User obj) {
    	newObj.setName(obj.getName());
    	newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
    	return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}