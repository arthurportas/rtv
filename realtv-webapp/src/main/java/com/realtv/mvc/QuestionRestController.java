package com.realtv.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realtv.domain.Question;
import com.realtv.repo.QuestionDao;

@Controller
@RequestMapping("/rest/questions")
public class QuestionRestController
{
    @Autowired
    private QuestionDao questionDao;

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Question> listAllMembers()
    {
        return questionDao.findAllOrderedByName();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Question lookupMemberById(@PathVariable("id") Long id)
    {
        return questionDao.findById(id);
    }
}
