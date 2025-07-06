package pe.com.tiendaPerfumes.Controller;

import pe.com.tiendaPerfumes.Model.Decant;
import pe.com.tiendaPerfumes.Service.DecantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/decants")
public class DecantController {

    private final DecantService decantService;

    public DecantController(DecantService decantService) {
        this.decantService = decantService;
    }

    @GetMapping
    public List<Decant> listar() {
        return decantService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Decant> obtener(@PathVariable Long id) {
        return decantService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Decant crear(@RequestBody Decant decant) {
        return decantService.save(decant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Decant> actualizar(@PathVariable Long id, @RequestBody Decant decant) {
        return decantService.findById(id)
                .map(d -> {
                    decant.setId(id);
                    return ResponseEntity.ok(decantService.save(decant));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (decantService.findById(id).isPresent()) {
            decantService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

