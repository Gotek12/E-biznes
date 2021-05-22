import React, { useState } from "react";
import ProductService from "../../services/product";
import {
  Avatar,
  IconButton,
  List,
  ListItem,
  ListItemAvatar,
  ListItemSecondaryAction,
  ListItemText,
  Typography,
} from "@material-ui/core";
import FolderIcon from "@material-ui/icons/Folder";
import RemoveIcon from "@material-ui/icons/Remove";
import AddIcon from "@material-ui/icons/Add";

const Cart = () => {
  const [products, setProducts] = useState();

  const deleteHandle = (id) => {
    ProductService.deleteProduct(id).then(
      () => {
        window.location.reload();
      },

      (error) => {
        console.log(error);
      }
    );
  };

  return (
    <div className="outer">
      <div className="inner3">
        {console.log(products ? products.data : "")}
        <Typography variant="h4" className="tx">
          Koszyk
        </Typography>
        <List>
          {products
            ? products.data.map((el, index) => {
                return (
                  <ListItem key={index}>
                    <ListItemAvatar>
                      <Avatar>
                        <FolderIcon />
                      </Avatar>
                    </ListItemAvatar>
                    <ListItemText
                      primary={`${el.name}`}
                      secondary={`${el.description}`}
                    />
                    <ListItemSecondaryAction>
                      <IconButton aria-label="add">
                        <AddIcon />
                      </IconButton>
                      <IconButton aria-label="remove">
                        <RemoveIcon />
                      </IconButton>
                    </ListItemSecondaryAction>
                  </ListItem>
                );
              })
            : ""}
        </List>
      </div>
    </div>
  );
};

export default Cart;
