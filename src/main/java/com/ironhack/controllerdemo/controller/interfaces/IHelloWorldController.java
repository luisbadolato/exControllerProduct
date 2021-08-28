package com.ironhack.controllerdemo.controller.interfaces;

import java.util.Optional;

public interface IHelloWorldController {
    String helloWorld(Optional<String> name);
}
