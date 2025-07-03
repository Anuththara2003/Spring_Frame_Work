package Documents.AAD.JavaEE.Test_Project.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("char")
@RestController
public class CharacterMappingController {
    @GetMapping("item/I???")
    public String sayBye() {
        return "sayBye";
    }

    @GetMapping("????/search")
    public String sayBye2() {
        return "sayBye2";
    }
}
