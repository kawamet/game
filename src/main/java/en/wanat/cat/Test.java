package en.wanat.cat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//@RestController

@Controller
public class Test {

    @GetMapping("/hello-world")
    //otwieram http://localhost:8080/hello-world i wyswietla sie zawartosc htmla cats
    public String getHelloWorld(){
        return "catsView";
        //tutaj przekierwuje nas do strony catsView.html
    }
}
