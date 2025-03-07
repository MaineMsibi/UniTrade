import React from "react";

import ProfilePage from "../pages/ProfilePage";
import CartPage from "../pages/CartPage";
import ListingsPage from "../pages/ListingsPage";
import SellProductPage from "../pages/SellProductPage";

import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import FavoriteIcon from "@mui/icons-material/Favorite";
import SellIcon from "@mui/icons-material/Sell";

export const DashboardLinks = [
  {
    title: "Profile",
    icon: <AccountCircleIcon />,
    link: <ProfilePage />,
  },
  {
    title: "Cart",
    icon: <ShoppingCartIcon />,
    link: <CartPage />,
  },
  {
    title: "Listings",
    icon: <FavoriteIcon />,
    link: <ListingsPage />,
  },
  {
    title: "SellProduct",
    icon: <SellIcon />,
    link: <SellProductPage />,
  },
];
