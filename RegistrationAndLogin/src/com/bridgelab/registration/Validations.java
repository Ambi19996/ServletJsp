package com.bridgelab.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/Register")
public class Validations implements Filter {

   
    public Validations() {
      
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
//		HttpRequest req=(HttpRequest) request;
//		HttpResponse res=(HttpResponse)response;
//		
		String username=request.getParameter("username");
		String lusername=request.getParameter("lusername");
		String password=request.getParameter("Password");
		String email=request.getParameter("Email");
		
		if (username.length()>1 &&lusername.length()>1 && password.length()>5 && email.contains("@") && email.contains(".com")  ) {
			chain.doFilter(request, response);
		}
		else {
			out.print("Its is invalid registration");
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
