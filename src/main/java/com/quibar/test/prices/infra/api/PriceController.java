package com.quibar.test.prices.infra.api;

import static org.springframework.http.ResponseEntity.ok;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quibar.test.prices.adapters.dto.FindPriceResponse;
import com.quibar.test.prices.adapters.services.PriceService;
import com.quibar.test.prices.infra.api.request.FindPriceRequestValid;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("price")
public class PriceController {

	private final PriceService service;
	
	@GetMapping("find")
	public ResponseEntity<FindPriceResponse> findPrice(@Valid FindPriceRequestValid request) {
		return ok(service.findPrice(request));
	}

}
