import React, { Component } from "react";
import WordService from "../service/WordService";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { queryString } from "querystring";

class WordComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      words: [],
      wordName: "",
      level: "",
      page: 1,
      pageCount: 0,
    };
    this.remove = this.remove.bind(this);
  }

  componentDidMount() {
    WordService.getWordsByPage(this.state.page).then(({ words, pageCount }) => {
      this.setState({ words, pageCount });
    });
  }

  componentDidUpdate() {
    WordService.getWordsByPage(this.state.page).then(({ words, pageCount }) => {
      this.setState({ words, pageCount });
    });
  }

  remove(wordName) {
    WordService.deleteWord(wordName).then(() => {
      let updatedWords = [...this.state.words].filter(
        (i) => i.wordName !== wordName
      );
      this.setState({ words: updatedWords });
    });
  }

  onChange(event) {
    this.setState({ wordName: event.target.value, level: event.target.value });
  }

  createWord() {
    WordService.postWord(this.state.wordName, this.state.level);
  }

  renderPages() {
    const pages = [];
    for (let i = 1; i <= this.state.pageCount; i++) {
      pages.push(
        <li class="page-item">
          {/* <a
            href={`/hangman/words?page=${i}`}
            class="page-link"
            onClick={() => this.setState({ page: i })}
          >
            {i}
          </a> */}
          <button
            class="page-link"
            onClick={() => this.setState({ page: i })}
            type="button"
          >
            {i}
          </button>
        </li>
      );
    }

    return pages;
  }

  render() {
    return (
      <body class="text-center" data-gr-c-s-loaded="true">
        <form method="get">
          <label for="wordnameImput">
            Enter word:
            <input
              value={this.state.wordName}
              onChange={(event) =>
                this.setState({ wordName: event.target.value })
              }
              type="text"
              id="wordNameInput"
              name="wordName"
            ></input>
          </label>
          <label for="levelImput">
            Level of Difficulty:
            <input
              value={this.state.level}
              onChange={(event) => this.setState({ level: event.target.value })}
              type="text"
              id="levelInput"
              name="level"
            ></input>
          </label>
          <button
            onClick={() => this.createWord()}
            id="addWord"
            class="btn btn-lg btn-secondary"
            type="submit"
          >
            Add Word
          </button>
        </form>
        <div class="row justify-content-center">
          <div class="col-auto">
            <table class="table table-striped table-hover">
              <thead class="thead-light">
                <tr>
                  <th>Word</th>
                  <th>Level</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {this.state.words &&
                  this.state.words.map((word) => (
                    <tr key={word.wordId}>
                      <td>{word.wordName}</td>
                      <td>{word.levelDifficulty}</td>
                      <td>
                        <button
                          size="sm"
                          color="danger"
                          onClick={() => this.remove(word.wordName)}
                        >
                          Delete
                        </button>
                      </td>
                    </tr>
                  ))}
              </tbody>
            </table>
            <ul class="pagination pagination-lg">{this.renderPages()}</ul>
          </div>
        </div>

        <a class="btn btn-lg btn-secondary" href="/hangman">
          Back
        </a>
      </body>
    );
  }
}

export default WordComponent;
