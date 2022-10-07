import React, { useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useNavigate } from "react-router-dom";
import "../css/distributorform.css";
import Title from "./Title";
import Modal from "react-modal";

const DistributorForm = ({ contract, account }) => {
  const customStyle = {
    content: {
      top: "40%",
      left: "50%",
      right: "auto",
      bottom: "auto",
      marginRight: "-50%",
      transform: "translate(-50%, -50%)",
      width: "600px",
      height: "250px",
      borderRadius: "20px",
    },
  };
  const navigate = useNavigate();

  const [state, setState] = useState({
    name: "",
    address: "",
    email: "",
    phone: "",
  });
  const [modalIsOpen, setIsOpen] = React.useState(false);
  const [message, setMessage] = useState("Register");
  const closeModal = () => {
    setIsOpen(false);
  };

  const handler = (e) => {
    e.preventDefault();
    const val = e.target.value;
    setState({ ...state, [e.target.name]: val });
    console.log(e.target.value);
  };

  const Submit = async (e) => {
    e.preventDefault();
    if (!state.name || !state.address || !state.email || !state.phone) {
      setMessage("Please fill all the fields");
    } else {
      setMessage("Registering...");
      try {
        let createDistributor = await contract.insertDistributor(
          state.name,
          state.address,
          state.email,
          state.phone
        );
        await createDistributor.wait();
        console.log(createDistributor.hash);
        setMessage("Register");
        setIsOpen(true);
      } catch (e) {
        setMessage("Distributor Already Exits");
        console.log(e);
      }
    }
  };

  return (
    <div>
      <Modal
        isOpen={modalIsOpen}
        onRequestClose={closeModal}
        ariaHideApp={false}
        style={customStyle}
      >
        <div style={{ textAlign: "center", marginTop: 40 }}>
          <h2>Your have successfully Registerated.. 🚀</h2>
          <p>You will get a mail if vendor assigns you a dispatch order</p>
          <br />
          <a href="/">Proceed to the Home Page</a>
        </div>

        <span
          onClick={closeModal}
          style={{
            position: "absolute",
            top: 3,
            right: 20,
            fontSize: 28,
            cursor: "pointer",
          }}
        >
          <FontAwesomeIcon icon="fa-solid fa-xmark" />
        </span>
      </Modal>
      <div style={{ display: "flex", justifyContent: "between" }}>
        <FontAwesomeIcon
          icon="fa-solid fa-arrow-left"
          className="menu-icon"
          style={{ cursor: "pointer", marginTop: 20 }}
          onClick={() => navigate(-1)}
        />
        <h4 style={{ color: "#000", position: "fixed", right: 8, top: 2 }}>
          Wallet Address:
          {account.substring(0, 4) +
            "..." +
            account.substring(account.length - 4, account.length)}
        </h4>
        <br />
        <br />
      </div>

      <div>
        <form className="form">
          <h2 className="form-title">Register Here</h2>
          <br />
          <label className="lable">Name</label>

          <input
            type="text"
            placeholder="Name"
            name="name"
            onChange={handler}
            className="input"
            required
          />
          <br />
          <label className="lable">Address</label>
          <input
            type="text"
            placeholder="Address"
            name="address"
            onChange={handler}
            className="input"
            required
          />
          <br />

          <label className="lable">Email</label>
          <input
            type="text"
            placeholder="Email"
            name="email"
            onChange={handler}
            className="input"
            required
          />
          <br />
          <label className="lable">Phone</label>
          <input
            type="text"
            placeholder="Phone"
            name="phone"
            onChange={handler}
            className="input"
            required
          />
          <br />

          <button className="button" onClick={Submit}>
            {message}
          </button>
        </form>
      </div>
    </div>
  );
};

export default DistributorForm;
