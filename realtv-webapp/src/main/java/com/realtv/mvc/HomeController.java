/**
 * 
 */
package com.realtv.mvc;

/**
 * @author Arthur Portas
 * @date 25/01/2014
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = { "/", "/index.html" })
	public String index() {
		slf4jLogger.info("==String index()==");
		return "index";
	}

	@RequestMapping("/protected.html")
	public String protectedPage() {
		slf4jLogger.info("==String protectedPage()==");
		return "protected";
	}
}
