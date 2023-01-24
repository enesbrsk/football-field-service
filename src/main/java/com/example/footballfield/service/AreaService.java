package com.example.footballfield.service;

import com.example.footballfield.entity.Area;
import com.example.footballfield.model.AreaRequest;
import com.example.footballfield.model.AreaResponse;
import com.example.footballfield.repository.AreaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaService {

    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean saveArea(AreaRequest areaRequest)
    {
        areaRepository.save(AreaRequest.convertToArea(areaRequest));
        return true;
    }

    public List<AreaResponse> getAllArea() {
        return areaRepository.findAll()
                .stream()
                .map(AreaResponse::convertToAreaResponse)
                .collect(Collectors.toList());

    }

}
