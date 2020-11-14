package com.batteryshop.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    /**
     * @deprecated
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST})
    public String handleError(HttpServletRequest request, WebRequest webRequest, NoHandlerFoundException exception, Model model) {
        // get error status
        var status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        // TODO: log error details here

        if (status != null) {
            var statusCode = Integer.parseInt(status.toString());

            model.addAttribute("back_url", webRequest.getHeader("Referer"));
            model.addAttribute("statusCode", statusCode);
            model.addAttribute("exception", exception.getLocalizedMessage());

            // display specific error page
//            if (statusCode == HttpStatus.NOT_FOUND.value()) {
//                return "404";
//            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                return "500";
//            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
//                return "403";
//            }
        }

        // display generic error
        return "error-page";
    }

//    @RequestMapping(value = "error", method = {RequestMethod.GET, RequestMethod.POST})
//    protected String handleError(Model model, WebRequest webRequest, HttpServletResponse response,
//                                 Exception exception) {
//        int status = response.getStatus();
//        char[] status_code = String.valueOf(status).toCharArray();
//        model.addAttribute("back_url", webRequest.getHeader("Referer"));
//        model.addAttribute("status", status);
//        model.addAttribute("status_array", status_code);
//        model.addAttribute("exception", exception.getMessage());
//        return "error-page";
//    }
}
