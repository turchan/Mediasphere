package com.turchanovskyi.mediasphere.service;

import com.turchanovskyi.mediasphere.model.Material;
import com.turchanovskyi.mediasphere.securityConfig.auth.CurrentUser;
import com.turchanovskyi.mediasphere.securityConfig.auth.UserPrincipal;

public interface MaterialService {

    Iterable<Material> findAll();
    Material findById(Long id);
    Material create(Material material, @CurrentUser UserPrincipal userPrincipal, Long materialId);
    Material update(Material material);
    void deleteById(Long id);
}
