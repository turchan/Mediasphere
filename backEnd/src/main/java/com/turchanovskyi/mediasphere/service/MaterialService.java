package com.turchanovskyi.mediasphere.service;

import com.turchanovskyi.mediasphere.model.Material;

public interface MaterialService {

    Iterable<Material> findAll();
    Material findById(Long id);
    Material save(Material material);
    void deleteById(Long id);
}
