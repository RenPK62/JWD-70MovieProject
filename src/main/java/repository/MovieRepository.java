package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.MovieBean;

public class MovieRepository {

	public List<MovieBean> getMoviesByCatId(int categoryId){
		List<MovieBean> movieList = new ArrayList<MovieBean>();
		
		String sql = "SELECT * FROM movie.movie where category_id=?;";
		
		 try ( Connection con = DBConnection.getConnection();
				   PreparedStatement ps = con.prepareStatement(sql);)
		    	{
			 
			 ps.setInt(1, categoryId);
			 
		      ResultSet rs=ps.executeQuery();
		      while (rs.next()) {
		    	  
		    	  MovieBean obj = new MovieBean();
		    	  obj.setId(rs.getInt("id"));
		    	  obj.setTitle(rs.getString("title"));
		    	  obj.setDescription(rs.getString("summary"));
		    	  obj.setDuration(rs.getString("duration"));
		    	  obj.setReleaseYear(rs.getDate("release_year").toLocalDate());
		    	  obj.setCategoryId(rs.getInt("category_id"));
		    	  
		    	 
		    	  movieList.add(obj);
		      }
		    } catch(SQLException e) {
	System.out.println("category list error : " + e.getMessage());
}
		 return movieList;
	}
	
	public int rentMovie(int member_id, int movie_id) {
		int i = 0;
		String sql = "insert into movie_rented (member_id,movie_id) values(?,?)";
	
	 try ( Connection con = DBConnection.getConnection();
			   PreparedStatement ps = con.prepareStatement(sql)){
	      
		   ps.setInt(1, member_id);
		   ps.setInt(2, movie_id);
		   
		   i=ps.executeUpdate();
		   
		   
			}catch (SQLException e) {
				System.out.println("movie rented error : " + e.getMessage());
			}
	 return i;
		}
}
