package com.example.demo.controller;

import com.example.demo.service.StyleService;
import com.example.demo.model.PostStyleReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/style")
public class StyleController {

    private final StyleService styleService;

    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/input")
    public ResponseEntity<Object> input(PostStyleReq postStyleReq) {
        int result = styleService.insert(postStyleReq);
        return ResponseEntity.ok().body(result);
    }

}
