package com.turchanovskyi.mediasphere.controller;

import com.turchanovskyi.mediasphere.model.Sphere;
import com.turchanovskyi.mediasphere.service.SphereService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sphere")
public class SphereController {

    private final SphereService sphereService;

    public SphereController(SphereService sphereService) {
        this.sphereService = sphereService;
    }

    @GetMapping
    public Iterable<Sphere> getAll()
    {
        return sphereService.findAll();
    }

    @GetMapping("/{sphereId}")
    public Sphere getMaterial(@PathVariable Long sphereId)
    {
        return sphereService.findById(sphereId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Sphere create(@RequestBody Sphere sphere)
    {
        sphere.setId_sphere(null);

        sphereService.save(sphere);

        return sphere;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Sphere update(@RequestBody Sphere sphere)
    {
        sphereService.save(sphere);

        return sphere;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{sphereId}")
    public void delete(@PathVariable Long sphereId)
    {
        sphereService.deleteById(sphereId);
    }
}
