package com.coding.shuttel.learn.controller.impl;

import com.coding.shuttel.learn.controller.CommonController;
import com.coding.shuttel.learn.dto.ApiResponse;
import com.coding.shuttel.learn.dto.EmployeeDTO;
import com.coding.shuttel.learn.service.CommonApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CommonControllerImpl implements CommonController {

    private final CommonApiService commonApiService;


    /**
     *To get the list of all Employee
     * @return ResponseEntity<ApiResponse>
     */
    @Override
    @GetMapping(path = "/employees")
    public ResponseEntity<ApiResponse> getListOfAllEmployee() {
        return commonApiService.getListOfAllEmployee();
    }

    /**
     *To saveEmployee take @Input EmployeeDTO
     * @return ResponseEntity<ApiResponse>
     */
    @Override
    @PostMapping("/save-employee")
    public ResponseEntity<ApiResponse> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return commonApiService.saveEmployee(employeeDTO);
    }


}
