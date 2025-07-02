package pe.com.tiendaPerfumes.Controller;
import pe.com.tiendaPerfumes.Model.CarritoItem;
import pe.com.tiendaPerfumes.Service.CarritoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carritoitems")
public class CarritoItemController {

    @Autowired
    private CarritoItemService carritoItemService;

    @GetMapping
    public List<CarritoItem> listarCarritoItems() {
        return carritoItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarritoItem> obtenerCarritoItem(@PathVariable Long id) {
        return carritoItemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/carrito/{carritoId}")
    public List<CarritoItem> listarItemsPorCarrito(@PathVariable Long carritoId) {
        return carritoItemService.findByCarritoId(carritoId);
    }

    @PostMapping
    public CarritoItem crearCarritoItem(@RequestBody CarritoItem carritoItem) {
        return carritoItemService.save(carritoItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarritoItem> actualizarCarritoItem(@PathVariable Long id, @RequestBody CarritoItem carritoItem) {
        return carritoItemService.findById(id)
                .map(ci -> {
                    carritoItem.setId(id);
                    CarritoItem actualizado = carritoItemService.save(carritoItem);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarritoItem(@PathVariable Long id) {
        if(carritoItemService.findById(id).isPresent()){
            carritoItemService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

