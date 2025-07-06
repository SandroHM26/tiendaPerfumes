package pe.com.tiendaPerfumes.Controller;

import pe.com.tiendaPerfumes.DTO.DecantDTO;
import pe.com.tiendaPerfumes.DTO.PerfumeDTO;
import pe.com.tiendaPerfumes.Model.Perfume;
import pe.com.tiendaPerfumes.Service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfumes")
public class PerfumeController {

    @Autowired
    private PerfumeService perfumeService;

    @GetMapping
    public List<PerfumeDTO> listarPerfumes() {
        return perfumeService.findAll().stream().map(this::convertToDTO).toList();
    }

    private PerfumeDTO convertToDTO(Perfume perfume) {
        PerfumeDTO dto = new PerfumeDTO();
        dto.setId(perfume.getId());
        dto.setNombre(perfume.getNombre());
        dto.setMarca(perfume.getMarca());   
        dto.setDescripcion(perfume.getDescripcion());
        dto.setPrecio(perfume.getPrecio());
        dto.setStock(perfume.getStock());

        if (perfume.getDecants() != null) {
            dto.setDecants(perfume.getDecants().stream().map(decant -> {
                DecantDTO d = new DecantDTO();
                d.setId(decant.getId());
                d.setVolumenMl(decant.getVolumen_ml());
                d.setPrecio(decant.getPrecio());
                d.setPerfumeId(perfume.getId());
                return d;
        }).toList());
        }

        return dto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfume> obtenerPerfume(@PathVariable Long id) {
        return perfumeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Perfume crearPerfume(@RequestBody Perfume perfume) {
        return perfumeService.save(perfume);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfume> actualizarPerfume(@PathVariable Long id, @RequestBody Perfume perfume) {
        return perfumeService.findById(id)
                .map(p -> {
                    perfume.setId(id);
                    Perfume actualizado = perfumeService.save(perfume);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPerfume(@PathVariable Long id) {
        if(perfumeService.findById(id).isPresent()){
            perfumeService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
