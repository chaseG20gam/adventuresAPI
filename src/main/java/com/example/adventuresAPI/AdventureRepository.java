package com.example.adventuresAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdventureRepository extends JpaRepository<Adventure, Long> {
}