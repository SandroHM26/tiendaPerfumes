package pe.com.tiendaPerfumes.Controller;

import pe.com.tiendaPerfumes.Model.OrdenItem;
import pe.com.tiendaPerfumes.Service.OrdenItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenitems")
public class OrdenItemController {

    @Autowired
    private OrdenItemService ordenItemService;

    @GetMapping
    public List<OrdenItem> listarOrdenItems() {
        return ordenItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenItem> obtenerOrdenItem(@PathVariable Long id) {
        return ordenItemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/orden/{ordenId}")
    public List<OrdenItem> listarPorOrden(@PathVariable Long ordenId) {
        return ordenItemService.findByOrdenId(ordenId);
    }

    @PostMapping
    public OrdenItem crearOrdenItem(@RequestBody OrdenItem ordenItem) {
        return ordenItemService.save(ordenItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenItem> actualizarOrdenItem(@PathVariable Long id, @RequestBody OrdenItem ordenItem) {
        return ordenItemService.findById(id)
                .map(oi -> {
                    ordenItem.setId(id);
                    OrdenItem actualizado = ordenItemService.save(ordenItem);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrdenItem(@PathVariable Long id) {
        if(ordenItemService.findById(id).isPresent()){
            ordenItemService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

