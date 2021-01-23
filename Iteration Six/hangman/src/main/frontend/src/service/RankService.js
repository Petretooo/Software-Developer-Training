const getRankTopTen = "http://localhost:8080/hangman/api/v1/rank/topTen";
const getRankTopMonth = "http://localhost:8080/hangman/api/v1/rank/topMonth";

class RankService {
  getRankTopTen() {
    return fetch(getRankTopTen, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }).then((res) => res.json());
  }

  getRankTopMonth() {
    return fetch(getRankTopMonth, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }).then((res) => res.json());
  }
}

export default new RankService();
