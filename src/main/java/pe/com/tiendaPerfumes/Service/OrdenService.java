package pe.com.tiendaPerfumes.Service;

import org.springframework.stereotype.Service;

import pe.com.tiendaPerfumes.DTO.OrdenDTO;
import pe.com.tiendaPerfumes.DTO.OrdenItemDTO;
import pe.com.tiendaPerfumes.Model.Orden;
import pe.com.tiendaPerfumes.Repository.OrdenRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    private final OrdenRepository ordenRepository;

    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }

    public Optional<Orden> findById(Long id) {
        return ordenRepository.findById(id);
    }

    public List<Orden> findByCarritoId(Long carritoId) {
        return ordenRepository.findByCarritoId(carritoId);
    }


    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    public void deleteById(Long id) {
        ordenRepository.deleteById(id);
    }

    public List<OrdenDTO> obtenerOrdenesDTO() {
    List<Orden> ordenes = ordenRepository.findAll();

    return ordenes.stream().map(orden -> {
        OrdenDTO dto = new OrdenDTO();
        dto.setId(orden.getId());
        dto.setFecha(orden.getFecha());
        dto.setTotal(orden.getTotal());
        dto.setEstado(orden.getEstado());

        List<OrdenItemDTO> items = orden.getOrdenItems().stream().map(item -> {
            OrdenItemDTO itemDTO = new OrdenItemDTO();
            itemDTO.setCantidad(item.getCantidad());
            itemDTO.setPrecioUnitario(item.getPrecioUnitario());
            itemDTO.setNombrePerfume(item.getPerfume().getNombre()); // Asumiendo que tienes .getNombre()
            return itemDTO;
        }).toList();

        dto.setOrdenItems(items);
            return dto;
        }).toList();
    }

}

