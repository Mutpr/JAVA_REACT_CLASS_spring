package com.spring.cafe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.spring.cafe.DTO.CafeDTO;

public class CafeDAO {
    private static CafeDAO instance;

    public static synchronized CafeDAO getInstance() {
        if (instance == null) {
            instance = new CafeDAO();
        }
        return instance;
    }
	
    
    private Connection getConnection() throws Exception {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
        return ds.getConnection();
    }

    private CafeDAO() {}

    public List<CafeDTO> selectAllMenu() throws Exception{
    	CafeDTO cafeMenu = new CafeDTO();
    	List<CafeDTO> cafeMenuList = new ArrayList<>();
    	String selectAllMenuSQL = "select * from Cafe";
    	try(Connection conn = this.getConnection(); 
    			PreparedStatement pstmt = conn.prepareStatement(selectAllMenuSQL);
    			ResultSet rs = pstmt.executeQuery();){
    		while(rs.next()) {
    			int id = rs.getInt("id");
    			String pname = rs.getString("pname");
    			int price = rs.getInt("price");
    			cafeMenu = new CafeDTO(id, pname, price);
    			cafeMenuList.add(cafeMenu);
    		}

    	}return cafeMenuList;
    }
    
    public void insertMenu(CafeDTO cafeMenu) throws Exception {
    	int result = 0;
    	String inserMenuSQL = "insert into cafe values(cafe_sequence.nextVal, ?, ?)";
    	try(Connection conn = this.getConnection();
    			PreparedStatement pstmt = conn.prepareStatement(inserMenuSQL);){
    		pstmt.setString(1, cafeMenu.getPname());
    		pstmt.setInt(2, cafeMenu.getPrice());
    		result = pstmt.executeUpdate();
    		System.out.println(result);
    	}
    }
    
    public void deleteMenu(int cafeMenuSeq) throws Exception{
    	int result = 0;
    	String deleteMenuSQL = "delete from cafe where id = ?";
    	try(Connection conn = this.getConnection();
    			PreparedStatement pstmt = conn.prepareStatement(deleteMenuSQL);){
    		pstmt.setInt(1, cafeMenuSeq);
    		result = pstmt.executeUpdate();
    		System.out.println(result);
    	}
    }
	
}
