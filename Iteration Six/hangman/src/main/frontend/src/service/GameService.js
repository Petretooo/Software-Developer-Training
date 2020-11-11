const getAllGames = "http://localhost:8080/hangman/api/v1/games";
const getGameById = "http://localhost:8080/hangman/api/v1/games/";
const postGame = "http://localhost:8080/hangman/api/v1/games";
const updateGame = "http://localhost:8080/hangman/api/v1/games/";
const getAlphabet = "http://localhost:8080/hangman/api/v1/alphabet/";
const getUsedLetters = "http://localhost:8080/hangman/api/v1/games/letters/";

class GameService {
  getAllGames() {
    return fetch(getAllGames, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }).then((res) => res.json());
  }

  getGameById(id) {
    return fetch(getGameById + id).then((response) => response.json());
  }

  getCurrentGameAlphabet(id) {
    return fetch(getAlphabet + id).then((response) => response.json());
  }

  getUsedLetters(id) {
    return fetch(getUsedLetters + id).then((response) => response.json());
  }

  postGame(data) {
    return fetch(postGame + `?username=${data}`, {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    });
  }

  updateGame(id, letter) {
    return fetch(updateGame + id + `?letter=${letter}`, {
      method: "PUT",
    });
  }
}

export default new GameService();
