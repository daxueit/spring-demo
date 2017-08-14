package com.daxueit.springmvc.controller.spel;

import com.daxueit.springmvc.beans.spel.SpELBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/13.
 */
@Controller
@RequestMapping("/spel")
public class SpelController {
    @Autowired
    private SpELBean spELBean;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("spel/index");
        model.addObject("data", spELBean.outputResource());
        return model;
    }
}
