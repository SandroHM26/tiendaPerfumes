package pe.com.tiendaPerfumes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.tiendaPerfumes.Model.Perfume;

import java.util.List;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
    List<Perfume> findByMarca(String marca);
    
    // Extra: podrías usar esto si quieres mostrar perfumes con stock disponible
    List<Perfume> findByStockGreaterThan(int stockMinimo);
}