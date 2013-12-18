package com.realtv.mvc;

 import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.realtv.domain.Answer;
import com.realtv.repo.AnswerDao;

@Controller
@RequestMapping(value="/")
public class AnswerController
{
    @Autowired
    private AnswerDao answerDao;

    @RequestMapping(method=RequestMethod.GET)
    public String displaySortedAnswers(Model model)
    {
        model.addAttribute("newAnswer", new Answer());
        model.addAttribute("answers", answerDao.findAllOrderedByName());
        return "index";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String registerNewAnswer(@Valid @ModelAttribute("newAnswer") Answer newAnswer, BindingResult result, Model model)
    {
        if (!result.hasErrors()) {
        	answerDao.register(newAnswer);
            return "redirect:/";
        }
        else {
            model.addAttribute("answers", answerDao.findAllOrderedByName());
            return "index";
        }
    }
}
