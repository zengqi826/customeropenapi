/**
 * 
 */
package com.example.openapi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.openapi.model.exception.ErrorResponse;
import com.example.openapi.model.exception.TypeEnum;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 86211
 *
 */
@Configuration
@WebFilter(filterName = "commonFiter", urlPatterns = "/*")
public class CommonFiter implements Filter {


    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if(!httpServletRequest.getRequestURI().isEmpty() && httpServletRequest.getRequestURI().startsWith("/api/v1/customer/")) {
            chain.doFilter(request, response); 
        }else {
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            ErrorResponse errorResponse = new ErrorResponse("invalidRequest",
                    "Missing or invalid parameters", httpServletRequest.getRequestURI(), TypeEnum.ERROR,
                    httpServletRequest.getRequestURI() + " is error requestPath");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(response.getOutputStream(), errorResponse);
            return;
        }
    }

}
