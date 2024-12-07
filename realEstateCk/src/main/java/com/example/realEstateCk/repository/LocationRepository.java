package com.example.realEstateCk.repository;

import com.example.realEstateCk.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    // Bạn có thể thêm các phương thức truy vấn tùy chỉnh nếu cần.
    List<Location> findAllByOrderByNameAsc();
}