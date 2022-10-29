package ru.test.rest_controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.test.dto.UserDto;
import ru.test.service.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.test.mapper.UserMapper.USER_MAPPER;

@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
@Slf4j
@Api(tags = {"user-controller"})
public class UserRestController {

    private final UserService userService;

    @GetMapping
    @ApiOperation(value = "Поиск всех пользователей")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь найден", response = List.class),
    })
    public ResponseEntity findAll() {
        log.info("Поиск всех пользователей");
        return ResponseEntity.ok(USER_MAPPER.toDtos(userService.findAll()));
    }

    @PostMapping
    @ApiOperation(value = "Создание пользователя", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь создан", response = UserDto.class),
            @ApiResponse(code = 500, message = "Ошибка при создании пользователя")
    })
    public ResponseEntity save(@Validated @RequestBody UserDto dto) {
        log.info("Создание пользователя");
        return ResponseEntity.ok(USER_MAPPER.toDto(userService.save(USER_MAPPER.toEntity(dto))));
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Поиск пользователя по индификатору")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь найден", response = UserDto.class),
            @ApiResponse(code = 404, message = "Пользователь не найден")
    })
    public ResponseEntity findById(@PathVariable(name = "id") Long id) {
        log.info("Поиск пользователя с индификатором {}", id);
        return ResponseEntity.ok(USER_MAPPER.toDto(userService.findById(id)));
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Удаление пользователя по индификатору")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь удален", response = String.class),
            @ApiResponse(code = 404, message = "Пользователь не удален")
    })
    public ResponseEntity deleteById(@PathVariable(name = "id") Long id) {
        log.info("Удаление пользователей с индификатором {}", id);
        userService.deleteById(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Обновление пользовател", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь обновлен", response = UserDto.class),
            @ApiResponse(code = 500, message = "Ошибка при обновлении пользователя")
    })
    public ResponseEntity update(@PathVariable(name = "id") Long id, @Validated @RequestBody UserDto dto) {
        log.info("Обновление пользователя {}", dto);
        return ResponseEntity.ok(USER_MAPPER.toDto(userService.update(id, USER_MAPPER.toEntity(dto))));
    }

}
