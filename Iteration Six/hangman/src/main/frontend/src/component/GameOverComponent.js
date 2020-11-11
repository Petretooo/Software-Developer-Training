import React, { Component } from "react";
import GameService from "../service/GameService";
import "../css/position.css";

class GameOverComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      game: {},
    };
  }

  componentDidMount() {
    const gameId = this.props.match.params.gameId;
    GameService.getGameById(gameId).then((game) => {
      this.setState({ game });
    });
  }

  render() {
    return (
      <body class="html" class="text-center" data-gr-c-s-loaded="true">
        <h2>Hangman Game</h2>
        <form method="post" action="/hangman/win">
          <div class="cover-container d-flex w-100 h-30 p-3 mx-auto flex-column">
            <h1>You lose!</h1>
            <h2>{this.state.game.currentWord}</h2>
          </div>
        </form>
        <a class="btn btn-lg btn-secondary" href="/hangman">
          Back
        </a>
      </body>
    );
  }
}

export default GameOverComponent;
