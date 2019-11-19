package net.test.repositories;

import net.test.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepositories extends JpaRepository<CarEntity, Long> {
    List<CarEntity> findByPersonEntityId(Long personId);
}
