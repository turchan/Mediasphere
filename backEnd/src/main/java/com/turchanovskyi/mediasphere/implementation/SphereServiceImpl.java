package com.turchanovskyi.mediasphere.implementation;

import com.turchanovskyi.mediasphere.model.Sphere;
import com.turchanovskyi.mediasphere.repository.SphereRepository;
import com.turchanovskyi.mediasphere.service.SphereService;
import org.springframework.stereotype.Service;

@Service("sphereService")
public class SphereServiceImpl implements SphereService {

    private final SphereRepository sphereRepository;

    public SphereServiceImpl(SphereRepository sphereRepository) {
        this.sphereRepository = sphereRepository;
    }

    @Override
    public Iterable<Sphere> findAll() {
        return sphereRepository.findAll();
    }

    @Override
    public Sphere findById(Long id) {
        return sphereRepository.findById(id).get();
    }

    @Override
    public Sphere save(Sphere sphere) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        sphereRepository.deleteById(id);
    }
}
