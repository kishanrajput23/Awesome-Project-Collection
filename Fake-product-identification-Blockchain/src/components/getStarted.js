import React, { useState, useEffect } from "react";
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

const GetStarted = ({ contract, account }) => {
  console.log("get started", account);
  const [show, setShow] = useState(false);
  const { pathname } = useLocation();

  console.log(account);

  const checkAccount = () => {
    setShow(account === process.env.REACT_APP_WALLET_ADD);
    console.log("account === process.env.REACT_APP_WALLET_ADD",account === process.env.REACT_APP_WALLET_ADD);
  };

  useEffect(() => {
    checkAccount();
  }, []);

  if (!show) {
    return (
      <div>
        <div style={{ textAlign: "center", marginTop: 40 }}>
          <h2 className="primary-txt">OOPs 🙊 your company is not registerd</h2>
          <p className="primary-txt">
            Please do register your company to avail our services
          </p>
          <br />
          <a href="/google.com">Proceed to the Home Page</a>
        </div>
      </div>
    );
  }
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
      <SideBar
        activeLink={currentPageURL}
        contract={contract}
        account={account}
      />
      {isLinkPage && <Greetings />}
      <Outlet />
    </div>
  );
};

export default GetStarted;
