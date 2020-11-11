import React, { Component, useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Pagination } from "semantic-ui-react";
import WordComponent from "../component/WordComponent";

class PageComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      page: this.props.page,
      totalPage: this.props.pageCount,
    };
  }

  // renderPages(){
  //     for(let i = 1 ; i <= this.props.pageCount; i++){
  //         if(this.props.page === i){
  //             <li class="page-item active">
  //                 <a class="page-link">${i}</a>
  //             </li>
  //         }else{
  //             <li class="page-item"><a class="page-link">
  //                 ${i}</a>
  //             </li>
  //         }
  //     }
  // }

  render() {
    return (
      <Pagination
        boundaryRange={0}
        defaultActivePage={<WordComponent page={this.state.page} />}
        ellipsisItem={null}
        firstItem={null}
        lastItem={null}
        siblingRange={1}
        totalPages={this.props.pageCount}
      />
    );
  }
}

export default PageComponent;
