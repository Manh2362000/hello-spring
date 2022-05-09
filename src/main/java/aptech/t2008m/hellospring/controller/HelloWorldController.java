package aptech.t2008m.hellospring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @PostMapping(path ="/student")
    public String postData(){
        return "Hello Post";
    }

    @GetMapping(path = "/hello")
    public String sayHello(){return "Hello World";}

    @GetMapping(path = "/goodbye")
    public String sayGoodbye(){return "Goodbye to you";}

}
