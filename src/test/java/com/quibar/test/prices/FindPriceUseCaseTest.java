package com.quibar.test.prices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.quibar.test.prices.domain.dao.PriceDao;
import com.quibar.test.prices.domain.model.Brand;
import com.quibar.test.prices.domain.model.Price;
import com.quibar.test.prices.domain.model.Product;
import com.quibar.test.prices.domain.usecase.FindByDateProductCurrency;

@SpringBootTest
@ActiveProfiles("test")
class FindPriceUseCaseTest {

	@MockBean
	private PriceDao dao;
	
	@Autowired
	FindByDateProductCurrency useCase;
	
	@Test
	void test() {
		var appDate = LocalDateTime.parse("2020-06-14T10:00:00");
		var brandId=1;
		var productId = 35455L;
		var price = Price.builder()
				.brand(Brand.builder()
						.id(brandId)
						.name("ZARA")
						.build())
				.startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
				.endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
				.priceList(1)
				.product(Product.builder()
						.id(productId)
						.build())
				.priority((short)0)
				.value(BigDecimal.valueOf(35.50).setScale(2))
				.curr("EUR")
				.build();
		
		when(this.dao.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(appDate, appDate, productId, brandId))
		.thenReturn(List.of(price));
		
		var result = useCase.execute(appDate, productId, brandId);
		
		assertEquals(price, result);
		
		
	}

}
