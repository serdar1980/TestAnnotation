package ru.serdar1980.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.serdar1980.entity.TestEntity;

import javax.validation.Valid;

@RestController
public class TestController extends BaseController {
    @PostMapping
    public TestEntity createApplication(@Valid @RequestBody TestEntity postEntity) {
        return postEntity;
    }
}
