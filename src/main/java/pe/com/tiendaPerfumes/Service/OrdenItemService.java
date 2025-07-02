package pe.com.tiendaPerfumes.Service;

import org.springframework.stereotype.Service;
import pe.com.tiendaPerfumes.Model.OrdenItem;
import pe.com.tiendaPerfumes.Repository.OrdenItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenItemService {

    private final OrdenItemRepository ordenItemRepository;

    public OrdenItemService(OrdenItemRepository ordenItemRepository) {
        this.ordenItemRepository = ordenItemRepository;
    }

    public List<OrdenItem> findAll() {
        return ordenItemRepository.findAll();
    }

    public Optional<OrdenItem> findById(Long id) {
        return ordenItemRepository.findById(id);
    }

    public List<OrdenItem> findByOrdenId(Long ordenId) {
        return ordenItemRepository.findByOrdenId(ordenId);
    }

    public OrdenItem save(OrdenItem ordenItem) {
        return ordenItemRepository.save(ordenItem);
    }

    public void deleteById(Long id) {
        ordenItemRepository.deleteById(id);
    }
}
