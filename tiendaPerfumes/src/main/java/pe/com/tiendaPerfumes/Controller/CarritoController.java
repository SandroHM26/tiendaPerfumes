package pe.com.tiendaPerfumes.Controller;

import pe.com.tiendaPerfumes.Model.Carrito;
import pe.com.tiendaPerfumes.Service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carritos")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public List<Carrito> listarCarritos() {
        return carritoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> obtenerCarrito(@PathVariable Long id) {
        return carritoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Carrito> listarCarritosPorCliente(@PathVariable Long clienteId) {
        return carritoService.findByClienteId(clienteId);
    }


    @PostMapping
    public Carrito crearCarrito(@RequestBody Carrito carrito) {
        return carritoService.save(carrito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> actualizarCarrito(@PathVariable Long id, @RequestBody Carrito carrito) {
        return carritoService.findById(id)
                .map(c -> {
                    carrito.setId(id);
                    Carrito actualizado = carritoService.save(carrito);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Long id) {
        if(carritoService.findById(id).isPresent()){
            carritoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
