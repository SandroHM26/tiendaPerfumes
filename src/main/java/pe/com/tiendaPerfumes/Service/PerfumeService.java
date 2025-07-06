package pe.com.tiendaPerfumes.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tiendaPerfumes.Model.Perfume;
import pe.com.tiendaPerfumes.Repository.PerfumeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PerfumeService {

    private final PerfumeRepository perfumeRepository;

    @Autowired
    public PerfumeService(PerfumeRepository perfumeRepository) {
        this.perfumeRepository = perfumeRepository;
    }

    public List<Perfume> findAll() {
        return perfumeRepository.findAll();
    }

    public Optional<Perfume> findById(Long id) {
        return perfumeRepository.findById(id);
    }

    public Perfume save(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    public void deleteById(Long id) {
        perfumeRepository.deleteById(id);
    }

    // Extra: podrías tener un método para filtrar si deseas
    public List<Perfume> findByMarca(String marca) {
        return perfumeRepository.findByMarca(marca);
    }

    public List<Perfume> findDisponibles() {
        return perfumeRepository.findByStockGreaterThan(0);
    }
}
