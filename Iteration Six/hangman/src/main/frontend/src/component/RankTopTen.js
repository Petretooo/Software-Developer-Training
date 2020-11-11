import { Component } from "react";
import RankService from "../service/RankService";

class RankTopTen extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rank: [],
    };
  }

  componentDidMount() {
    RankService.getRankTopTen().then((res) => this.setState({ rank: res }));
  }

  render() {
    return (
      <div class="row justify-content-center">
        <div class="col-auto">
          <table class="table table-striped table-hover">
            <thead class="thead-light">
              <tr>
                <th>Username</th>
                <th>Word</th>
                <th>Score</th>
                <th>Date</th>
              </tr>
            </thead>
            <tbody>
              {this.state.rank &&
                this.state.rank.map((r) => (
                  <tr key={r.id}>
                    <td>{r.username}</td>
                    <td>{r.word}</td>
                    <td>{r.score}</td>
                    <td>{r.date}</td>
                  </tr>
                ))}
            </tbody>
          </table>
          <a class="btn btn-lg btn-secondary" href="/hangman/rank">
            Back
          </a>
        </div>
      </div>
    );
  }
}

export default RankTopTen;
