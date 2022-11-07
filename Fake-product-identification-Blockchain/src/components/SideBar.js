import React, { useEffect, useState } from "react";
import { NavLink, Outlet } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import "../css/sidebar.css";
import Title from "./Title";
import { useNavigate } from "react-router-dom";

const MenuItem = ({ iconName, title, isActive, url }) => {
  let menuClass = "menu-item";
  if (isActive) {
    menuClass += " active-menu";
  }
  return (
    <div className={menuClass}>
      <NavLink className="menu-link" to={url}>
        <FontAwesomeIcon icon={iconName} className="menu-icon" />

        <h1 className="menu-title">{title}</h1>
      </NavLink>
    </div>
  );
};

const SideBar = ({ contract, account, activeLink }) => {
  const navigate = useNavigate();
  return (
    <React.Fragment>
      <div id="sidebar-container">
        <div className="two-div-flex">
          <FontAwesomeIcon
            icon="fa-solid fa-arrow-left"
            className="menu-icon"
            style={{ cursor: "pointer", marginTop: 20 }}
            onClick={() => navigate(-1)}
          />
          <h4 className="wallet-addr-txt">
            Wallet Address:
            {account.substring(0, 4) +
              "..." +
              account.substring(account.length - 4, account.length)}
          </h4>
        </div>

        <div id="menu-item-container">
          <MenuItem
            iconName={"fa-solid fa-truck"}
            title="Track Products."
            isActive={activeLink === "products"}
            url="/vendor/products"
          />
          <MenuItem
            iconName={"fa-solid fa-shirt"}
            title="Add Product."
            isActive={activeLink === "addproduct"}
            url="/vendor/addproduct"
          />
          <MenuItem
            iconName={"fa-solid fa-user"}
            title="Distributors."
            isActive={activeLink === "available-distributors"}
            url="/vendor/available-distributors"
          />
        </div>
      </div>
    </React.Fragment>
  );
};

export default SideBar;
