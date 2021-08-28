package com.ironhack.controllerdemo.controller.impl;

import com.ironhack.controllerdemo.controller.interfaces.IHelloWorldController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HelloWorldController implements IHelloWorldController {

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld(@RequestParam(name = "name") Optional<String> name) { // RequestParam puede tener Default Value!
        return name.isPresent() ? "Hello " + name.get() : "Hello World :D";
    }
}
