package main.presentation.warehouse;

import java.sql.SQLException;

import entities.Warehouse;
import persistence.DAOJDBC.WarehouseDAO;

public class GetAllWarehouses {

	public static void getAll() throws SQLException {
		WarehouseDAO warehouseDAO = new WarehouseDAO();
		
		for(Warehouse warehouse : warehouseDAO.readAll()) {
			System.out.println(warehouse);
		}
		
		System.out.println();
	}

}
