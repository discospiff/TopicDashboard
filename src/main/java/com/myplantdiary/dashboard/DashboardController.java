package com.myplantdiary.dashboard;

import com.myplantdiary.dashboard.service.IDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class DashboardController {

    @Autowired
    IDashboardService dashboardService;

    @RequestMapping("/")
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");

        Set<String> processedPhotos = dashboardService.getProcessedPhotos();
        modelAndView.addObject("processedPhotos", processedPhotos);

        Set<String> unprocessedPhotos = dashboardService.getUnprocessedPhotos();
        modelAndView.addObject("unprocessedPhotos", unprocessedPhotos);

        Set<String> exceptions = dashboardService.getExceptions();
        modelAndView.addObject("exceptions", exceptions);

        return modelAndView;
    }

}
