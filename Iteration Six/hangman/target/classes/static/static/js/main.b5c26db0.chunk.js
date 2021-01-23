(this.webpackJsonphangman=this.webpackJsonphangman||[]).push([[0],{13:function(t,e,n){},22:function(t,e,n){},32:function(t,e,n){},33:function(t,e,n){},43:function(t,e,n){"use strict";n.r(e);var a=n(0),c=n(1),r=n(24),s=n.n(r),o=(n(32),n(33),n(4)),i=n(11),h=n(2),l=n(3),d=n(7),j=n(6),u=new(function(){function t(){Object(h.a)(this,t)}return Object(l.a)(t,[{key:"getAllGames",value:function(){return fetch("http://localhost:8080/hangman/api/v1/games",{method:"GET",headers:{Accept:"application/json","Content-Type":"application/json"}}).then((function(t){return t.json()}))}},{key:"getGameById",value:function(t){return fetch("http://localhost:8080/hangman/api/v1/games/"+t).then((function(t){return t.json()}))}},{key:"getCurrentGameAlphabet",value:function(t){return fetch("http://localhost:8080/hangman/api/v1/alphabet/"+t).then((function(t){return t.json()}))}},{key:"getUsedLetters",value:function(t){return fetch("http://localhost:8080/hangman/api/v1/games/letters/"+t).then((function(t){return t.json()}))}},{key:"postGame",value:function(){return fetch("http://localhost:8080/hangman/api/v1/games",{method:"POST"})}},{key:"updateGame",value:function(t,e){return fetch("http://localhost:8080/hangman/api/v1/games/"+t+"?letter=".concat(e),{method:"PUT"})}}]),t}()),b=(n(13),function(t){Object(d.a)(n,t);var e=Object(j.a)(n);function n(t){var a;return Object(h.a)(this,n),(a=e.call(this,t)).state={game:{},usedLetters:[],currentLetters:[]},a}return Object(l.a)(n,[{key:"componentDidMount",value:function(){this.fetchData()}},{key:"fetchData",value:function(){var t=this,e=this.props.match.params.gameId;console.log(e),u.getGameById(e).then((function(e){t.setState({game:e})})),u.getCurrentGameAlphabet(this.props.match.params.gameId).then((function(e){return t.setState({currentLetters:e})})),u.getUsedLetters(this.props.match.params.gameId).then((function(e){return t.setState({usedLetters:e})}))}},{key:"updateGame",value:function(t){var e=this;u.updateGame(this.props.match.params.gameId,t).then((function(){return e.fetchData()}))}},{key:"checkGame",value:function(){return this.state.game.tries<=0&&this.props.history.push("/hangman/games/".concat(this.props.match.params.gameId,"/gameover")),void 0!==this.state.game.currentWord&&void 0!==this.state.game.hiddenWord&&this.state.game.currentWord===this.state.game.hiddenWord&&(console.log(this.state.game.currentWord),console.log(this.state.game.hiddenWord),this.props.history.push("/hangman/games/".concat(this.props.match.params.gameId,"/win"))),null}},{key:"render",value:function(){var t,e=this;return this.checkGame(),Object(a.jsxs)("body",{class:"html",children:[Object(a.jsx)("form",{method:"post",children:Object(a.jsxs)("div",{class:"cover-container d-flex w-100 h-50 p-3 mx-auto flex-column",children:[Object(a.jsx)("h2",{id:"titleId",align:"center",children:"Hangman Game"}),Object(a.jsx)("br",{}),Object(a.jsx)("h3",{align:"center",children:this.state.game.hiddenWord}),Object(a.jsx)("h3",{id:"secret",hidden:"true",align:"center",children:this.state.word}),Object(a.jsx)("br",{}),Object(a.jsx)("br",{}),Object(a.jsx)("br",{}),Object(a.jsx)("br",{}),Object(a.jsx)("br",{}),Object(a.jsx)("br",{}),Object(a.jsxs)("h3",{children:["Used letters: ",this.state.usedLetters]}),Object(a.jsxs)("h3",{children:["Number tries remaining: ",this.state.game.tries]}),Object(a.jsx)("div",{children:this.state.currentLetters.map((function(t){return Object(a.jsx)("button",{onClick:function(){return e.updateGame(t)},class:"btn btn-lg btn-secondary",type:"button",children:t},t)}))}),Object(a.jsx)("br",{}),Object(a.jsx)("br",{})]})}),Object(a.jsx)("div",(t={class:"html"},Object(i.a)(t,"class","cover-container w-10 h-50 p-3 mx-auto flex-column"),Object(i.a)(t,"children",Object(a.jsx)("a",{id:"backHome",class:"btn btn-lg btn-secondary",href:"/hangman",children:"Back"})),t))]})}}]),n}(c.Component)),m="http://localhost:8080/hangman/api/v1/users/",p=new(function(){function t(){Object(h.a)(this,t)}return Object(l.a)(t,[{key:"getAllUsers",value:function(){return fetch("http://localhost:8080/hangman/api/v1/users",{method:"GET",headers:{Accept:"application/json","Content-Type":"application/json"}}).then((function(t){return t.json()}))}},{key:"getAuthUser",value:function(){return fetch("http://localhost:8080/hangman/api/v1/users/auth").then((function(t){return t.json()}))}},{key:"getUserByName",value:function(t){return fetch(m+"".concat(t),{method:"GET",headers:{Accept:"application/json","Content-Type":"application/json"}}).then((function(t){return t.json()}))}},{key:"getUserById",value:function(t){return fetch(m+"".concat(t),{method:"GET",headers:{Accept:"application/json","Content-Type":"application/json"}}).then((function(t){return t.json()}))}},{key:"postGame",value:function(t,e,n){return fetch("http://localhost:8080/hangman/api/v1/users"+"?username=".concat(t,"&email=").concat(e,"&password=").concat(n),{method:"POST",headers:{Accept:"application/json","Content-Type":"application/json"}})}},{key:"postUser",value:function(t,e,n,a){return fetch("http://localhost:8080/hangman/api/v1/users/"+t+"?username=".concat(e,"&email=").concat(n,"&password=").concat(a),{method:"PUT",headers:{Accept:"application/json","Content-Type":"application/json"}})}},{key:"deleteUser",value:function(t){return fetch(m+t,{method:"DELETE",headers:{Accept:"application/json","Content-Type":"application/json"}})}}]),t}()),O=(n(21),n(22),function(t){Object(d.a)(n,t);var e=Object(j.a)(n);function n(t){var a;return Object(h.a)(this,n),(a=e.call(this,t)).state={user:{},username:" ",gameId:""},a}return Object(l.a)(n,[{key:"componentDidMount",value:function(){var t=this;p.getAuthUser().then((function(e){return t.setState({user:e})}))}},{key:"createGame",value:function(){var t=this;u.postGame().then((function(t){return t.text()})).then((function(e){return t.props.history.push("/hangman/games/".concat(e))}))}},{key:"render",value:function(){var t=this;return Object(a.jsxs)("body",{children:[Object(a.jsxs)("ul",{children:[Object(a.jsx)("li",{class:"active",children:Object(a.jsx)("a",{href:"/hangman",children:"Home"})}),Object(a.jsx)("li",{children:Object(a.jsx)("a",{href:"/hangman/logout",children:"Logout"})})]}),console.log(this.props),Object(a.jsx)("form",{class:"html",method:"post",children:Object(a.jsxs)("div",{className:"cover-container d-flex w-100 h-100 p-3 mx-auto flex-column",children:[Object(a.jsx)("h1",{children:"Welcome to my Hangman game!"}),Object(a.jsx)("hr",{}),Object(a.jsx)("button",{onClick:function(){return t.createGame()},id:"buttonGame",className:"btn btn-lg btn-secondary",type:"button",children:"New Game"}),Object(a.jsx)("br",{}),Object(a.jsx)("br",{}),Object(a.jsx)("a",{className:"btn btn-lg btn-secondary",href:"/hangman/rank",children:"Rank"}),Object(a.jsx)("br",{}),Object(a.jsx)("a",{className:"btn btn-lg btn-secondary",href:"/hangman/words",children:"Words"})]})})]})}}]),n}(c.Component)),g=n(26),f=n(15),x=new(function(){function t(){Object(h.a)(this,t)}return Object(l.a)(t,[{key:"getWordsByPage",value:function(t){return fetch("http://localhost:8080/hangman/api/v1/words"+"?page=".concat(t)).then((function(t){return t.json()}))}},{key:"postWord",value:function(t,e){return fetch("http://localhost:8080/hangman/api/v1/words"+"?wordName=".concat(t,"&level=").concat(e),{method:"POST",headers:{Accept:"application/json","Content-Type":"application/json"}})}},{key:"deleteWord",value:function(t){return fetch("http://localhost:8080/hangman/api/v1/words/"+"/".concat(t),{method:"DELETE",headers:{Accept:"application/json","Content-Type":"application/json"}})}}]),t}()),v=(n(34),n(35),function(t){Object(d.a)(n,t);var e=Object(j.a)(n);function n(t){var a;return Object(h.a)(this,n),(a=e.call(this,t)).state={words:[],wordName:"",level:"",page:1,pageCount:0},a.remove=a.remove.bind(Object(f.a)(a)),a}return Object(l.a)(n,[{key:"componentDidMount",value:function(){var t=this;x.getWordsByPage(this.state.page).then((function(e){var n=e.words,a=e.pageCount;t.setState({words:n,pageCount:a})}))}},{key:"componentDidUpdate",value:function(){var t=this;x.getWordsByPage(this.state.page).then((function(e){var n=e.words,a=e.pageCount;t.setState({words:n,pageCount:a})}))}},{key:"remove",value:function(t){var e=this;x.deleteWord(t).then((function(){var n=Object(g.a)(e.state.words).filter((function(e){return e.wordName!==t}));e.setState({words:n})}))}},{key:"onChange",value:function(t){this.setState({wordName:t.target.value,level:t.target.value})}},{key:"createWord",value:function(){x.postWord(this.state.wordName,this.state.level)}},{key:"renderPages",value:function(){for(var t=this,e=[],n=function(n){e.push(Object(a.jsx)("li",{class:"page-item",children:Object(a.jsx)("button",{class:"page-link",onClick:function(){return t.setState({page:n})},type:"button",children:n})}))},c=1;c<=this.state.pageCount;c++)n(c);return e}},{key:"render",value:function(){var t=this;return Object(a.jsxs)("body",{class:"text-center","data-gr-c-s-loaded":"true",children:[Object(a.jsxs)("form",{method:"get",children:[Object(a.jsxs)("label",{for:"wordnameImput",children:["Enter word:",Object(a.jsx)("input",{value:this.state.wordName,onChange:function(e){return t.setState({wordName:e.target.value})},type:"text",id:"wordNameInput",name:"wordName"})]}),Object(a.jsxs)("label",{for:"levelImput",children:["Level of Difficulty:",Object(a.jsx)("input",{value:this.state.level,onChange:function(e){return t.setState({level:e.target.value})},type:"text",id:"levelInput",name:"level"})]}),Object(a.jsx)("button",{onClick:function(){return t.createWord()},id:"addWord",class:"btn btn-lg btn-secondary",type:"submit",children:"Add Word"})]}),Object(a.jsx)("div",{class:"row justify-content-center",children:Object(a.jsxs)("div",{class:"col-auto",children:[Object(a.jsxs)("table",{class:"table table-striped table-hover",children:[Object(a.jsx)("thead",{class:"thead-light",children:Object(a.jsxs)("tr",{children:[Object(a.jsx)("th",{children:"Word"}),Object(a.jsx)("th",{children:"Level"}),Object(a.jsx)("th",{children:"Actions"})]})}),Object(a.jsx)("tbody",{children:this.state.words&&this.state.words.map((function(e){return Object(a.jsxs)("tr",{children:[Object(a.jsx)("td",{children:e.wordName}),Object(a.jsx)("td",{children:e.levelDifficulty}),Object(a.jsx)("td",{children:Object(a.jsx)("button",{size:"sm",color:"danger",onClick:function(){return t.remove(e.wordName)},children:"Delete"})})]},e.wordId)}))})]}),Object(a.jsx)("ul",{class:"pagination pagination-lg",children:this.renderPages()})]})}),Object(a.jsx)("a",{class:"btn btn-lg btn-secondary",href:"/hangman",children:"Back"})]})}}]),n}(c.Component)),y=function(t){Object(d.a)(n,t);var e=Object(j.a)(n);function n(){return Object(h.a)(this,n),e.apply(this,arguments)}return Object(l.a)(n,[{key:"render",value:function(){return Object(a.jsxs)("body",{class:"text-center","data-gr-c-s-loaded":"true",children:[Object(a.jsx)("form",{class:"html",children:Object(a.jsx)("nav",{class:"navbar navbar-expand-sm bg-light navbar-white",children:Object(a.jsx)("div",{children:Object(a.jsxs)("ul",{class:"navbar-nav",children:[Object(a.jsx)("li",{class:"nav-item",children:Object(a.jsx)("a",{class:"nav-link",href:"/hangman/rank/topTen",children:"Top10"})}),Object(a.jsx)("li",{class:"nav-item",children:Object(a.jsx)("a",{class:"nav-link",href:"/hangman/rank/topMonth",children:"Month Rank"})})]})})})}),Object(a.jsx)("a",{class:"btn btn-lg btn-secondary",href:"/hangman",children:"Back"})]})}}]),n}(c.Component),k=new(function(){function t(){Object(h.a)(this,t)}return Object(l.a)(t,[{key:"getRankTopTen",value:function(){return fetch("http://localhost:8080/hangman/api/v1/rank/topTen",{method:"GET",headers:{Accept:"application/json","Content-Type":"application/json"}}).then((function(t){return t.json()}))}},{key:"getRankTopMonth",value:function(){return fetch("http://localhost:8080/hangman/api/v1/rank/topMonth",{method:"GET",headers:{Accept:"application/json","Content-Type":"application/json"}}).then((function(t){return t.json()}))}}]),t}()),w=function(t){Object(d.a)(n,t);var e=Object(j.a)(n);function n(t){var a;return Object(h.a)(this,n),(a=e.call(this,t)).state={rank:[]},a}return Object(l.a)(n,[{key:"componentDidMount",value:function(){var t=this;k.getRankTopTen().then((function(e){return t.setState({rank:e})}))}},{key:"render",value:function(){return Object(a.jsx)("div",{class:"row justify-content-center",children:Object(a.jsxs)("div",{class:"col-auto",children:[Object(a.jsxs)("table",{class:"table table-striped table-hover",children:[Object(a.jsx)("thead",{class:"thead-light",children:Object(a.jsxs)("tr",{children:[Object(a.jsx)("th",{children:"Username"}),Object(a.jsx)("th",{children:"Word"}),Object(a.jsx)("th",{children:"Score"}),Object(a.jsx)("th",{children:"Date"})]})}),Object(a.jsx)("tbody",{children:this.state.rank&&this.state.rank.map((function(t){return Object(a.jsxs)("tr",{children:[Object(a.jsx)("td",{children:t.username}),Object(a.jsx)("td",{children:t.word}),Object(a.jsx)("td",{children:t.score}),Object(a.jsx)("td",{children:t.date})]},t.id)}))})]}),Object(a.jsx)("a",{class:"btn btn-lg btn-secondary",href:"/hangman/rank",children:"Back"})]})})}}]),n}(c.Component),C=function(t){Object(d.a)(n,t);var e=Object(j.a)(n);function n(t){var a;return Object(h.a)(this,n),(a=e.call(this,t)).state={rank:[]},a}return Object(l.a)(n,[{key:"componentDidMount",value:function(){var t=this;k.getRankTopMonth().then((function(e){return t.setState({rank:e})}))}},{key:"render",value:function(){return Object(a.jsx)("div",{class:"row justify-content-center",children:Object(a.jsxs)("div",{class:"col-auto",children:[Object(a.jsxs)("table",{class:"table table-striped table-hover",children:[Object(a.jsx)("thead",{class:"thead-light",children:Object(a.jsxs)("tr",{children:[Object(a.jsx)("th",{children:"Username"}),Object(a.jsx)("th",{children:"Word"}),Object(a.jsx)("th",{children:"Score"}),Object(a.jsx)("th",{children:"Date"})]})}),Object(a.jsx)("tbody",{children:this.state.rank&&this.state.rank.map((function(t){return Object(a.jsxs)("tr",{children:[Object(a.jsx)("td",{children:t.username}),Object(a.jsx)("td",{children:t.word}),Object(a.jsx)("td",{children:t.score}),Object(a.jsx)("td",{children:t.date})]},t.id)}))})]}),Object(a.jsx)("a",{class:"btn btn-lg btn-secondary",href:"/hangman/rank",children:"Back"})]})})}}]),n}(c.Component),T=function(t){Object(d.a)(n,t);var e=Object(j.a)(n);function n(t){var a;return Object(h.a)(this,n),(a=e.call(this,t)).state={game:{}},a}return Object(l.a)(n,[{key:"componentDidMount",value:function(){var t=this,e=this.props.match.params.gameId;u.getGameById(e).then((function(e){t.setState({game:e})}))}},{key:"render",value:function(){var t;return Object(a.jsxs)("body",(t={class:"html"},Object(i.a)(t,"class","text-center"),Object(i.a)(t,"data-gr-c-s-loaded","true"),Object(i.a)(t,"children",[Object(a.jsx)("h2",{children:"Hangman Game"}),Object(a.jsx)("form",{method:"post",action:"/hangman/win",children:Object(a.jsxs)("div",{class:"cover-container d-flex w-100 h-30 p-3 mx-auto flex-column",children:[Object(a.jsx)("h1",{children:"You win!"}),Object(a.jsx)("h2",{children:this.state.game.currentWord})]})}),Object(a.jsx)("a",{class:"btn btn-lg btn-secondary",href:"/hangman",children:"Back"})]),t))}}]),n}(c.Component),G=function(t){Object(d.a)(n,t);var e=Object(j.a)(n);function n(t){var a;return Object(h.a)(this,n),(a=e.call(this,t)).state={game:{}},a}return Object(l.a)(n,[{key:"componentDidMount",value:function(){var t=this,e=this.props.match.params.gameId;u.getGameById(e).then((function(e){t.setState({game:e})}))}},{key:"render",value:function(){var t;return Object(a.jsxs)("body",(t={class:"html"},Object(i.a)(t,"class","text-center"),Object(i.a)(t,"data-gr-c-s-loaded","true"),Object(i.a)(t,"children",[Object(a.jsx)("h2",{children:"Hangman Game"}),Object(a.jsx)("form",{method:"post",action:"/hangman/win",children:Object(a.jsxs)("div",{class:"cover-container d-flex w-100 h-30 p-3 mx-auto flex-column",children:[Object(a.jsx)("h1",{children:"You lose!"}),Object(a.jsx)("h2",{children:this.state.game.currentWord})]})}),Object(a.jsx)("a",{class:"btn btn-lg btn-secondary",href:"/hangman",children:"Back"})]),t))}}]),n}(c.Component);var I=function(){return Object(a.jsx)("main",{children:Object(a.jsxs)("switch",{children:[Object(a.jsx)(o.a,{exact:!0,path:"/hangman",component:O}),Object(a.jsx)(o.a,{exact:!0,path:"/hangman/rank",component:y}),Object(a.jsx)(o.a,{exact:!0,path:"/hangman/words",component:v}),Object(a.jsx)(o.a,{exact:!0,path:"/hangman/words(/:page)",name:"page",component:v}),Object(a.jsx)(o.a,{exact:!0,path:"/hangman/games/:gameId",component:b}),Object(a.jsx)(o.a,{exact:!0,path:"/hangman/rank/topTen",component:w}),Object(a.jsx)(o.a,{exact:!0,path:"/hangman/rank/topMonth",component:C}),Object(a.jsx)(o.a,{exact:!0,path:"/hangman/games/:gameId/win",component:T}),Object(a.jsx)(o.a,{exact:!0,path:"/hangman/games/:gameId/gameover",component:G})]})})},W=function(t){t&&t instanceof Function&&n.e(3).then(n.bind(null,44)).then((function(e){var n=e.getCLS,a=e.getFID,c=e.getFCP,r=e.getLCP,s=e.getTTFB;n(t),a(t),c(t),r(t),s(t)}))},S=n(18);s.a.render(Object(a.jsx)(S.a,{children:Object(a.jsx)(I,{})}),document.getElementById("root")),W()}},[[43,1,2]]]);
//# sourceMappingURL=main.b5c26db0.chunk.js.map