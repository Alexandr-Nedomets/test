package ru.test.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@ApiModel(value = "Пользователь", parent = UserDto.class)
public class UserDto {

    @ApiModelProperty(value = "Индификатор", name = "id", dataType = "Long", example = "25", position = 1)
    private Long id;
    @ApiModelProperty(value = "Имя", name = "firstName", dataType = "String", required = true, example = "Иван", position = 2)
    @NotBlank(message = "{UserDto.firstName.NotBlank}")
    @Size(min = 2, max = 255, message = "{UserDto.firstName.Size}")
    private String firstName;
    @ApiModelProperty(value = "Отчество", name = "middleName", dataType = "String", example = "Иванович", position = 3)
    @NotBlank(message = "{UserDto.firstName.NotBlank}")
    @Size(min = 2, max = 255, message = "{UserDto.firstName.Size}")
    private String middleName;
    @ApiModelProperty(value = "Фамили", name = "lastName", dataType = "String", required = true, example = "Иванов", position = 4)
    @NotBlank(message = "{UserDto.lastName.NotBlank}")
    @Size(min = 2, max = 255, message = "{UserDto.lastName.Size}")
    private String lastName;
    @ApiModelProperty(value = "Телефон", name = "phone", dataType = "String", required = true, example = "71110000000", position = 5)
    @NotBlank(message = "{UserDto.phone.NotBlank}")
    @Pattern(regexp = "^[1-9]\\d{10}$", message = "{UserDto.phone.Pattern}")
    @Size(min = 11, max = 11, message = "{UserDto.phone.Size}")
    private String phone;

}
