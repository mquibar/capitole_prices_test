package com.quibar.test.prices.infra.api;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quibar.test.prices.adapters.dto.PriceDto;
import com.quibar.test.prices.adapters.services.PriceService;
import com.quibar.test.prices.infra.dto.FindPriceRequest;
import com.quibar.test.prices.infra.validation.FindPriceRequestValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("price")
@Api(value = "Price Controller", tags = "PRICES")
public class PriceController {

	private final PriceService service;
	private final FindPriceRequestValidator validator;
	
	@ApiOperation("Obtener precio segun fecha producto y cadena ")
	@GetMapping("find/{applicationDate}/{productId}/{brandId}")
	public ResponseEntity<PriceDto> findPrice(@PathVariable String applicationDate,
			@PathVariable long productId, @PathVariable int brandId) {
		var request = new FindPriceRequest();
		request.setApplicationDate(applicationDate);
		request.setProductId(productId);
		request.setBrandId(brandId);
		validator.validate(request);
		return ok(service.findPrice(request));
	}

}
