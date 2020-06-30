package com.arui.payment8001.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class Swagger2 {

    @Bean
    public Docket createRestApi(@Value("${swagger.enable:false}") boolean enable) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enable)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, customerResponseMessage())
                .forCodeGeneration(true)
                .select()
                .apis(com.google.common.base.Predicates.or(
                        RequestHandlerSelectors.basePackage("com.arui.payment8001.controller")
                    ))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("spring cloud  APIs")
                .description("spr")
                .version("1.1.0")
                .build();
    }

    /**
     * 自定义返回信息
     *
     * @param
     * @return
     */
    private List<ResponseMessage> customerResponseMessage() {
        return Arrays.asList(
                new ResponseMessageBuilder()//500  
                        .code(500)
                        .message("系统繁忙")
                        .responseModel(new ModelRef("Error"))
                        .build(),
                new ResponseMessageBuilder()//401  
                        .code(401)
                        .message("未授权访问")
                        .build());
    }
}
