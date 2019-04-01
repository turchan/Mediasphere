package com.turchanovskyi.mediasphere.repository;

import com.turchanovskyi.mediasphere.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
