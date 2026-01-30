package com.coding.shuttel.learn.service.impl;

import com.coding.shuttel.learn.dto.ApiResponse;
import com.coding.shuttel.learn.dto.EmployeeDTO;
import com.coding.shuttel.learn.exception.RecordAlreadyExistException;
import com.coding.shuttel.learn.repository.EmployeeRepository;
import com.coding.shuttel.learn.repository.entity.EmployeeEntity;
import com.coding.shuttel.learn.service.CommonApiService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CommonApiServiceImpl implements CommonApiService {

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

    @Override
    public ResponseEntity<ApiResponse> saveEmployee(EmployeeDTO employeeDTO) {
        validateEmployee(employeeDTO);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
        EmployeeEntity savedData = employeeRepository.save(employeeEntity);
        ApiResponse apiResponse = new ApiResponse("Data saved successfully",HttpStatus.OK);
        apiResponse.setData(savedData);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    private boolean validateEmployee(EmployeeDTO employeeDTO) {
        boolean isPresent = employeeRepository
                .findByEmail(employeeDTO.getEmail())
                .isPresent();
        if(isPresent) {
            throw new RecordAlreadyExistException("Employee already exists with email "+employeeDTO.getEmail());
        }
        return false;
    }

}
