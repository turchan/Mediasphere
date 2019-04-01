package com.turchanovskyi.mediasphere.implementation;

import com.turchanovskyi.mediasphere.model.Material;
import com.turchanovskyi.mediasphere.repository.MaterialRepository;
import com.turchanovskyi.mediasphere.service.MaterialService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service("materialService")
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
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
    public Material save(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public void deleteById(Long id) {
        materialRepository.deleteById(id);
    }
}
