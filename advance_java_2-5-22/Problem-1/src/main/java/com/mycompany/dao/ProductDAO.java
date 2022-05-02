package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.dbutil.DBUtil;
import com.mycompany.domain.Product;


public class ProductDAO {

	public List<Product> getAllProducts(){
		List<Product>ProductList=new ArrayList<Product>();
		try {
			Connection con = DBUtil.getcon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Product");
			while(rs.next()) {
				Product p = new Product(rs.getString(1),rs.getString(2) , rs.getInt(3));
				ProductList.add(p);
			}	
			con.close();
			} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return ProductList;
	}
	
	public boolean AddProduct(Product product) {
		boolean result=false;
		try {
			Connection con = DBUtil.getcon();
			PreparedStatement ps=con.prepareStatement("Insert into product values(?,?,?)");
			ps.setString(1,product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setInt(3, product.getProductPrice());
			ps.executeUpdate();
			result =true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			result=false;
		}
		return result;
	}
	
	public int updateProduct(Product product)
    {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getcon();
            PreparedStatement ps = conn.prepareStatement("UPDATE product SET product_name=?, product_price=? WHERE product_id=?");
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getProductPrice());
            ps.setString(3, product.getProductId());
            status = ps.executeUpdate();  
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
	 public int deleteProduct(String productId)
	    {
	        int status = 0;
	        try
	        {
	            Connection conn = DBUtil.getcon();
	            PreparedStatement ps = conn.prepareStatement("DELETE FROM product where product_id = ?");
	            ps.setString(1, productId);
	            status = ps.executeUpdate();  

	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        return status;
	    }
	 
	 public Product getProductByid(String productId)
	    {
	        Product product = null;
	        try
	        {
	            Connection conn = DBUtil.getcon();
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM product WHERE product_id = ?");
	            ps.setString(1, productId);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next())
	            {
	                product = new Product(rs.getString("product_id"), rs.getString("product_name"), rs.getInt("product_price"));
	            }
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        return product;
	    }
}
