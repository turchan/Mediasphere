package com.turchanovskyi.mediasphere.implementation;

import com.turchanovskyi.mediasphere.exception.ResourceNotFoundException;
import com.turchanovskyi.mediasphere.model.Material;
import com.turchanovskyi.mediasphere.model.Sphere;
import com.turchanovskyi.mediasphere.model.User;
import com.turchanovskyi.mediasphere.repository.MaterialRepository;
import com.turchanovskyi.mediasphere.securityConfig.auth.CurrentUser;
import com.turchanovskyi.mediasphere.securityConfig.auth.UserPrincipal;
import com.turchanovskyi.mediasphere.service.MaterialService;
import com.turchanovskyi.mediasphere.service.SphereService;
import com.turchanovskyi.mediasphere.service.UserService;
import org.springframework.stereotype.Service;

@Service("materialService")
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;
    private final UserService userService;
    private final SphereService sphereService;

    public MaterialServiceImpl(MaterialRepository materialRepository, UserService userService, SphereService sphereService) {
        this.materialRepository = materialRepository;
        this.userService = userService;
        this.sphereService = sphereService;
    }

    @Override
    public Iterable<Material> findAll() {
        return materialRepository.findAll();
    }

    @Override
    public Material findById(Long id) {
        return materialRepository.findById(id).get();
    }

    @Override
    public Material create(Material material, @CurrentUser UserPrincipal userPrincipal, Long sphereId) {

        User user = userService.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        Sphere sphere = sphereService.findById(sphereId);


        material = new Material.Builder(null, user)
                .setTitle(material.getTitle())
                .setLocation(material.getLocation())
                .setDescription(material.getDescription())
                .setDeadline(material.getDeadline())
                .build();

        material.getSphereList().add(sphere);
        user.getMaterialList().add(material);

        return materialRepository.save(material);
    }

    @Override
    public Material update(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public void deleteById(Long id) {
        materialRepository.deleteById(id);
    }
}
