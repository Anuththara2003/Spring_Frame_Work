package Documents.AAD.JavaEE.Test_Project.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("path")
public class PathVariableController {
    @GetMapping("{id}")
    public String HEllO(@PathVariable ("id") String id) {
        return "Hello " + id;
    }

    @GetMapping("{id}/{name}")
    public String HEllO(@PathVariable ("id") String id, @PathVariable ("name") String name) {
        return "Hello " + id + " " + name;
    }

    @GetMapping(path = "test/{id:I[0-9]{3}}")
    public String HEllO2(@PathVariable("id") String id) {
        return "Hello " + id;
    }

    @GetMapping(path = "item/{code}/branch/{city}")
    public String hello(@PathVariable("code") String code, @PathVariable("city") String city) {
        return "AA....PathVariable " + code + " " + city + "tiyoooo....";
    }
}
