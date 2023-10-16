package com.example.deploy1week.domain.coupon.dto.request;

import com.example.deploy1week.domain.coupon.entity.Coupon;
import com.example.deploy1week.domain.coupon.entity.CouponStatus;
import com.example.deploy1week.domain.coupon.entity.CouponType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class CouponCreateRequestDto {

    private String name;
    private String code;

    private CouponType type;

    private CouponStatus status;

    // 유효 기간
    private LocalDate startDate;
    private LocalDate endDate;

    public Coupon toEntity() {
        return Coupon.builder()
                .name(name)
                .code(code)
                .type(CouponType.DISCOUNT)
                .status(CouponStatus.PUBLIC)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
