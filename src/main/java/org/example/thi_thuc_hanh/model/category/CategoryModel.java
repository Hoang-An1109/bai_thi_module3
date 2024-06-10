package org.example.thi_thuc_hanh.model.category;

import org.example.thi_thuc_hanh.database.DBConnect;
import org.example.thi_thuc_hanh.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryModel implements ICategoryModel {
    private Connection connection;

    public CategoryModel() {
        DBConnect dbConnect = new DBConnect();
        connection = dbConnect.getConnection();
    }

    @Override
    public void insertInto(Category category) throws SQLException {

    }

    @Override
    public Category selectById(int id) throws SQLException {
        String sql = "SELECT * FROM category WHERE id_category = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Category category =new Category();

            int idCategory = resultSet.getInt("id_category");
            String nameCategory = resultSet.getString("name_category");

            category.setIdCategory(idCategory);
            category.setNameCategory(nameCategory);
            return category;
        }
        return null;
    }

    @Override
    public List<Category> selectAll() throws SQLException {
        String sql = "SELECT * FROM category";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Category> categories = new ArrayList<>();
        while (resultSet.next()) {
            Category category = new Category();

            int idCategory = resultSet.getInt("id_category");
            String nameCategory = resultSet.getString("name_category");

            category.setIdCategory(idCategory);
            category.setNameCategory(nameCategory);

            categories.add(category);
        }

        return categories;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        return false;
    }
}
