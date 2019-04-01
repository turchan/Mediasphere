package com.turchanovskyi.mediasphere.controller;

import com.turchanovskyi.mediasphere.model.Material;
import com.turchanovskyi.mediasphere.service.MaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/material")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public Iterable<Material> getAll()
    {
        return materialService.findAll();
    }

    @GetMapping("/{materialId}")
    public Material getMaterial(@PathVariable Long materialId)
    {
        return materialService.findById(materialId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Material create(@RequestBody Material material)
    {
        material.setId_material(null);

        materialService.save(material);

        return material;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Material update(@RequestBody Material material)
    {
        materialService.save(material);

        return material;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{materialId}")
    public void delete(@PathVariable Long materialId)
    {
        materialService.deleteById(materialId);
    }
}
