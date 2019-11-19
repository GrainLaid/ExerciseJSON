package net.test.repositories;

import net.test.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositories extends JpaRepository<PersonEntity, Long> {
}
