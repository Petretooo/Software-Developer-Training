import React, { Component } from "react";
import "../css/position.css";
import "../css/registration.css";
import UserService from "../service/UserService";

class RegistrationComponont extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      email: "",
      password: "",
    };
  }

  onChange(event) {
    this.setState({
      username: event.target.value,
      email: event.target.value,
      password: event.target.value,
    });
  }

  createUser() {
    UserService.postGame(
      this.state.username,
      this.state.email,
      this.state.password
    ).this((res) => res.text());
  }

  render() {
    return (
      <body>
        <form class="html">
          <div class="container">
            <h1>Register</h1>

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

            <label for="email">
              <b>Email</b>
            </label>
            <input
              value={this.state.email}
              onChange={(event) => this.setState({ email: event.target.value })}
              type="text"
              placeholder="Enter Email"
              name="email"
              id="email"
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
              onClick={() => this.createUser()}
              className="btn btn-lg btn-secondary"
              type="submit"
            >
              Register
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

export default RegistrationComponont;
