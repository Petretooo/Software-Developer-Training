const users = "http://localhost:8080/hangman/api/v1/users";
const userBy = "http://localhost:8080/hangman/api/v1/users/";
const userAuth = "http://localhost:8080/hangman/api/v1/users/auth";
const createUser = "http://localhost:8080/hangman/api/v1/users";
const updateUser = "http://localhost:8080/hangman/api/v1/users/";
class UserService {
  getAllUsers() {
    return fetch(users, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }).then((res) => res.json());
  }

  getAuthUser() {
    return fetch(userAuth).then((res) => res.json());
  }

  getUserByName(username) {
    return fetch(userBy + `${username}`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }).then((res) => res.json());
  }

  getUserById(userId) {
    return fetch(userBy + `${userId}`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }).then((res) => res.json());
  }

  postGame(username, email, password) {
    return fetch(
      createUser + `?username=${username}&email=${email}&password=${password}`,
      {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      }
    );
  }

  postUser(gameId, username, email, password) {
    return fetch(
      updateUser +
        gameId +
        `?username=${username}&email=${email}&password=${password}`,
      {
        method: "PUT",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      }
    );
  }

  deleteUser(gameId) {
    return fetch(userBy + gameId, {
      method: "DELETE",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    });
  }
}

export default new UserService();
