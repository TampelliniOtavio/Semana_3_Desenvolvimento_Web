package service;

import java.util.ArrayList;

import dao.PaisDAO;
import model.Pais;

public class PaisService {
	private PaisDAO paisDAO;
	
	public PaisService() {
		paisDAO = new PaisDAO();
	}
	
	public int inserir(Pais pais) {
		return paisDAO.inserir(pais);		
	}
	
	public void alterar(Pais pais) {
		paisDAO.alterar(pais);
	}
	
	public void deletar(int id) {
		paisDAO.deletar(id);
	}
	
	public void deletar(Pais pais) {
		paisDAO.deletar(pais);
	}
	
	public Pais consultar(int id) {
		return paisDAO.consultar(id);
	}
	
	public Pais consultar(Pais pais) {
		return paisDAO.consultar(pais);
	}
	
	public long maiorPopulacao() {
		return paisDAO.maiorPopulacao();
	}
	
	public double menorArea() {
		return paisDAO.menorArea();
	}
	
	public ArrayList<Pais> vetorTresPaises(int[] id){
		return paisDAO.vetorTresPaises(id);
	}
	
	
}
