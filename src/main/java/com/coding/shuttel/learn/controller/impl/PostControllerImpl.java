package com.coding.shuttel.learn.controller.impl;

import com.coding.shuttel.learn.controller.PostController;
import com.coding.shuttel.learn.dto.ApiResponse;
import com.coding.shuttel.learn.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostControllerImpl implements PostController {

    private final PostService postService;


    /**
     *To get the list of all Employee
     * @return ResponseEntity<ApiResponse>
     */
    @Override
    @GetMapping(path = "/employees")
    public ResponseEntity<ApiResponse> getListOfAllEmployee() {
        return postService.getListOfAllEmployee();
    }


}
