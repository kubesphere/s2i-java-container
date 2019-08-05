package me.brucephillips.springmvcjava11.controller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Spring web mvc controller that will handle any Exception thrown that is not
 * handled.
 *
 * @author f347z964
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class.getName());

    private static final String DISPLAYNAME = "displayName";

    /**
     * Responds to exceptions thrown but not caught by the application - sends
     * user to error.jsp.
     *
     * @param session - HTTP Session
     * @param req HttpServletRequest - original request
     * @param ex Exception thrown
     * @return model and view page
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpSession session, HttpServletRequest req, Exception ex) {

        LOGGER.error("Request made to " + req.getRequestURL() + " resulted in an Exception being thrown.");

        LOGGER.error(ex.getMessage(), ex);

        ModelAndView mav = new ModelAndView();

        if (session.getAttribute(DISPLAYNAME) != null) {
            mav.addObject(DISPLAYNAME, session.getAttribute(DISPLAYNAME));
        }

        mav.setViewName("error");

        return mav;

    }



}
