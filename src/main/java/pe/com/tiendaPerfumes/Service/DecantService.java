package pe.com.tiendaPerfumes.Service;

import pe.com.tiendaPerfumes.Model.Decant;
import pe.com.tiendaPerfumes.Repository.DecantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DecantService {

    private final DecantRepository decantRepository;

    public DecantService(DecantRepository decantRepository) {
        this.decantRepository = decantRepository;
    }

    public List<Decant> findAll() {
        return decantRepository.findAll();
    }

    public Optional<Decant> findById(Long id) {
        return decantRepository.findById(id);
    }

    public Decant save(Decant decant) {
        return decantRepository.save(decant);
    }

    public void deleteById(Long id) {
        decantRepository.deleteById(id);
    }
}
