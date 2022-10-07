import React from "react";
import "../css/mainBar.css";

const MainBar = ({ pageTitle, children }) => {
  return (
    <div id="box-container">
      <div id="page-desc-container">
        <h1 id="page-title">{pageTitle}</h1>
      </div>
      {children}
    </div>
  );
};

export default MainBar;
