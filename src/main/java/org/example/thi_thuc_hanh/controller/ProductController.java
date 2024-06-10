package org.example.thi_thuc_hanh.controller;

import org.example.thi_thuc_hanh.service.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductServlet", urlPatterns = "/product/*")
public class ProductController extends HttpServlet {
    private ProductService productService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                try {
                    this.productService.renderPageListProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/create":
                try {
                    this.productService.rederPageAddProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                try {
                    this.productService.addNewProduct(req);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                resp.sendRedirect(req.getContextPath() + "/product/list?success_add=true");
                break;

            case "/delete":
                try {
                    int id = Integer.parseInt(req.getParameter("idProduct"));
                    this.productService.deleteProductById(id);
                    resp.sendRedirect(req.getContextPath() + "/product/list?success_delete=true");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }
}
