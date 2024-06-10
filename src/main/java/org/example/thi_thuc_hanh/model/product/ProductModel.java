package org.example.thi_thuc_hanh.model.product;

import org.example.thi_thuc_hanh.database.DBConnect;
import org.example.thi_thuc_hanh.entity.Category;
import org.example.thi_thuc_hanh.entity.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductModel implements IProductModel {
    private Connection connection;

    public ProductModel() {
        DBConnect dbConnect = new DBConnect();
        connection = dbConnect.getConnection();
    }

    @Override
    public void insertInto(Products products) throws SQLException {
        String sql = "call insert_into_product(?, ?, ?, ?, ?, ?);";
        CallableStatement callableStatement = connection.prepareCall(sql);

        callableStatement.setString(1, products.getNameProduct());
        callableStatement.setDouble(2, products.getPrice());
        callableStatement.setInt(3, products.getQuantity());
        callableStatement.setString(4, products.getColor());
        callableStatement.setString(5, products.getDescription());
        callableStatement.setInt(6, products.getIdCategory().getIdCategory());

        callableStatement.executeUpdate();
    }

    @Override
    public Products selectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Products> selectAll() throws SQLException {
        String sql = "call select_all_product();";
        List<Products> productsList = new ArrayList<>();
        CallableStatement callableStatement = connection.prepareCall(sql);
        ResultSet resultSet = callableStatement.executeQuery();

        while (resultSet.next()) {
            int idProduct = Integer.parseInt(resultSet.getString("id_product"));
            String nameProduct = resultSet.getString("name_product");
            double price = Double.parseDouble(resultSet.getString("price"));
            int quantity = Integer.parseInt(resultSet.getString("quantity"));
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            String idCategory = resultSet.getString("name_category");

            Category category = new Category(idCategory);

            productsList.add(new Products(idProduct, nameProduct,price,quantity,color,description,category));
        }

        return productsList;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        String sql = "DELETE FROM products WHERE id_product =?;";
        boolean rowDelete;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        rowDelete = preparedStatement.executeUpdate() > 0;
        return rowDelete;
    }

    @Override
    public boolean update(Products products) throws SQLException {
        return false;
    }
}
