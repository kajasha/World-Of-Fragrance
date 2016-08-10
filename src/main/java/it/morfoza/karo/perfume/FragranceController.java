package it.morfoza.karo.perfume;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FragranceController {


    @RequestMapping("/fragrance")
    public String fragrance() { return "fragrance"; }


    @RequestMapping("/worldoffragrance")
    public String worldoffragrance(
            @RequestParam(value = "search") String search,
            @RequestParam(value = "operation", required = false, defaultValue = "search") String operation, Model model) {

        String result ="Tu byłam! Karolina!";
        model.addAttribute("resultOfOperation", result);
        return "result";

    }


}
