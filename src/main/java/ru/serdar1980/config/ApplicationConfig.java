package ru.serdar1980.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class ApplicationConfig {

    @Bean
    public Docket api(@Qualifier("swaggerParam") SwaggerParams swaggerParams) {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerParams.getEnable())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex(swaggerParams.getPathScanRegex()))
                .build();
    }

    @Component(value = "swaggerParam")
    @ConfigurationProperties(prefix = "swagger")
    private class SwaggerParams {
        private String pathScanRegex;
        private Boolean enable;

        public String getPathScanRegex() {
            return pathScanRegex;
        }

        public void setPathScanRegex(String pathScanRegex) {
            this.pathScanRegex = pathScanRegex;
        }

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }
    }
}
