package kruten.overmobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SwaggerController {
    @RequestMapping("/swagger")
    public String toSwagger(){
        return "redirect:/swagger-ui.html";
    }
}