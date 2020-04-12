package com.turchanovskyi.mediasphere.controller;

import com.turchanovskyi.mediasphere.model.Material;
import com.turchanovskyi.mediasphere.securityConfig.auth.CurrentUser;
import com.turchanovskyi.mediasphere.securityConfig.auth.UserPrincipal;
import com.turchanovskyi.mediasphere.service.MaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/materials")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Iterable<Material> getAll()
    {
        return materialService.findAll();
    }

    @GetMapping("/{materialId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Material getMaterial(@PathVariable Long materialId)
    {
        return materialService.findById(materialId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/{sphereId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Material create(@RequestBody Material material, @CurrentUser UserPrincipal userPrincipal,
                           @PathVariable Long sphereId) {

        materialService.create(material, userPrincipal, sphereId);

        return material;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public Material update(@RequestBody Material material)
    {
        materialService.update(material);

        return material;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{materialId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long materialId)
    {
        materialService.deleteById(materialId);
    }
}
