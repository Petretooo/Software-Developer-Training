package it;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import app.dao.rank.RankingDao;
import app.service.rank.RankServiceImpl;
import app.soap.ws.client.generated.LocalDate;
import app.soap.ws.client.generated.RankService;
import app.soap.ws.client.generated.RankServiceImplService;
import app.soap.ws.client.generated.RankingDto;
import app.soap.ws.client.generated.RankingDtoList;

public class RankWebServiceTest {

	private static RankService service;

	@Mock
	private RankingDao rankDao;

	@InjectMocks
	private RankServiceImpl rankImpl;

	@BeforeAll
	private static void init() {
		RankServiceImplService client = new RankServiceImplService();
		service = client.getRankServiceImplPort();
	}

	@Test
	public void Should_ReturnTen_When_GetAllTop10() {
		RankingDtoList dto = service.getRankList();
		List<RankingDto> list = dto.getDtoList();
		assertThat(list.size()).isEqualTo(10);
	}

	@Test
	public void Should_ReturnCorrectUser_When_GetAllFromThisMonth() {
		RankingDtoList dto = service.getRankByMonth();
		List<RankingDto> list = dto.getDtoList();
		List<String> usernameList = list.stream().map(e -> e.getUsername()).collect(Collectors.toList());
		boolean isTrue = usernameList.contains("Krasimi551");
		assertThat(isTrue).isTrue();
		
	}

}
