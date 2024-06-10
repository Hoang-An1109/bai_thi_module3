package org.example.thi_thuc_hanh.service;

import org.example.thi_thuc_hanh.entity.Category;
import org.example.thi_thuc_hanh.entity.Products;
import org.example.thi_thuc_hanh.model.category.CategoryModel;
import org.example.thi_thuc_hanh.model.product.ProductModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductModel productModel;
    private CategoryModel categoryModel;

    public ProductService() {
        productModel = new ProductModel();
        categoryModel = new CategoryModel();
    }

    public void renderPageListProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        List<Products> products = productModel.selectAll();
        req.setAttribute("products", products);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/list.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void rederPageAddProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<Category> categories = categoryModel.selectAll();
        req.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/product-create.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void addNewProduct(HttpServletRequest req) throws SQLException {
        String productName = req.getParameter("nameProduct");
        Double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        String idCategory = req.getParameter("nameCategory");

        Category category = categoryModel.selectById(Integer.parseInt(idCategory));

        Products products = new Products(productName, price, quantity, color, description, category);
        productModel.insertInto(products);
    }

    public void deleteProductById(int id) throws SQLException {
        productModel.deleteById(id);
    }
}
