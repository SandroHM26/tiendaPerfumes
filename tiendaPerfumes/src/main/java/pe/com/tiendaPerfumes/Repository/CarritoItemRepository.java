package pe.com.tiendaPerfumes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.tiendaPerfumes.Model.CarritoItem;

import java.util.List;

public interface CarritoItemRepository extends JpaRepository<CarritoItem, Long> {
    List<CarritoItem> findByCarritoId(Long carritoId);
}