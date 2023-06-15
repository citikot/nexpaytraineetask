package com.nexpay.traineetask.service;

import com.nexpay.traineetask.model.User;
import com.nexpay.traineetask.repository.UserRepository;
import com.nexpay.traineetask.util.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final String ExceptionText = "User not found for id: ";
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateById(Integer id, User user) {
        return userRepository.findById(id)
                .map(entity -> {
                    entity.setName(user.getName());
                    entity.setSurname(user.getSurname());
                    entity.setDeleted(user.getDeleted());
                    return userRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException(ExceptionText + id));
    }

    @Override
    public User getById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionText + id));
        if (user.getDeleted()) {
            throw new EntityNotFoundException(ExceptionText + id);
        }
        return user;
    }

    @Override
    public void deleteById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionText + id));
        user.setDeleted(true);
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
