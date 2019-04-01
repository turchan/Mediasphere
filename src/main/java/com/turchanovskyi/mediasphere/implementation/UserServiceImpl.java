package com.turchanovskyi.mediasphere.implementation;

import com.turchanovskyi.mediasphere.model.User;
import com.turchanovskyi.mediasphere.repository.UserRepository;
import com.turchanovskyi.mediasphere.service.UserService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
