package com.dfy.heart.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger文档
 *
 * @author jack
 * @since 2020/6/8 下午5:46
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        List<Parameter> parameters = new ArrayList<>();
//        parameters.add(new ParameterBuilder().name(BaseHeader.Token).modelRef(new ModelRef("string")).description("token").parameterType("header").required(false).build());
//        parameters.add(new ParameterBuilder().name(BaseHeader.SOURCE).modelRef(new ModelRef("string")).description("来源").parameterType("header").required(false).build());
//        parameters.add(new ParameterBuilder().name(BaseHeader.REQUEST_ID).modelRef(new ModelRef("string")).description("请求id").parameterType("header").required(false).build());
//        parameters.add(new ParameterBuilder().name(BaseHeader.SIGN).modelRef(new ModelRef("string")).description("sign").parameterType("header").required(false).build());
//        parameters.add(new ParameterBuilder().name(BaseHeader.TIMESTAMP).modelRef(new ModelRef("string")).description("timestamp").parameterType("header").required(false).build());


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //加了ApiOperation注解的方法，生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("点方圆 - 服务端")
                .termsOfServiceUrl("Api调用文档")
                .version("1.0.09032")
                .build();
    }

}
