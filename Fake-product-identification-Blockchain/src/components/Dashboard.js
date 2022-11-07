import React from "react";
import { Outlet, useLocation } from "react-router-dom";
import SideBar from "./SideBar";
import MainBar from "./MainBar";
import "../css/products.css";

const Greetings = () => {
  return (
    // <div id="get-started">
    <MainBar pageTitle="Welcome to manufacturer dashboard">
      {/* <h1 className="mfr-greetings"></h1> */}
      <h1 className="secondary-txt">
        Navigate to profile to view all your registered details
      </h1>
      <h1 className="secondary-txt">
        Navigate to Track Products to track status of all of your products added
        to our system
      </h1>
      <h1 className="secondary-txt">
        Navigate to Add Products to publish a new product to our system
      </h1>
    </MainBar>
    // </div>
  );
};

const Dashboard = () => {
  const { pathname } = useLocation();
  const arrURL = pathname.split("/");
  let currentPageURL = arrURL[2];
  let isLinkPage;
  if (arrURL.length >= 3) {
    isLinkPage = arrURL[2] === "";
  } else {
    isLinkPage = true;
  }

  return (
    <div className="main-container">
      <SideBar activeLink={currentPageURL} />;{isLinkPage && <Greetings />}
      <Outlet />
    </div>
  );
};

export default Dashboard;
