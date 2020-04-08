package com.turchanovskyi.mediasphere.controller;

import com.turchanovskyi.mediasphere.exception.ResourceNotFoundException;
import com.turchanovskyi.mediasphere.model.Material;
import com.turchanovskyi.mediasphere.model.Sphere;
import com.turchanovskyi.mediasphere.model.User;
import com.turchanovskyi.mediasphere.securityConfig.auth.CurrentUser;
import com.turchanovskyi.mediasphere.securityConfig.auth.UserPrincipal;
import com.turchanovskyi.mediasphere.service.MaterialService;
import com.turchanovskyi.mediasphere.service.SphereService;
import com.turchanovskyi.mediasphere.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/materials")
public class MaterialController {

    private final MaterialService materialService;
    private final UserService userService;
    private final SphereService sphereService;

    public MaterialController(MaterialService materialService, UserService userService, SphereService sphereService) {
        this.materialService = materialService;
        this.userService = userService;
        this.sphereService = sphereService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public Iterable<Material> getAll()
    {
        return materialService.findAll();
    }

    @GetMapping("/{materialId}")
    @PreAuthorize("hasRole('USER')")
    public Material getMaterial(@PathVariable Long materialId)
    {
        return materialService.findById(materialId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/{sphereId}")
    @PreAuthorize("hasRole('USER')")
    public Material create(@RequestBody Material material, @CurrentUser UserPrincipal userPrincipal,
                           @PathVariable Long sphereId)
    {
        User user = userService.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        Sphere sphere = sphereService.findById(sphereId);


        material.setId_material(null);
        material.setId_user(user);
        material.getSphereList().add(sphere);

        user.getMaterialList().add(material);

        materialService.save(material);

        return material;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    @PreAuthorize("hasRole('USER')")
    public Material update(@RequestBody Material material)
    {
        materialService.save(material);

        return material;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{materialId}")
    @PreAuthorize("hasRole('USER')")
    public void delete(@PathVariable Long materialId)
    {
        materialService.deleteById(materialId);
    }
}
