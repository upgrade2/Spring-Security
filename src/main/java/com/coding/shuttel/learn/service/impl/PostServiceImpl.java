package com.coding.shuttel.learn.service.impl;

import com.coding.shuttel.learn.dto.ApiResponse;
import com.coding.shuttel.learn.dto.EmployeeDTO;
import com.coding.shuttel.learn.repository.EmployeeRepository;
import com.coding.shuttel.learn.repository.entity.EmployeeEntity;
import com.coding.shuttel.learn.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    /**
     * At service level returning the list of employees.
     * @return ResponseEntity<ApiResponse>
     */
    @Override
    public ResponseEntity<ApiResponse> getListOfAllEmployee() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for(EmployeeEntity list:employeeRepository.findAll()){
            employeeDTOList.add(modelMapper.map(list,EmployeeDTO.class));
        }
        return buildApiResponse(employeeDTOList);
    }
    private ResponseEntity<ApiResponse> buildApiResponse(List<EmployeeDTO> list){
        ApiResponse apiResponse = new ApiResponse("Data fetched successfully",HttpStatus.OK);
        apiResponse.setData(List.of(list));
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }



}
