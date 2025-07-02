package pe.com.tiendaPerfumes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.tiendaPerfumes.Model.OrdenItem;

import java.util.List;

public interface OrdenItemRepository extends JpaRepository<OrdenItem, Long> {
    List<OrdenItem> findByOrdenId(Long ordenId);
}

