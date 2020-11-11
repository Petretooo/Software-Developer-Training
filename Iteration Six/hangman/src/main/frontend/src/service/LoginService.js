const login = "http://localhost:8080/hangman/api/v1/login";

class LoginService {
  getUser(username, password) {
    return fetch(login + `?username=${username}&password=${password}`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }).then((res) => res.json());
  }
}

export default new LoginService();
