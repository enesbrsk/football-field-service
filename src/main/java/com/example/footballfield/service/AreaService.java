package com.example.footballfield.service;

import com.example.footballfield.entity.Area;
import com.example.footballfield.enums.ErrorCode;
import com.example.footballfield.exception.GenericException;
import com.example.footballfield.model.request.AreaRequest;
import com.example.footballfield.model.response.AreaResponse;
import com.example.footballfield.repository.AreaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaService {

    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public AreaResponse saveArea(AreaRequest areaRequest)
    {
        final Area fromDb = areaRepository.save(AreaRequest.convertToArea(areaRequest));
        return AreaResponse.convertToAreaResponse(fromDb);
    }

    public List<AreaResponse> getAllArea() {
        return areaRepository.findAll()
                .stream()
                .map(AreaResponse::convertToAreaResponse)
                .collect(Collectors.toList());

    }

    public AreaResponse getById(String id){
        return  AreaResponse.convertToAreaResponse(areaRepository.findById(id)
                .orElseThrow(() -> new GenericException("Area could not find by id: " + id,ErrorCode.AREA_NOT_FOUND))
        );
    }

}
