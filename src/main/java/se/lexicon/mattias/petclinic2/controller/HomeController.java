package se.lexicon.mattias.petclinic2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public ResponseEntity<String> Hello () {
        return ResponseEntity.ok("Hello inside Pet Clinic");
    }

    @GetMapping("nextMessage")
    public ResponseEntity<String>next() {
        return ResponseEntity.ok("You took the blue pill, welcome to the MATRIX");
    }

}
