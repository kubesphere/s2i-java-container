package me.brucephillips.springmvcjava11.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@DisplayName("A request for the home page")
public class HomeControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private HomeController homeController;

    private MockMvc mockMvc;



    @BeforeEach
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    @DisplayName(" should return home view even if made to web root.")
    public void testRedirectHome() throws Exception {

        this.mockMvc.perform(get("/"))
                .andExpect(view().name("redirect:home"));

    }

    @Test
    @DisplayName(" should return home view if made to /home")
    public void testHome() throws Exception {

        MockHttpServletRequestBuilder getRequest = get("/home");

        mockMvc.perform(getRequest).andExpect(view().name("home"));

    }



   

}
