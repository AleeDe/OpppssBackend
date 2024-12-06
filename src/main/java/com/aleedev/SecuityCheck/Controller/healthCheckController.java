package com.aleedev.SecuityCheck.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthCheckController {

    @GetMapping("/health_check")
    public String healthCheck(HttpServletRequest request){
        return "Okay " + request.getSession().getId();
    }
}
