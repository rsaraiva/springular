package com.rsaraiva.labs.springular.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rsaraiva.labs.springular.ConnectionFactory;

@Controller
public class InfraController {

	@RequestMapping("/createTables")
	public String criaBanco() throws SQLException {
		Connection c = new ConnectionFactory().getConnection();
		
		c.prepareStatement("drop table if exists product").execute();
		
		c.prepareStatement("create table product (id int identity, description varchar(255))").execute();
		
		c.close();
		
		return "infra/ok";

	}
}
