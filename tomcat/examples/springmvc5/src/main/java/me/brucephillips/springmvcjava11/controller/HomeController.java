package me.brucephillips.springmvcjava11.controller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Class that responds to http requests to the start page of this application.
 *
 *
 * @author brucephillips
 *
 */
@Controller
public class HomeController {

    private static final Logger LOGGER = LogManager.getLogger(HomeController.class.getName());


    /**
     * Respond to Get requests made to "/home" - user wants to start the process
     * of adding money to her KU Card Beak 'em Bucks account.
     *
     * @param model - Object to hold values for display in the view
     * @param session - HTTP Session
     * @param request - HTTP Servlet Request
     * @return "home" to render home.jsp
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model, HttpSession session, HttpServletRequest request) {

        LOGGER.debug("request made to /home");

        String viewPage = "home";

        return viewPage;

    }

    /**
     * Respond to Get requests made to "/help" - user wants to visit the help
     * page.
     *
     * @param model - Spring View Model
     * @param session - HTTP Session
     * @return view page name
     */
    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help(Model model, HttpSession session) {

        String tmpReturn;

        tmpReturn = "help";

        return tmpReturn;
    }

    /**
     * 404 handler
     *
     * @return view page name
     */
    @RequestMapping(value = "not-found")
    public String notFound() {

        String tmpReturn;

        tmpReturn = "not-found";

        return tmpReturn;

    }

    /**
     * Respond to Get requests made to "/hello" - user wants to visit the help
     * page.
     *
     * @param model - Spring View Model
     * @param session - HTTP Session
     * @return view page name
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody String hello(Model model, HttpSession session) {
        return "Hello world!";
    }


    /**
     *
     * Requests to the Root of the app are redirected to home.
     *
     * @return redirect to /home
     */
    @RequestMapping(value = "/")
    public String root() {

        return "redirect:home";
        
    }


}
