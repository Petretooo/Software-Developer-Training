package it;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import app.soap.ws.client.generated.RankService;
import app.soap.ws.client.generated.RankServiceImplService;
import app.soap.ws.client.generated.RankingDto;
import app.soap.ws.client.generated.RankingDtoList;

public class RankWebServiceTest {

	private static RankService service;
	
	@BeforeAll
	private static void init() {
		RankServiceImplService client = new RankServiceImplService();
		service = client.getRankServiceImplPort();
	}

	@Test
	public void Should_ReturnTen_When_GetAllTop10() {
		RankingDtoList dto = service.getRankList();
		List<RankingDto> list = dto.getDtoList();
		int expectedTed = 10;
		assertThat(list.size()).isEqualTo(expectedTed);
	}

	
	@Test
	public void Should_ReturnLessOrEqual_When_GetAllFromThisMonth() {
		RankingDtoList dto = service.getRankByMonth();
		List<RankingDto> list = dto.getDtoList();
		int expectedTed = 10;
		assertThat(list.size()).isLessThanOrEqualTo(expectedTed);
	}

	
	
//	@Test
//	public void Should_ReturnCorrectUser_When_GetAllFromTopTen() {
//		RankingDtoList dto = service.getRankList();
//		List<RankingDto> list = dto.getDtoList();
//		List<String> usernameList = list.stream().map(e -> e.getUsername()).collect(Collectors.toList());
//		boolean isTrue = usernameList.contains(USERNAME);
//		assertThat(isTrue).isTrue();
//	}
//
//	@Test
//	public void Should_ReturnCorrectUser_When_GetAllFromThisMonth() {
//		RankingDtoList dto = service.getRankByMonth();
//		List<RankingDto> list = dto.getDtoList();
//		List<String> usernameList = list.stream().map(e -> e.getUsername()).collect(Collectors.toList());
//		boolean isTrue = usernameList.contains(USERNAME);
//		assertThat(isTrue).isTrue();
//	}

}
