package it.morfoza.karo.perfume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FragranceController {

    private FragranceAdvisor advisor;

    @Autowired
    public FragranceController(FragranceAdvisor advisor) {
        this.advisor = advisor;
    }

    @RequestMapping("/")
    public String fragrance() { return "fragrance"; }


    @RequestMapping("/worldoffragrance")
    public String worldoffragrance(
            @RequestParam(value = "search") String search,
            @RequestParam(value = "operation", required = false, defaultValue = "search") String operation, Model model) {
        List<Fragrance> matchingPerfumes = advisor.findMatchingPerfume(search);
        if (matchingPerfumes.isEmpty()) {
            return "redirect:/fragrancenotfound";
        }
        model.addAttribute("matchingPerfumes", matchingPerfumes);
        return "result";
    }

    @RequestMapping("/fragrancenotfound")
    public String fragranceNotFound() {
        return "fragranceNotFound";
    }


}
