package io.sample.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.sample.bean.MainModel;
import io.sample.service.TestService;

/***
 * The <code>IndexController</code> class represents action controller.
 * 1. Explain for a method .....
 * 
 * @author  Woong-joon Kim
 * @version 0.1, 15/09/01
 * @see     io.sample.controller.IndexController#index()
 * @since   JDK1.7
 */
@Controller
public class IndexController extends AbstractBaseController {

	final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private MessageSource message;
	@Autowired
	private TestService testService;
	
    @RequestMapping(value = {"/", "", "index"}, method=RequestMethod.GET)
	public String index(HttpSession session, ModelMap model) throws Exception {

    	MainModel main = new MainModel();

    	main.setResult(testService.getProducts(null));
    	model.addAttribute("model", main);
		return "index";
	}

}