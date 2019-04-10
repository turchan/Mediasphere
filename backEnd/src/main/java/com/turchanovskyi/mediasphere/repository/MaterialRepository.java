package com.turchanovskyi.mediasphere.repository;

import com.turchanovskyi.mediasphere.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

}
