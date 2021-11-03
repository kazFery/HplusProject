package com.test.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.bean.Product;

public class ApplicationDao {


	public List<Product> searchProducts(String searchString) {
		Product  product = null;
		List<Product>  products = new ArrayList<Product>();
		
		Connection cont = DBConnection.getConnectionToDatabase();
		String sql = "select * from products where product_name like '%"+searchString+"%'";
		System.out.println("------------------");
		try {
			Statement statement = cont.createStatement();
			ResultSet  set = statement.executeQuery(sql);
			while(set.next()) {
				product= new Product();
				product.setProductId(set.getInt("product_id"));
				product.setProductImgPath(set.getString("image_path"));
				product.setProductName(set.getString("product_name"));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in applicationdao");
			e.printStackTrace();
		}
		
		return products;
	}

}
