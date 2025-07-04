package pe.com.tiendaPerfumes.Service;

import org.springframework.stereotype.Service;
import pe.com.tiendaPerfumes.Model.Carrito;
import pe.com.tiendaPerfumes.Repository.CarritoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {

    private final CarritoRepository carritoRepository;

    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    public List<Carrito> findAll() {
        return carritoRepository.findAll();
    }

    public Optional<Carrito> findById(Long id) {
        return carritoRepository.findById(id);
    }

    public List<Carrito> findByClienteId(Long clienteId) {
        return carritoRepository.findByClienteId(clienteId);
    }

    public Carrito save(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public void deleteById(Long id) {
        carritoRepository.deleteById(id);
    }

    
}

