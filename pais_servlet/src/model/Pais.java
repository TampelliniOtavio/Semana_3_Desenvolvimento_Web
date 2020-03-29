package model;

public class Pais {
	private int id;
	private String nome;
	private long populacao;
	private double area;
	
	public Pais() {
		
	}
	
	public Pais(int id, String nome, long populacao, double area) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	
	public long getPopulacao() {
		return populacao;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	
	public double getArea() {
		return area;
	}
	
	
	
	
}
