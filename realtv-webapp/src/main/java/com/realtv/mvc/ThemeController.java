package com.realtv.mvc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.realtv.dao.interfaces.IThemeDao;
import com.realtv.domain.Theme;

@Controller
@RequestMapping(value = "/")
public class ThemeController {
	/*@Autowired
	private ThemeDao themeDao;

	@RequestMapping(method = RequestMethod.GET)
	public String displaySortedTheme(Model model) {
		/*model.addAttribute("newTheme", new Theme());
		model.addAttribute("themes", themeDao.findAllOrderedByName());
		return "index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerNewAnswer(
			@Valid @ModelAttribute("newTheme") Theme newTheme,
			BindingResult result, Model model) {
		if (!result.hasErrors()) {
			themeDao.register(newTheme);
			return "redirect:/";
		} else {
			model.addAttribute("themes", themeDao.findAllOrderedByName());
			return "index";
		}
	}*/
}
