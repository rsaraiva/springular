package com.rsaraiva.labs.springular.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rsaraiva.labs.springular.ConnectionFactory;
import com.rsaraiva.labs.springular.model.Product;

public class ProductDAO {
	private Connection connection;

	public ProductDAO() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Product product) {
		String sql = "insert into product (description) values (?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, product.getDescription());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Product product) {

		if (product.getId() == null) {
			throw new IllegalStateException("Id nao pode ser nulo.");
		}

		String sql = "delete from product where id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, product.getId());
			stmt.execute();
			
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Product product) {
		String sql = "update product set description = ? where id = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, product.getDescription());
			stmt.setLong(2, product.getId());
			stmt.execute();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Product> lista() {
		try {
			List<Product> products = new ArrayList<Product>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from product");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				products.add(fillProduct(rs));
			}

			rs.close();
			stmt.close();
			connection.close();

			return products;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Product buscaPorId(Integer id) {
		
		if (id == null) {
			throw new IllegalStateException("Id nao pode ser nulo.");
		}

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from product where id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				connection.close();
				return fillProduct(rs);
			}

			rs.close();
			stmt.close();

			connection.close();
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Product fillProduct(ResultSet rs) throws SQLException {
		return new Product(rs.getInt("id"), rs.getString("description"));
	}
}
