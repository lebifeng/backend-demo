package com.bifengle.demo.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/")
@RestController
public class CommonController {

    @GetMapping("/")
    public String home() {
        return "<div style='height: 200px;line-height: 200px;text-align: center;'>Hello, This is default page!</div>";
    }
}
