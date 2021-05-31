package cn.com.system.employee.config;
public class GlobalCors {

}


/*
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;

@Configuration
@Slf4j
public class GlobalCors {
    @Value("${allowed.origin}")
    private String allowedOrigin;
    @Bean
    public CorsFilter corsFilter(){
        log.info(this.allowedOrigin);
        //
        CorsConfiguration config =new CorsConfiguration();

        config.addAllowedOrigin(allowedOrigin);

        config.setAllowCredentials(true);

        config.addAllowedMethod("OPtions");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");

        config.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource configSource =new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**",config);

        return new org.springframework.web.filter.CorsFilter(configSource);
    }
}
*/