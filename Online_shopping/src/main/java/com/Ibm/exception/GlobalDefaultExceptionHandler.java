package com.Ibm.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
		public ModelAndView handlerNoHandlerFoundException()
		{
			ModelAndView mv=new ModelAndView("error");
			mv.addObject("errorTitle", "The Page is not constructed");
			mv.addObject("errorDescription", "the page you are looking for is not available now");
			mv.addObject("title", "404 Error Page");
			return mv;
		}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle", "The Product is not avilable");
		mv.addObject("errorDescription", "the product you are looking for is not available now");
		mv.addObject("title", "Product Unavilable");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception e)
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle", "Contact your administrator");
		
		StringWriter sw=new StringWriter();
		PrintWriter pw=new  PrintWriter(sw);
		e.printStackTrace(pw);
		
		mv.addObject("errorDescription", sw.toString());
		mv.addObject("title", "Error!");
		return mv;
	}
	

}
