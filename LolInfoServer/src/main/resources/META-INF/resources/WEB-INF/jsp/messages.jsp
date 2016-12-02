<%
   response.setHeader( "Pragma", "no-cache" );
   response.setHeader( "Cache-Control", "no-cache" );
   response.setDateHeader( "Expires", 0 );
%>
<%@ page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.springframework.context.MessageSource" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.servlet.LocaleResolver" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.svenou.myapp.international.bean.ExposedResourceBundleMessageSource" %>
<%@ page import="org.springframework.context.support.DelegatingMessageSource" %>
<%@ page import="java.util.Map" %><%@ page import="java.util.Locale"%>
        <%
            ApplicationContext context
                =  WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());

            ExposedResourceBundleMessageSource messageSource
                = (ExposedResourceBundleMessageSource)context.getBean("messageSource");

            LocaleResolver localeResolver = (LocaleResolver)context.getBean("localeResolver");

            Locale lc = localeResolver.resolveLocale(request);

            Map<String, String> msgs = messageSource.getKeyValues(lc);

            request.setAttribute("msgs", msgs);
        %>
var <%=request.getAttribute("messagesVarNameShortand")%> = {
    <c:forEach var="entry" items="${msgs}" varStatus="status"><c:out value="${entry.key}"/>: '<c:out value="${entry.value}"/>'<c:if test="${not status.last}">,</c:if></c:forEach>
};
var MS = <%=request.getAttribute("messagesVarNameShortand")%> ;