package com.example.footballfield.controller;

import com.example.footballfield.model.request.AreaRequest;
import com.example.footballfield.model.response.AreaResponse;
import com.example.footballfield.model.response.ResponseMessage;
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

    @GetMapping( "{id}")
    public ResponseEntity<AreaResponse> getById(@PathVariable String id){
        return ResponseEntity.ok(areaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<AreaResponse> saveArea(@RequestBody AreaRequest areaRequest){
        return ResponseEntity.ok(areaService.saveArea(areaRequest));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseMessage> deleteById(@PathVariable String id){
        return ResponseEntity.ok(areaService.deleteById(id));
    }

}
