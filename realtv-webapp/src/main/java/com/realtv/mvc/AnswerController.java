package com.realtv.mvc;

 import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realtv.domain.Answer;
import com.realtv.repo.AnswerDao;

@Controller
public class AnswerController{
	
	private static final String JSON_ANSWER = "json";
	private static final String XML_ANSWER = "xml";
	
    @Autowired
    private AnswerDao answerDao;

    /**
     * View return all answers ordered by ASC - HTML
     * */
    @RequestMapping(value="/answer", method=RequestMethod.GET)
    public String displaySortedAnswers(Model model){
        model.addAttribute("answers", answerDao.findAllOrderedByName());
        return "index"; /*view to return*/
    }
    
    /**
     * View return all answers ordered by ASC - JSON
     * */
    @RequestMapping(value="/answer/" + JSON_ANSWER, method=RequestMethod.GET)
    public @ResponseBody String displaySortedAnswersJSON(Model model){
       
        model.addAttribute("answers", answerDao.findAllOrderedByName());
        return "{'hello':'world'}"; 
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String registerNewAnswer(@Valid @ModelAttribute("newAnswer") Answer newAnswer, BindingResult result, Model model){
       /* if (!result.hasErrors()) {
        	answerDao.register(newAnswer);
            return "redirect:/";
        }
        else {
            model.addAttribute("answers", answerDao.findAllOrderedByName());
            return "index";
        }*/
    	return "";
    }
}
