package model;

import service.PaisService;

public class Teste {
	public static void main(String[] args) {
		Pais pais = new Pais();
		Pais[] p = new Pais[3];
		PaisService paisService = new PaisService();
		
		pais.setNome("Marrocos");
		pais.setPopulacao(35042582);
		pais.setArea(446550);
		System.out.println(paisService.inserir(pais));
		
		pais = paisService.consultar(12);
		System.out.println(pais.getNome());
		
		pais = paisService.consultar(12);
		pais.setNome("Marromos");
		paisService.alterar(pais);
		pais = paisService.consultar(12);
		System.out.println(pais.getNome());
		
		paisService.deletar(12);
		
		System.out.println(paisService.maiorPopulacao());
		
		System.out.println(paisService.menorArea());
		
		int[] id = {1,2,3};
		for (int i = 0; i < id.length; i++) {
			p[i] = paisService.vetorTresPaises(id).get(i);
			System.out.println(p[i].getNome());
		}
		
		}

	}

