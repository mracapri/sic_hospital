package edu.mx.utvm.sic.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
	protected final Log logger = LogFactory.getLog(getClass());
	
    @RequestMapping(value="/index",  method = RequestMethod.GET)
    public ModelAndView handleIndexRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
    	
		ModelAndView model = new ModelAndView("index");
		
		return model;
    }	
     
}
