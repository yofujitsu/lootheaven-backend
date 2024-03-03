package com.example.lootheaven.dao.models;

import com.example.lootheaven.dao.models.enums.AdUnitType;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class AdUnit {
    private Long id;

    private AdUnitType adUnitType;

    private Long price;

    private Long sellerId;

    private String desc;

    private Long quantity;

}
