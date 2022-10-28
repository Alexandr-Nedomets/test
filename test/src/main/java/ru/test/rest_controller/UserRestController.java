package ru.test.rest_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.dto.UserDto;
import ru.test.service.UserService;

import static ru.test.mapper.UserMapper.USER_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/users")
public class UserRestController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(USER_MAPPER.toDtos(userService.findAll()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(USER_MAPPER.toDto(userService.findById(id)));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity update(@PathVariable(name = "id") Long id, @RequestBody UserDto dto) {
        return ResponseEntity.ok(USER_MAPPER.toDto(userService.update(id, USER_MAPPER.toEntity(dto))));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserDto dto) {
        return ResponseEntity.ok(USER_MAPPER.toDto(userService.save(USER_MAPPER.toEntity(dto))));
    }


}
