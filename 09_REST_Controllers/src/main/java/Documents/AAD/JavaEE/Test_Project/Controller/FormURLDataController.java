package Documents.AAD.JavaEE.Test_Project.Controller;

import Documents.AAD.JavaEE.Test_Project.DTO.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("form")
public class FormURLDataController {


    @PostMapping("save")
    public String saveUser(@RequestParam("id") String id, @RequestParam ("name") String name, @RequestParam("address") String address) {{
            return "Hello " + id + " " + name + " " + address;
        }
    }

    @PostMapping("save2")
    public String saveUser2(@RequestParam Map<String,String> user) {
        for (Map.Entry<String, String> entry : user.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return "SaveUser..";
    }


    @PostMapping("save3")
    public String saveUser3( UserDto userDto) {
        System.out.println(userDto);
        return "SaveUser.." + userDto.toString();
    }
}
