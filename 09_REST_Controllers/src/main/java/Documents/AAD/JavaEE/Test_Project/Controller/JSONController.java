package Documents.AAD.JavaEE.Test_Project.Controller;

import Documents.AAD.JavaEE.Test_Project.DTO.CityDto;
import Documents.AAD.JavaEE.Test_Project.DTO.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("json")
public class JSONController {
    @PostMapping(value = "post",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String postMapping(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        return "Hello " + userDto.toString();
    }

    @GetMapping(value = "get" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getUser() {
        UserDto userDto = new UserDto();
        userDto.setId("S001");
        userDto.setName("Sandaru");
        userDto.setAddress("Colombo");
        userDto.setCityDto(new CityDto("Maradana","13400"));
        System.out.println(userDto);
        return  userDto;
    }
}
