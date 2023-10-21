package com.example.deploy1week.domain.coupon.repository;

import com.example.deploy1week.domain.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
