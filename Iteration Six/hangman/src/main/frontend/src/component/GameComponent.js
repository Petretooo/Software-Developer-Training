import React, { Component } from "react";
import GameService from "../service/GameService";
import "../css/position.css";

class GameComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      game: {},
      usedLetters: [],
      currentLetters: [],
    };
  }

  componentDidMount() {
    this.fetchData();
  }

  fetchData() {
    const gameId = this.props.match.params.gameId;
    console.log(gameId);
    GameService.getGameById(gameId).then((game) => {
      this.setState({ game });
    });

    GameService.getCurrentGameAlphabet(
      this.props.match.params.gameId
    ).then((currentLetters) => this.setState({ currentLetters }));

    GameService.getUsedLetters(
      this.props.match.params.gameId
    ).then((usedLetters) => this.setState({ usedLetters }));
  }

  updateGame(letter) {
    GameService.updateGame(this.props.match.params.gameId, letter).then(() =>
      this.fetchData()
    );
  }

  checkGame() {
    if (this.state.game.tries <= 0) {
      this.props.history.push(
        `/hangman/games/${this.props.match.params.gameId}/gameover`
      );
    }
    if (
      this.state.game.currentWord !== undefined &&
      this.state.game.hiddenWord !== undefined
    ) {
      if (this.state.game.currentWord === this.state.game.hiddenWord) {
        console.log(this.state.game.currentWord);
        console.log(this.state.game.hiddenWord);
        this.props.history.push(
          `/hangman/games/${this.props.match.params.gameId}/win`
        );
      }
    }
    return null;
  }

  render() {
    this.checkGame();

    return (
      <body class="html">
        <form method="post">
          <div class="cover-container d-flex w-100 h-50 p-3 mx-auto flex-column">
            <h2 id="titleId" align="center">
              Hangman Game
            </h2>
            <br />
            <h3 align="center">{this.state.game.hiddenWord}</h3>
            <h3 id="secret" hidden="true" align="center">
              {this.state.word}
            </h3>
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <h3>Used letters: {this.state.usedLetters}</h3>
            <h3>Number tries remaining: {this.state.game.tries}</h3>
            <div>
              {this.state.currentLetters.map((e) => (
                <button
                  onClick={() => this.updateGame(e)}
                  key={e}
                  class="btn btn-lg btn-secondary"
                  type="button"
                >
                  {e}
                </button>
              ))}
            </div>
            <br />
            <br />
          </div>
        </form>
        <div
          class="html"
          class="cover-container w-10 h-50 p-3 mx-auto flex-column"
        >
          <a id="backHome" class="btn btn-lg btn-secondary" href="/hangman">
            Back
          </a>
        </div>
      </body>
    );
  }
}

export default GameComponent;
