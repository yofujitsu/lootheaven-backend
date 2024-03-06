package com.example.lootheaven.controllers;

import com.example.lootheaven.dao.models.AdUnit;
import com.example.lootheaven.service.AdUnitService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lots")
public class AdUnitController {

    private AdUnitService adUnitService;

    @PostMapping("/create")
    public ResponseEntity<AdUnit> createNewAdUnit(AdUnit adUnit) {
        AdUnit adUnitToCreate = adUnitService.createAdUnit(adUnit);
        return new ResponseEntity<>(adUnit, HttpStatus.CREATED);
    }

    @GetMapping("/{game}")
    public ResponseEntity<List<AdUnit>> showAllLotsByGame(@PathVariable String game) {
        List<AdUnit> adUnits = adUnitService.getAllAdUnitsByGame(game);
        return new ResponseEntity<>(adUnits, HttpStatus.OK);
    }
}
