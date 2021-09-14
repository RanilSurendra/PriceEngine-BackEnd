package com.x.webapp.Technical.assessment.repository;

import com.x.webapp.Technical.assessment.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Product,Integer> {
}
