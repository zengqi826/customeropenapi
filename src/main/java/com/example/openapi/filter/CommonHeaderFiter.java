/**
 * 
 */
package com.example.openapi.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import org.springframework.util.StringUtils;

import com.example.openapi.configuration.TenantContext;
import com.example.openapi.model.NecessaryHeader;
import com.example.openapi.model.exception.ErrorResponse;
import com.example.openapi.model.exception.TypeEnum;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 86211
 *
 */
@Configuration
@WebFilter(filterName = "commonHeaderFiter", urlPatterns = "/api/v1/customer/*")
public class CommonHeaderFiter implements Filter {

    private String necessaryHeaderString = "";

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

        String[] necessaryHeaders = { NecessaryHeader.AUTHORIZATION, NecessaryHeader.UUID, NecessaryHeader.CLIENTID,
                NecessaryHeader.DATASOURCE };
        List<String> necessaryHederLists = new ArrayList<>(Arrays.asList(necessaryHeaders));

        if (necessaryHederLists.stream().anyMatch(necessaryHeader -> {
            necessaryHeaderString = necessaryHeader;
            return StringUtils.isEmpty(httpServletRequest.getHeader(necessaryHeader));
        })) {
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
            ErrorResponse errorResponse = new ErrorResponse("accessNotConfigured",
                    "Access is not configured for this resource", httpServletRequest.getRequestURI(), TypeEnum.ERROR,
                    necessaryHeaderString + " is empty");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(response.getOutputStream(), errorResponse);
            return;
        } else {
            String tenant=httpServletRequest.getHeaders(NecessaryHeader.DATASOURCE).nextElement();
            TenantContext.setCurrentTenant(tenant);
            chain.doFilter(request, response);
        }
    }

}
