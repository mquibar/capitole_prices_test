package com.quibar.test.prices;

import static com.quibar.test.prices.utils.TestUtils.parseResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.quibar.test.prices.adapters.dto.PriceDto;
import com.quibar.test.prices.infra.entity.BrandEntity;
import com.quibar.test.prices.infra.entity.PriceEntity;
import com.quibar.test.prices.infra.entity.ProductEntity;
import com.quibar.test.prices.infra.utils.BuilderUtils;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class FindPricesTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	private BrandEntity brand;
	private ProductEntity product;
	private List<PriceEntity> prices;
	
	@BeforeEach
	void setUp() throws Exception {
		brand = BuilderUtils.brandBuilder();
		product = BuilderUtils.productBuilder();
		prices = BuilderUtils.pricesBuilder(brand, product);
	}

	
	private static Stream<Arguments> dateCombinations(){
		return Stream.of(
				Arguments.of("2020-06-14T10:00:00"),
				Arguments.of("2020-06-14T16:00:00"),
				Arguments.of("2020-06-14T21:00:00"),
				Arguments.of("2020-06-15T10:00:00"),
				Arguments.of("2020-06-16T21:00:00"));
	}
	
	
	@ParameterizedTest
    @MethodSource("dateCombinations")
	void findOfDateTest(String date) throws Exception {
		
		MvcResult requestResult = mockMvc.perform(
				get("/price/find/{applicationDate}/{productId}/{brandId}",
						date,
						product.getId(),
						brand.getId())
				.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andReturn();
		final var response = parseResponse(requestResult, PriceDto.class);
		assertNotNull(response);
		
		var datetime = LocalDateTime.parse(date);
		var expected = prices.stream()
			.filter(price -> datetime.isAfter(price.getStartDate()) &&
				datetime.isBefore(price.getEndDate()))
			.sorted(Comparator.comparingLong(PriceEntity::getPriority)
					.reversed())
			.findFirst().get();
		
		assertNotNull(expected);
		assertEquals(expected.getValue(), response.getPrice());
		
	}

}
