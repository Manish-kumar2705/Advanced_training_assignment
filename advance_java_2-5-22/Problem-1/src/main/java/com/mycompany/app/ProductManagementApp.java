package com.mycompany.app;

import java.util.List;
import java.util.Scanner;

import com.mycompany.dao.ProductDAO;
import com.mycompany.domain.Product;

public class ProductManagementApp {
	
	 static ProductDAO dao = new  ProductDAO();
	 static Scanner sc = new Scanner(System.in);
	 
	public static void main(String[] args) throws Exception {
			int option = 0;
	        do
	        {	
	            System.out.println("1. View Products");
	            System.out.println("2. Add Product");
	            System.out.println("3. Update Product");
	            System.out.println("4. Delete Product");
	            System.out.println("5. Search Product");
	            System.out.println("6. Exit");
	            System.out.println("===========================================");
	            System.out.println("Enter an option");
	            System.out.println("===========================================");
	            option = sc.nextInt();
	            sc.nextLine();
	         

	            switch(option)
	            {
	                case 1:
	                    viewProducts();
	                    break;

	                case 2:
	                	addProduct();
	                    break;

	                case 3:
	                    updateProduct();
	                    break;

	                case 4:
	                    deleteProduct();
	                    break;

	                case 5:
	                    searchProduct();
	                    break;

	                case 6:
	                    System.out.println("******************************THANK YOU********************");
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid Option! Please enter again");
	                    break;
	            }
	        }while(option!=6);
	    }
	    public static void viewProducts()
	    {
	        System.out.println("-----------------------------------------------");

	        //get all the product from the dao getallProducts() method and store
	        //them to a Product type productList
	        List<Product> productList = dao.getAllProducts();
	        for(Product product: productList)
	        {
	            //display product one by one
	            displayProduct(product);
	        }
	        System.out.println("-----------------------------------------------");
	        System.out.println("\n");

	    }

	    public static void addProduct() throws Exception
	    {
	        System.out.println("------------------------------------------------");
	        System.out.println("Enter Product ID:");
	        System.out.println("------------------------------------------------");
	        String productId = sc.nextLine();
	        System.out.println("------------------------------------------------");
	        System.out.println("Enter Product Name:");
	        System.out.println("------------------------------------------------");
	        String productName = sc.nextLine();
	        System.out.println("------------------------------------------------");
	        System.out.println("Enter Product Price:");
	        System.out.println("------------------------------------------------");
	        int productPrice = sc.nextInt();sc.nextLine();
	        //after user enters values, store them in a Product variable
	        Product product = new Product(productId, productName,productPrice);
	        boolean status = dao.AddProduct(product);
	        if(status)
	        {
	            System.out.println("Product added successfully");
	        }
	        else
	        {
	            System.out.println("ERROR while adding product");
	        }
	        System.out.println("\n");
	    }

	   
	    public static void updateProduct() throws Exception
	    {
	        System.out.println("------------------------------------------------");
	        System.out.println("Enter Product ID:");
	        System.out.println("------------------------------------------------");
	        String productId = sc.nextLine();
	        System.out.println("------------------------------------------------");
	        System.out.println("Enter New Product Name:");
	        System.out.println("------------------------------------------------");
	        String productName = sc.nextLine();
	        System.out.println("------------------------------------------------");
	        System.out.println("Enter New Product Price:");
	        System.out.println("------------------------------------------------");
	        int productPrice = sc.nextInt(); sc.nextLine();
	      
	        Product product = new Product(productId, productName,productPrice);
	        int status = dao.updateProduct(product);
	        if(status ==1 )
	        {
	            System.out.println("Product updated successfully");
	        }
	        else
	        {
	            System.out.println("ERROR while updating product");
	        }
	        System.out.println("\n");

	    }

	    public static void deleteProduct() throws Exception
	    {
	        System.out.println("------------------------------------------------");
	        System.out.println("Enter Product ID:");
	        System.out.println("------------------------------------------------");
	        String productId = sc.nextLine();
	        int status = dao.deleteProduct(productId);
	        if(status == 1 )
	        {
	            System.out.println("Product deleted successfully");
	        }
	        else
	        {
	            System.out.println("ERROR while deleting product");
	        }
	        System.out.println("\n");

	    }

	    //ask user for productId and use dao method to display product
	    public static void searchProduct() throws Exception
	    {
	        System.out.println("------------------------------------------------");
	        System.out.println("Enter Product ID:");
	        System.out.println("------------------------------------------------");
	        String productId = sc.nextLine();
	        Product product = dao.getProductByid(productId);
	        displayProduct(product);
	        System.out.println("\n");
	    }

	    public static void displayProduct(Product product)
	    {
	        System.out.println("Product ID: "+product.getProductId());
	        System.out.println("Product Name: "+product.getProductName());
	        System.out.println("Product Price: "+product.getProductPrice());
	        System.out.println("\n");
	    }

	}


