package com.realtv.mvc;

 import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.realtv.domain.Question;
import com.realtv.repo.QuestionDao;

@Controller
@RequestMapping(value="/question")
public class QuestionController
{/*
    @Autowired
    private QuestionDao questionDao;

    @RequestMapping(method=RequestMethod.GET)
    public String displaySortedQuestions(Model model)
    {
        /*model.addAttribute("newQuestion", new Question());
        model.addAttribute("questions", questionDao.findAllOrderedByName());
        return "index";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String registerNewQuestion(@Valid @ModelAttribute("newQuestion") Question newQuestion, BindingResult result, Model model)
    {
        if (!result.hasErrors()) {
        	questionDao.register(newQuestion);
            return "redirect:/";
        }
        else {
            model.addAttribute("questions", questionDao.findAllOrderedByName());
            return "index";
        }
    }*/
}
