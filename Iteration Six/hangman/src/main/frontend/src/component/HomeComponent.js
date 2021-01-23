import React, { Component } from "react";
import GameService from "../service/GameService";
import UserService from "../service/UserService";
import "bootstrap/dist/css/bootstrap.css";
import "../css/position.css";
import "../css/navbar.css";

class HomeComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: {},
      username: " ",
      gameId: "",
    };
    //this.createGame = this.createGame.bind(this);
    // this.id = "";
  }

  componentDidMount() {
    UserService.getAuthUser().then((res) => this.setState({ user: res }));
  }

  // onChange(event) {
  //   this.setState({ username: event.target.value });
  // }

  createGame() {
    GameService.postGame()
      .then((rest) => rest.text())
      .then((rest) => this.props.history.push(`/hangman/games/${rest}`));
    // .then((res) => this.setState({ gameId: res }));
    //.then(this.props.history.push(`/hangman/games/${this.state.gameId}`));
  }

  // getIdGame() {
  //   return this.state.gameId;
  // }

  render() {
    return (
      <body>
        <ul>
          <li class="active">
            <a href="/hangman">Home</a>
          </li>
          <li>
            <a href="/hangman/logout">Logout</a>
          </li>
          {/* <li>
            <a href="/hangman/registration">Registration</a>
          </li> */}
        </ul>

        {console.log(this.props)}

        <form class="html" method="post">
          <div className="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
            <h1>Welcome to my Hangman game!</h1>
            <hr />
            {/* <label for="nameImput">
              Enter username:{" "}
              <input
                value={this.state.username}
                onChange={(event) =>
                  this.setState({ username: event.target.value })
                }
                type="text"
                id="usernameInput"
                name="username"
              ></input>
            </label> */}
            <button
              onClick={() => this.createGame()}
              id="buttonGame"
              className="btn btn-lg btn-secondary"
              type="button"
            >
              New Game
            </button>
            <br />
            <br />
            <a className="btn btn-lg btn-secondary" href="/hangman/rank">
              Rank
            </a>
            <br />
            <a className="btn btn-lg btn-secondary" href="/hangman/words">
              Words
            </a>
          </div>
        </form>
      </body>
    );
  }
}

export default HomeComponent;
