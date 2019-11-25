package net.test.repositories;

import net.test.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ModelRepositories extends JpaRepository<ModelEntity, Long> {
}
