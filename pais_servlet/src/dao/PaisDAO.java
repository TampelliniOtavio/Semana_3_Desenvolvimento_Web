package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pais;

public class PaisDAO {
	private ConnectionFactory c;
	public PaisDAO() {
		c = new ConnectionFactory();
	}
	
	
	public int inserir(Pais pais) {
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					pais.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pais.getId();
	}
	
	public void alterar(Pais pais) {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.setInt(4, pais.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(Pais pais) {
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, pais.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deletar(int id) {
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Pais consultar(Pais pais) {
		Pais p = new Pais();
		p.setId(pais.getId());
		String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE pais.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, p.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					p.setNome(rs.getString("nome"));
					p.setPopulacao(rs.getLong("populacao"));
					p.setArea(rs.getDouble("area"));
				} else {
					p.setId(-1);
					p.setNome(null);
					p.setPopulacao(0);
					p.setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return p;
	}
	public Pais consultar(int id) {
		Pais p = new Pais();
		p.setId(id);
		String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE pais.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, p.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					p.setNome(rs.getString("nome"));
					p.setPopulacao(rs.getLong("populacao"));
					p.setArea(rs.getDouble("area"));
				} else {
					p.setId(-1);
					p.setNome(null);
					p.setPopulacao(0);
					p.setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return p;
	}
	
	public long maiorPopulacao() {
		Pais pais = new Pais();
		String sqlSelect = "SELECT max(populacao) as populacao FROM pais";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					pais.setPopulacao(rs.getLong("populacao"));
				} else {
					pais.setPopulacao(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais.getPopulacao();
	}
	
	public double menorArea() {
		Pais pais = new Pais();
		String sqlSelect = "SELECT min(area) as area FROM pais";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					pais.setArea(rs.getDouble("area"));
				} else {
					pais.setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais.getArea();
	}
	public ArrayList<Pais> vetorTresPaises(int[] id){
		ArrayList<Pais> p = new ArrayList<Pais>();
		for(int i = 0; i < 3; i++) {
			Pais pp = new Pais();
			pp.setId(id[i]);
			String sqlSelect = "SELECT * FROM pais where pais.id= ? ";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = c.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, pp.getId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						pp.setId(id[i]);
						pp.setNome(rs.getString("nome"));
						pp.setPopulacao(rs.getLong("populacao"));
						pp.setArea(rs.getDouble("area"));
						p.add(pp);
					} else {
						pp.setId(-1);
						pp.setNome(null);
						pp.setPopulacao(0);
						pp.setArea(0);
						p.add(pp);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		}
		return p;
	}
}
