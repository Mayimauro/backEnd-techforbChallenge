package com.mati.techforbchallenge.Clima;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permite el acceso desde Angular
@RequestMapping("/api/v1/")
public class ClimaController {

    @PostMapping(value = "demo")
    public String welcome()
    {
        return "Welcome from secure endpoint";
    }

}
