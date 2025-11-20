package com.efub.livin.house.repository;

import com.efub.livin.house.domain.Bookmark;
import com.efub.livin.house.domain.House;
import com.efub.livin.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Optional<Bookmark> findByUserAndHouse(User user, House house);
    Boolean existsByUserAndHouse(User user, House house);
}
