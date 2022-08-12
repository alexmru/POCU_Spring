package com.pocu.telecomm.service;

import com.pocu.telecomm.entity.Plan;
import com.pocu.telecomm.entity.User;
import com.pocu.telecomm.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getUsers()
    {
        return userRepository.findAll();
    }


    public void postUser(final User user) {
            userRepository.save(user);
    }

    public List<User> findAll(){
       return userRepository.findAll();
    }

    public User getUser(Long id) {
            Optional<User> user = userRepository.findById(id);
            if(user.isPresent()) {
                return user.get();
            } else {
                throw new RuntimeException("Could not find user");
            }
    }

    public void putUser(final Long id, User user) {
        Optional<User> oldUser = userRepository.findById(id);
        user.setId(id);

        oldUser.ifPresent(lot -> userRepository.delete(lot));

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
