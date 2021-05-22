import React from "react";
import ProductService from "../../services/product";
import { Link } from "react-router-dom";

const Home = () => {
  const getData = (e) => {
    e.preventDefault();

    ProductService.getProductById(0).then(
      (data) => {
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  };

  return (
    <div>
      Hello in Sklepik
      <Link to="product/2">to</Link>
    </div>
  );
};

export default Home;
