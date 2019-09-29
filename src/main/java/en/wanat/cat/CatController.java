package en.wanat.cat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CatController {

    private List<Cat> catList;

    public CatController() {
        catList = new ArrayList<>();
        catList.add(new Cat("Filemon", "Dachowiec", "white"));
        catList.add(new Cat("Bonifacy", "Dachowiec", "black"));
        catList.add(new Cat("Klakier", "Dachowiec", "#8B0000"));
    }

    @GetMapping("/cats")
    public String getCats(Model model) {
        model.addAttribute("catListModel", catList);
        //kot sie dodaje dopirro po submit
        model.addAttribute("newCat", new Cat());
        return "catsView";
    }

    @PostMapping("/cats")
    public String addCat(@ModelAttribute Cat cat) {
        //@RequestBody -> przyjmuje Jsonma
        //@ModelAttribute -> przyjmuje imput z htmla

        catList.add(cat);
        return "redirect:/cats";
    }

    @PostMapping("/remove-cat")
    public String deleteCat(@ModelAttribute Cat cat) {
        Optional<Cat> first = catList.stream().filter(s -> s.getName().equals(cat.getName())).findFirst();

        if (first.isPresent()) {
            catList.remove(first.get());
        } else {
            System.out.println("takiego kota nie ma");
        }
        return "redirect:/cats";
    }

}

