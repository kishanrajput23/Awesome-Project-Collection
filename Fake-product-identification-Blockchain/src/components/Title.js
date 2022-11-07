import React from "react";
import "../css/title.css";

function Title(props) {
  return (
    <div className="titleContainer">
      <h1 className="title">{props.title}</h1>
    </div>
  );
}

export default Title;
