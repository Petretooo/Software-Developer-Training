package it;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import app.HangmanApp;
import app.WebServiceConfig;
import app.dao.rank.RankingDao;
import app.soap.ws.client.generated.RankService;
import app.soap.ws.client.generated.RankServiceImplService;
import app.soap.ws.client.generated.RankingDto;
import app.soap.ws.client.generated.RankingDtoList;

@SpringBootTest(classes = { HangmanApp.class })
public class RankWebServiceTest {
	
	@Autowired
	private RankingDao rankingDao;
	
	private RankService service;
	
	@BeforeEach
	private void init() {
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
	
	
	@Test
	public void Should_ReturnCorrectUser_When_GetAllFromTopTen() {
		RankingDtoList dto = service.getRankList();
		List<RankingDto> list = dto.getDtoList();
		List<String> usernameList = list.stream().map(e -> e.getUsername()).collect(Collectors.toList());
		List<String> usernameListFromDao = rankingDao.findAll().stream().map(e -> e.getUser().getUsername()).collect(Collectors.toList());
		boolean isTrue = usernameListFromDao.containsAll(usernameList);
		assertThat(isTrue).isTrue();
	}
	

	@Test
	public void Should_ReturnCorrectUser_When_GetAllFromThisMonth() {
		RankingDtoList dto = service.getRankByMonth();
		List<RankingDto> list = dto.getDtoList();
		List<String> usernameList = list.stream().map(e -> e.getUsername()).collect(Collectors.toList());
		List<String> usernameListFromDao = rankingDao.findAll().stream().map(e -> e.getUser().getUsername()).collect(Collectors.toList());
		boolean isTrue = usernameListFromDao.containsAll(usernameList);
		assertThat(isTrue).isTrue();
	}


}
