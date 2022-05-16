package io.github.cloudadc.kubernetes.loader;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
  public OpenAPI customOpenAPI() {
    return (new OpenAPI()).components(new Components())
      .info((new Info()).title("Kubernetes AS3 Loader").description("Load F5 BIG-IP AS3 template to Kubernetes Configmap"));
  }
}
