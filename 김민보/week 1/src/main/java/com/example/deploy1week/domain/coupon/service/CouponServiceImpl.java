package com.example.deploy1week.domain.coupon.service;

import com.example.deploy1week.domain.coupon.dto.request.CouponCreateRequestDto;
import com.example.deploy1week.domain.coupon.dto.response.CouponResponse;
import com.example.deploy1week.domain.coupon.entity.Coupon;
import com.example.deploy1week.domain.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    @Transactional
    @Override
    public CouponResponse createCoupon(CouponCreateRequestDto request) {

        Coupon saveCoupon = couponRepository.save(request.toEntity());

        return CouponResponse.toDto(saveCoupon);
    }
}
