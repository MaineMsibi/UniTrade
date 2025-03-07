import React, { useState } from "react";
import { Link } from 'react-router-dom';

import VisibilityIcon from "@mui/icons-material/Visibility";
import VisibilityOffIcon from "@mui/icons-material/VisibilityOff";

export default function Login() {
  // States for registration
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState("");

  // States for checking the errors
  const [error, setError] = useState(false);


  const handleName = (e) => {
    setName(e.target.value);
    setSubmitted(false);
  };

  const handlePassword = (e) => {
    setPassword(e.target.value);
  };

  //This is where the logic for validating the form will be
  const validateForm = () => {
    return name.length > 0 && password.length > 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (name === "" || password === "") {
      setError(true);
    } else {
      setError(false);
      alert("Login Successful!");
    }
  };

  const errorMessage = () => {
    return (
      <div className="error" style={{ display: error ? "" : "none" }}>
        <h1>Incorrect user credentials</h1>
      </div>
    );
  };

  return (
    <div className="form">
      <div>
        <h1> Login Page</h1>
      </div>
      <form>
        <div className="messages">{errorMessage}</div>
        {/* lables and inputs for  from data*/}
        <input
          onChange={handleName}
          className="input"
          value={name}
          type="text"
        />

        <label className="label">Password</label>
        <input
          onChange={handlePassword}
          className="input"
          value={password}
          type={showPassword ? "text" : "password"}
        />

        {showPassword ? (
          <button
            onClick={(e) => {
              e.preventDefault();
              setShowPassword(false);
            }}
          >
            <VisibilityIcon />
          </button>
        ) : (
          <button
            onClick={(e) => {
              e.preventDefault();
              setShowPassword(true);
            }}
          >
            <VisibilityOffIcon />
          </button>
        )}

        <button onClick={handleSubmit} className="btn" type="submit">
          Login
        </button>
      </form>
      <Link
        href="/forgotPassword"
        variant="body2"
        style={{ textDecoration: "None" }}
      >
        Forgot password?
      </Link>
      <div>
        <h3>Navigate to other pages:</h3>
        <Link to="/homepage">Go to Home Page</Link>
        <br />
        <Link to="/dashboard">Go to Dashboard</Link>
        <br />
        <Link to="/productsPage">Go to Products Page</Link>
        <br />
        <Link to="/profilePage">Go to Profile Page</Link>
        <br />
        <Link to="/listingsPage">Go to Listings Page</Link>
        <br />
        <Link to="/sellProductPage">Go to Sell Products Page</Link>
        <br />
        <Link to="/viewProductsPage">Go to View Products Page</Link>
        <br />
        <Link to="/cartPage">Go to Cart Page</Link>
        <br />
        <Link to="/register">Go to Register Page</Link>
      </div>
    </div>
  );
}
