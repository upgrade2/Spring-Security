package com.coding.shuttel.learn.service;

import com.coding.shuttel.learn.dto.ApiResponse;
import com.coding.shuttel.learn.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;

public interface CommonApiService {
    public ResponseEntity<ApiResponse> getListOfAllEmployee();
    public ResponseEntity<ApiResponse> saveEmployee(EmployeeDTO employeeDTO);
}
