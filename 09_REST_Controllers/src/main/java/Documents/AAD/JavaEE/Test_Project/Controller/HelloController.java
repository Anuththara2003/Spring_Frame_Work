package Documents.AAD.JavaEE.Test_Project.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {


    @GetMapping
    public String getMapping() {
        return "GET";
    }

    @PostMapping
    public String postMapping() {
        return "POST";
    }

    @DeleteMapping
    public String deleteMapping() {
        return "DELETE";
    }
}
