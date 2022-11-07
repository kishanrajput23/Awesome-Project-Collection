import "./App.css";

import React, { useEffect, useState } from "react";

import VendorForm from "./components/VendorForm";
import { ethers } from "ethers";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import DistributorForm from "./components/DistributorForm";
import Home from "./components/Home";
import AssetTracker from "./utils/AssetTracker.json";

import { library } from "@fortawesome/fontawesome-svg-core";
import { fas } from "@fortawesome/free-solid-svg-icons";
import Products from "./components/TrackProducts";
import Distributors from "./components/Distributors";

// import SideBar from "./components/SideBar";

import Authenticate from "./components/Authenticate";
import GetStarted from "./components/getStarted";

const CONTRACT_ADDRESS = process.env.REACT_APP_CONTRACT_ADD;

library.add(fas);

const App = () => {
  console.log(process.env.REACT_APP_WALLET_ADD);
  const [currentAccount, setCurrentAccount] = useState("");
  const [wallet, setWallet] = useState("Please Connect Your Wallet to Proceed");
  const [contract, setContract] = useState(null);

  const checkIfWalletIsConnected = async () => {
    const { ethereum } = window;

    if (!ethereum) {
      console.log("Make sure you have metamask!");
      return;
    } else {
      console.log("We have the ethereum object", ethereum);
    }

    const accounts = await ethereum.request({ method: "eth_accounts" });

    if (accounts.length !== 0) {
      const account = accounts[0];

      console.log("Found an authorized account:", account);
      setWallet("Connected");

      setCurrentAccount(account);

      const provider = new ethers.providers.Web3Provider(ethereum);
      const signer = provider.getSigner();
      const contract = new ethers.Contract(
        CONTRACT_ADDRESS,
        AssetTracker.abi,
        signer
      );
      console.log("contract", contract);
      setContract(contract);
    } else {
      console.log("No authorized account found");
    }
  };

  const connectWallet = async () => {
    try {
      const { ethereum } = window;

      if (!ethereum) {
        alert("Get MetaMask!");
        return;
      }

      const accounts = await ethereum.request({
        method: "eth_requestAccounts",
      });

      console.log("Connected", accounts[0]);

      setWallet("Connected");

      setCurrentAccount(accounts[0]);
      const provider = new ethers.providers.Web3Provider(ethereum);
      const signer = provider.getSigner();
      const contract = new ethers.Contract(
        CONTRACT_ADDRESS,
        AssetTracker.abi,
        signer
      );
      setContract(contract);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    checkIfWalletIsConnected();
  }, []);

  return (
    <>
      {contract ? (
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Home account={currentAccount} />}></Route>
            {/* <Route
              path="/vendor"
              element={<SideBar contract={contract} account={currentAccount} />}
            ></Route> */}
            <Route
              path="/vendor"
              element={
                <GetStarted contract={contract} account={currentAccount} />
              }
            >
              <Route
                path="products"
                element={
                  <Products contract={contract} account={currentAccount} />
                }
              ></Route>
              <Route
                path="addproduct"
                element={
                  <VendorForm contract={contract} account={currentAccount} />
                }
              />
              <Route
                path="available-distributors"
                element={
                  <Distributors contract={contract} account={currentAccount} />
                }
              />
            </Route>
            <Route
              path="/distributorform"
              element={
                <DistributorForm contract={contract} account={currentAccount} />
              }
            ></Route>
            {/* <Route
              path="/vendor/products"
              element={
                <Products contract={contract} account={currentAccount} />
              }
            ></Route>
            <Route
              path="/vendor/addproduct"
              element={
                <VendorForm contract={contract} account={currentAccount} />
              }
            />
            <Route
              path="/vendor/available-distributors"
              element={
                <Distributors contract={contract} account={currentAccount} />
              }
            /> */}
            <Route
              path="/authenticate"
              element={
                <Authenticate contract={contract} account={currentAccount} />
              }
            />
          </Routes>
        </BrowserRouter>
      ) : (
        <div>
          <div>
            <div className="connectWalletContainer">
              {wallet === "Please Connect Your Wallet to Proceed" && (
                <button onClick={connectWallet} className="connectWalletBtn">
                  <img
                    src={
                      "https://cdn.iconscout.com/icon/free/png-256/metamask-2728406-2261817.png"
                    }
                    className="img"
                    alt="metamask"
                  />{" "}
                  {wallet}
                </button>
              )}
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default App;
