package bitc.fullstack405.team2.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer  {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 지정한 외부폴더를 스프링의 내부 폴더로 추가(notice)
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:///C:/fullstack405/noticeImg/");

        // 지정한 외부폴더를 스프링의 내부 폴더로 추가(community)
        registry.addResourceHandler("/communityImg/**").addResourceLocations("file:///C:/fullstack405/communityImg/");
    }
}