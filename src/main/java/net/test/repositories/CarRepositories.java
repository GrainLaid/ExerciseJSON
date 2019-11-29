package net.test.repositories;

import net.test.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepositories extends JpaRepository<CarEntity, Long> {
}
