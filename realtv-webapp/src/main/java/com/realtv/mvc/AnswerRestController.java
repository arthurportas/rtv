package com.realtv.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realtv.domain.Answer;
import com.realtv.repo.AnswerDao;

@Controller
@RequestMapping("/rest/answers")
public class AnswerRestController
{
    @Autowired
    private AnswerDao answerDao;

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Answer> listAllMembers()
    {
        return answerDao.findAllOrderedByName();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Answer lookupMemberById(@PathVariable("id") Long id)
    {
        return answerDao.findById(id);
    }
}
