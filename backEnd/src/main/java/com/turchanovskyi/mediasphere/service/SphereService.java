package com.turchanovskyi.mediasphere.service;

        import com.turchanovskyi.mediasphere.model.Sphere;

public interface SphereService {

    Iterable<Sphere> findAll();
    Sphere findById(Long id);
    Sphere save(Sphere sphere);
    void deleteById(Long id);
}
