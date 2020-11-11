import React, { Component } from "react";
import "../css/position.css";
import "../css/navbar.css";
class RankComponent extends Component {
  render() {
    return (
      <body class="text-center" data-gr-c-s-loaded="true">
        <form class="html">
          <nav class="navbar navbar-expand-sm bg-light navbar-white">
            <div>
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="/hangman/rank/topTen">
                    Top10
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/hangman/rank/topMonth">
                    Month Rank
                  </a>
                </li>
              </ul>
            </div>
          </nav>
        </form>
        <a class="btn btn-lg btn-secondary" href="/hangman">
          Back
        </a>
      </body>
    );
  }
}

export default RankComponent;
