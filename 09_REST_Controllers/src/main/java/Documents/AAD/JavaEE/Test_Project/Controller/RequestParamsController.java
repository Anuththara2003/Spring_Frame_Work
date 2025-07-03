package Documents.AAD.JavaEE.Test_Project.Controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("params")
@RestController
public class RequestParamsController {
    @GetMapping(params = "name")
    public String hello9(@RequestParam ("name") String name) {
        return "Hello9 " + name;

    }

    @GetMapping(params = {"name","age"})
    public String hello10(@RequestParam ("name") String name ,  @RequestParam ("age") int age) {
        return "Hello10 " + name + " age is " + age;
    }

    @GetMapping(path = {"{code}"}, params = {"name","age"})
    public String hello11(@RequestParam ("name") String name ,  @RequestParam ("age") int age, @PathVariable("code") String code) {
        return "Hello11 " + name + " age is " + age + " code is " + code;
    }
}
