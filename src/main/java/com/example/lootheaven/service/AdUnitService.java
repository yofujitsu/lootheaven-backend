package com.example.lootheaven.service;

import com.example.lootheaven.dao.models.AdUnit;
import com.example.lootheaven.dao.repository.AdUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdUnitService {

    private final AdUnitRepository adUnitRepository;

    public AdUnit createAdUnit(AdUnit adUnit) {
        AdUnit newAdUnit = new AdUnit();
        newAdUnit.setAdUnitType(adUnit.getAdUnitType());
        newAdUnit.setId(adUnit.getId());
        newAdUnit.setDesc(adUnit.getDesc());
        newAdUnit.setPrice(adUnit.getPrice());
        newAdUnit.setPublished(adUnit.getPublished());
        newAdUnit.setUser(adUnit.getUser());
        newAdUnit.setGame(adUnit.getGame());
        newAdUnit.setQuantity(adUnit.getQuantity());
        adUnitRepository.save(newAdUnit);
        return newAdUnit;
    }

    public List<AdUnit> getAllAdUnitsByGame(String game) {
        List<AdUnit> adUnits = adUnitRepository.findAllByGame(game);
        return adUnits;
    }
}
