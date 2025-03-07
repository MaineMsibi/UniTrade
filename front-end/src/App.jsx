import React from "react";
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import HomePage from "./pages/HomePage";
import Dashboard from "./components/Dashboard";
import RegisterPage from "./pages/RegisterPage";
import ProductsPage from "./pages/ProductsPage";
import ProfilePage from "./pages/ProfilePage";
import ListingsPage from "./pages/ListingsPage";
import SellProductsPage from "./pages/SellProductPage";
import ViewProductsPage from "./pages/ViewProductsPage";
import CartPage from "./pages/CartPage";
import "./index.css";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
         
          <Route path="/" element={<Navigate to="/login" />} />

          <Route path="/login" element={<LoginPage />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/homepage" element={<HomePage />} />
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/productsPage" element={<ProductsPage />} />
          <Route path="/profilePage" element={<ProfilePage />} />
          <Route path="/listingsPage" element={<ListingsPage />} />
          <Route path="/sellProductPage" element={<SellProductsPage />} />
          <Route path="/viewProductsPage" element={<ViewProductsPage />} />
          <Route path="/cartPage" element={<CartPage />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
