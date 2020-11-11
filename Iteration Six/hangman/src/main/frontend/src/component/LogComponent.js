import React, { Component } from "react";
import "../css/position.css";
import "../css/registration.css";
import LoginService from "../service/LoginService";

class LogComponont extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      password: "",
      user: {},
    };
  }

  getUserByNameAndPassword() {
    LoginService.getUser(this.state.username, this.state.password).then(
      (user) => {
        this.setState({ user });
      }
    );
  }

  onChange(event) {
    this.setState({
      username: event.target.value,
      password: event.target.value,
    });
  }

  render() {
    return (
      <body>
        <form class="html">
          <div class="container">
            <h1>Log In</h1>

            <label for="username">
              <b>Username</b>
            </label>
            <input
              value={this.state.username}
              onChange={(event) =>
                this.setState({ username: event.target.value })
              }
              type="text"
              placeholder="Enter Username"
              name="Username"
              id="Username"
              required
            />

            <label for="psw">
              <b>Password</b>
            </label>
            <input
              value={this.state.password}
              onChange={(event) =>
                this.setState({ password: event.target.value })
              }
              type="password"
              placeholder="Enter Password"
              name="psw"
              id="psw"
              required
            />

            <hr />
            <button
              onClick={() => this.getUserByNameAndPassword()}
              className="btn btn-lg btn-secondary"
              type="submit"
            >
              Log In
            </button>
            <br />
            <br />
            <a className="btn btn-lg btn-secondary" href="/hangman">
              Back
            </a>
          </div>
        </form>
      </body>
    );
  }
}

export default LogComponont;
