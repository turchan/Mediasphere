package com.turchanovskyi.mediasphere.service;

import com.turchanovskyi.mediasphere.model.User;

public interface UserService {

    Iterable<User> findAll();
    User findById(Long id);
    User save(User user);
    void deleteById(Long id);
}
