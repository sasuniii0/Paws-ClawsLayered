package lk.ijse.gdse.pawsandclawscaremvc.bo.custom.impl;

import lk.ijse.gdse.pawsandclawscaremvc.bo.custom.ProductManageBO;
import lk.ijse.gdse.pawsandclawscaremvc.dao.DAOFactory;
import lk.ijse.gdse.pawsandclawscaremvc.dao.custom.ProductDAO;
import lk.ijse.gdse.pawsandclawscaremvc.dto.OrderDetailsDto;
import lk.ijse.gdse.pawsandclawscaremvc.dto.ProductDto;
import lk.ijse.gdse.pawsandclawscaremvc.entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductManageBOImpl implements ProductManageBO {
    ProductDAO productDAO = (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);
    @Override
    public boolean reduceQty(OrderDetailsDto orderDetailsDto) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<String> getAllProductId() throws SQLException {
        return null;
    }

    @Override
    public ProductDto findById(String selectedProId) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<ProductDto> searchProductsByCatalog(String searchText) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<ProductDto> getLowStockProducts() throws SQLException {
        return null;
    }

    @Override
    public boolean saveProduct(ProductDto dto) throws SQLException {
        return productDAO.save(new Product(dto.getProductId(), dto.getProductName(), dto.getDescription(), dto.getPrice(), dto.getQty()));
    }

    @Override
    public String getNextProductId() throws SQLException {
        return productDAO.getNextId();
    }

    @Override
    public ArrayList<ProductDto> getAllProducts() throws SQLException {
        ArrayList<Product> products = productDAO.getAll();
        ArrayList<ProductDto> productDtos = new ArrayList<>();
        for (Product product: products){
            products.add(new Product(product.getProductId(), product.getProductName(), product.getDescription(), product.getPrice(), product.getQty()));
        }
        return productDtos;
    }

    @Override
    public boolean deleteItem(String customerId) throws SQLException {
        return productDAO.delete(customerId);
    }

    @Override
    public boolean updateProduct(ProductDto dto) throws SQLException {
        return productDAO.update(new Product(dto.getProductId(), dto.getProductName(), dto.getDescription(), dto.getPrice(), dto.getQty()));
    }
}
