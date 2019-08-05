package me.brucephillips.springmvcjava11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Create the configuration that tells Spring where to find the view files.
 * 
 * @author f347z964
 *
 */
@Configuration
public class AppConfig {
	
	/**
     * Resolve logical view names to .jsp resources in the /WEB-INF/views
     * directory. For example if the Spring Controller class method returns
     * "home" the view page rendered would be home.jsp found in WEB-INF/views/
     * 
     * @return ViewResolver object
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
