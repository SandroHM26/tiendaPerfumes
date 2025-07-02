package pe.com.tiendaPerfumes.Service;

import org.springframework.stereotype.Service;
import pe.com.tiendaPerfumes.Model.CarritoItem;
import pe.com.tiendaPerfumes.Repository.CarritoItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoItemService {

    private final CarritoItemRepository carritoItemRepository;

    public CarritoItemService(CarritoItemRepository carritoItemRepository) {
        this.carritoItemRepository = carritoItemRepository;
    }

    public List<CarritoItem> findAll() {
        return carritoItemRepository.findAll();
    }

    public Optional<CarritoItem> findById(Long id) {
        return carritoItemRepository.findById(id);
    }

    public List<CarritoItem> findByCarritoId(Long carritoId) {
        return carritoItemRepository.findByCarritoId(carritoId);
    }

    public CarritoItem save(CarritoItem carritoItem) {
        return carritoItemRepository.save(carritoItem);
    }

    public void deleteById(Long id) {
        carritoItemRepository.deleteById(id);
    }
}
