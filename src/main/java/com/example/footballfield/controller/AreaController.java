package com.example.footballfield.controller;

import com.example.footballfield.entity.Area;
import com.example.footballfield.model.AreaRequest;
import com.example.footballfield.model.AreaResponse;
import com.example.footballfield.service.AreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/area")
public class AreaController {

    public final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping
    public ResponseEntity<List<AreaResponse>> getAllArea(){
        return ResponseEntity.ok(areaService.getAllArea());
    }

    @PostMapping
    public ResponseEntity<Boolean> saveArea(@RequestBody AreaRequest areaRequest){
        return ResponseEntity.ok(areaService.saveArea(areaRequest));
    }

}
