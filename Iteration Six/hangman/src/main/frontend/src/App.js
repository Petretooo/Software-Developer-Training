import "./App.css";
import { Route } from "react-router-dom";
import GameComponent from "./component/GameComponent";
import HomeComponent from "./component/HomeComponent";
import WordComponent from "./component/WordComponent";
import RankComponent from "./component/RankComponent";
import RankTopTen from "./component/RankTopTen";
import RankTopMonth from "./component/RankTopMonth";
import WinComponent from "./component/WinComponent";
import GameOverComponent from "./component/GameOverComponent";

function App() {
  return (
    <main>
      <switch>
        <Route exact={true} path="/hangman" component={HomeComponent}></Route>
        <Route
          exact={true}
          path="/hangman/rank"
          component={RankComponent}
        ></Route>
        <Route
          exact={true}
          path="/hangman/words"
          component={WordComponent}
        ></Route>
        <Route
          exact={true}
          path="/hangman/words(/:page)"
          name="page"
          component={WordComponent}
        ></Route>
        <Route
          exact={true}
          path="/hangman/games/:gameId"
          component={GameComponent}
        ></Route>
        <Route
          exact={true}
          path="/hangman/rank/topTen"
          component={RankTopTen}
        ></Route>
        <Route
          exact={true}
          path="/hangman/rank/topMonth"
          component={RankTopMonth}
        ></Route>
        <Route
          exact={true}
          path="/hangman/games/:gameId/win"
          component={WinComponent}
        ></Route>
        <Route
          exact={true}
          path="/hangman/games/:gameId/gameover"
          component={GameOverComponent}
        ></Route>
        {/* <Route
          exact={true}
          path="/hangman/logout"
          component={HomeComponent}
        ></Route> */}
        {/* <Route
          exact={true}
          path="/registration"
          component={RegistrationComponent}
        ></Route>
        <Route
          exact={true}
          path="/login"
          component={LogComponent}
        ></Route> */}
      </switch>
    </main>
  );
}

export default App;
