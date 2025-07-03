package Documents.AAD.JavaEE.Test_Project.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("hello")
public class HelloController {
//    public HelloController() {
//        System.out.println("Hello Controller");
//    }

    @GetMapping("index" )
    public String sayHello() {
//        return "Hello Spring";
        return "index";
    }

    @GetMapping("customer")
    public String sayHello2() {
        return "customer";
    }

//    @GetMapping("one")
//    public String test1() {
//        return "Hello Test One Method";
//    }
//
//    @GetMapping("two")
//    public String test2() {
//        return "Hello Test Two Method";

}
