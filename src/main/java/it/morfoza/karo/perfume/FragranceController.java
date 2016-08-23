package it.morfoza.karo.perfume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
    public String fragrance() {
        return "fragrance";
    }


    @RequestMapping("/worldoffragrance")
    public String worldoffragrance(
            @RequestParam(name = "search") String search,
            Model model) {
        List<Fragrance> matchingPerfumes = advisor.findMatchingPerfume(search);
        if (matchingPerfumes.isEmpty()) {
            return "redirect:/fragrancenotfound";
        }
        model.addAttribute("matchingPerfumes", matchingPerfumes);
        return "result";
    }

    @RequestMapping("/fragrancenotfound")
    public String fragranceNotFound(@RequestParam(name = "error", required = false) String error, ModelMap model) {
        model.addAttribute("error", error);
        return "fragranceNotFound";
    }

    @RequestMapping("/createnewfragrance")
    public String createnewfragrance(
            @RequestParam(name = "getName", required = true) String getName,
            @RequestParam(name = "getIngredients", required = true) String getIngredients,
            ModelMap model) {
        if (getName.length() < 2) {
            String error = encode("Zbyt krótka nazwa");
            return "redirect:/fragrancenotfound?error=" + error;
        }

        advisor.addFragrance(new Fragrance(getName, getIngredients));

        return "redirect:/newfragrance";
    }


        @RequestMapping("/newfragrance")
    public String newfragrance () {
        return "createNewFragrance";

    }


    @RequestMapping("/all")
    public String all(
            ModelMap model) {
        model.addAttribute("allPerfumes", advisor.findMatchingPerfume(""));
        return "allPerfumes";
    }

    private String encode(String text) {
        try {
            return URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
