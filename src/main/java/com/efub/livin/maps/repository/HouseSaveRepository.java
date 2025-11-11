package com.efub.livin.maps.repository;

import com.efub.livin.maps.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseSaveRepository extends JpaRepository<House, Long> {
}
