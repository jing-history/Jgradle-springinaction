package com.habuma.spitter.mvc;

import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.service.SpitterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by wangyunjing on 2016/10/26.
 */
@Controller
@RequestMapping("/spitters")
public class SpitterController {
    private final SpitterService spitterService;

    @Inject
    public SpitterController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value="/{username}/spittles",
            method=RequestMethod.GET)
    public String listSpittlesForSpitter(
            @PathVariable String username, Model model) {
        model.addAttribute(spitterService.getSpitter(username));
        List<Spittle> spittlesForSpitter = spitterService.getSpittlesForSpitter(username);
        model.addAttribute(spittlesForSpitter);
        return "spittles/list";
    }

}
