package ru.test.rest_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.model.User;
import ru.test.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/users")
public class UserRestController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id") Long id){
        userService.deleteById(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity update(@PathVariable(name = "id") Long id, @RequestBody User user){
        return ResponseEntity.ok(userService.update(id, user));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }


}
