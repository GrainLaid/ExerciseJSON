package net.test.repositories;

import net.test.entity.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface VendorRepositories extends JpaRepository<VendorEntity, Long> {
    @Query(value = "SELECT COUNT (DISTINCT (UPPER(VENDOR_NAME))) FROM Vendor", nativeQuery = true)
    Long countDistinctVendorNameBy();
}
