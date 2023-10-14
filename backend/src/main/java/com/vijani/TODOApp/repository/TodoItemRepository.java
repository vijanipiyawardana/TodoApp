package com.vijani.TODOApp.repository;

import com.vijani.TODOApp.entity.TODOItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TODOItemRepository extends JpaRepository<TODOItem, Long> {
}
