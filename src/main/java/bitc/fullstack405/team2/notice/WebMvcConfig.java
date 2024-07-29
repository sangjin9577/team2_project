package bitc.fullstack405.team2.notice;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 지정한 외부폴더를 스프링의 내부 폴더로 추가
        registry.addResourceHandler("/noticeImg/**").addResourceLocations("file:///C:/fullstack405/noticeImg/");
    }
}