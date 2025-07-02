package pe.com.tiendaPerfumes.Controller;

import pe.com.tiendaPerfumes.Model.Orden;
import pe.com.tiendaPerfumes.Service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<Orden> listarOrdenes() {
        return ordenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> obtenerOrden(@PathVariable Long id) {
        return ordenService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/carrito/{carritoId}")
    public List<Orden> listarOrdenesPorCarrito(@PathVariable Long carritoId) {
        return ordenService.findByCarritoId(carritoId);
    }

    @PostMapping
    public Orden crearOrden(@RequestBody Orden orden) {
        return ordenService.save(orden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orden> actualizarOrden(@PathVariable Long id, @RequestBody Orden orden) {
        return ordenService.findById(id)
                .map(o -> {
                    orden.setId(id);
                    Orden actualizado = ordenService.save(orden);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable Long id) {
        if(ordenService.findById(id).isPresent()){
            ordenService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

