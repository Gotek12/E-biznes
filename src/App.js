import "./App.css";
import { Route, Switch } from "react-router-dom";
import Signin from "./components/authorization/Signin";
import Signup from "./components/authorization/Signup";
import Home from "./components/home/Home";
import NavMenu from "./common/nav/NavMenu";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Products from "./components/product/Products";
import AddProduct from "./components/product/AddProduct";
import Categories from "./components/categories/Categories";
import ProductCart from "./components/product/ProductCart";
import UserProductPage from "./components/product/UserProductPage";
import Cart from "./components/cart/Cart";

function App() {
  return (
    <div>
      <NavMenu />
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/signin" exact component={Signin} />
        <Route path="/signup" exact component={Signup} />
        <Route path="/products" exact component={Products} />
        <Route path="/addproduct" exact component={AddProduct} />
        <Route path="/categories" exact component={Categories} />
        <Route path="/product/:id" exact component={ProductCart} />
        <Route path="/tobuy" exact component={UserProductPage} />
        <Route path="/cart" exact component={Cart} />
        {/*<Route path="/admin" exact component={Admin} />*/}
      </Switch>
    </div>
  );
}

export default App;
