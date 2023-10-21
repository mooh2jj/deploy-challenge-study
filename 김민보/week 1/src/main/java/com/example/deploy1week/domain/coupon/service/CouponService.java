package com.example.deploy1week.domain.coupon.service;

import com.example.deploy1week.domain.coupon.dto.request.CouponCreateRequestDto;
import com.example.deploy1week.domain.coupon.dto.response.CouponResponse;

public interface CouponService {

    CouponResponse createCoupon(CouponCreateRequestDto request);
}
