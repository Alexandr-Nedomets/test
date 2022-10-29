package ru.test.rest_controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.TreeMap;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(BindException.class)
    public ResponseEntity handleBindException(BindException be) {
        Map<String, String> map = new TreeMap<>();
        for (ObjectError error : be.getBindingResult().getAllErrors()) {
            map.put(error.getCodes()[0].substring(error.getCodes()[0].lastIndexOf(".") + 1), error.getDefaultMessage());
        }
        log.info("Ошибка данных {}", be.toString());
        return ResponseEntity.ok(map);
    }

}
