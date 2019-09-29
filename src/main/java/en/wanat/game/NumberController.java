package en.wanat.game;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class NumberController {

    private  int random;
    private String result;
    private int count =0;


    public NumberController() {
        result = new String();
        random = new Random().nextInt(10);
    }


    @GetMapping("/game")
    public String getGame(Model model ){
        model.addAttribute("random", random );
        model.addAttribute("numberFromUser", new RandomNumber()); /*zawsze musze stworzyc nowa klase*/
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "game/gameView";
    }


    @PostMapping("/game")
    public String checkNumber(@ModelAttribute RandomNumber randomNumber) {
        if (randomNumber.getUserValue() == random){
            result ="Tyle wygrac"; /*przekazuje to do atrybutu*/
        }else {
            result = "NIE";
            count++;
        }
        return "redirect:/game";
    }
}
