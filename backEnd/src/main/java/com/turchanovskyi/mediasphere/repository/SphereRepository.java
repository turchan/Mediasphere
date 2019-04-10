package com.turchanovskyi.mediasphere.repository;

import com.turchanovskyi.mediasphere.model.Sphere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SphereRepository extends JpaRepository<Sphere, Long> {
}
