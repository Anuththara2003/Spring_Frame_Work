package Documents.AAD.JavaEE.Test_Project.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("wild")
@RestController
public class WildCardMappingController {

    @GetMapping("test/*/hello")
    public String WildCardMapping() {
        return "WildCardMapping";

    }

    // wild/test/whefuyrufyh/hweiuydgehdu - working
    // wild/test// - not working
    // wild/test//jasj - not working

    @GetMapping("hello/*/*")
    public String WildCardMapping2() {
        return "WildCardMapping2 works....";
    }

}
