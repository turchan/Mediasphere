package com.turchanovskyi.mediasphere.service;

import com.turchanovskyi.mediasphere.model.User;

import java.util.Optional;

public interface UserService {

    Iterable<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    User save(User user);
    void deleteById(Long id);
}
