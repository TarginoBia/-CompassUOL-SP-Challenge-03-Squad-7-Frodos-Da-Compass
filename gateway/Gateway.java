package br.com.compassuol.pb.challenge.products.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.compassuol.pb.challenge.products.product.ProductController;
import br.com.compassuol.pb.challenge.products.user.UserResource;

@Configuration
public class Gateway {

	@Bean
	public RouterFunction<ServerResponse> route(UserResource userResource, ProductController productsController) {
		return RouterFunctions
				.route(RequestPredicates.POST("/api/users"), userResource::createUser)
				.andRoute(RequestPredicates.GET("/api/users/{id}"), userResource::getUserById)
				.andRoute(RequestPredicates.GET("/api/products"), productsController::getAllProducts)
				.andRoute(RequestPredicates.GET("/api/products/{id}"), productsController::getProductById)
				.andRoute(RequestPredicates.DELETE("/api/products/{id}"), productsController::deleteProductById)
				.andRoute(RequestPredicates.PUT("/api/products/{id}"), productsController::updateProductById);
	}
}


