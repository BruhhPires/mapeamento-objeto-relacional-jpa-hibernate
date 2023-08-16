package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com"); // ID NULO, PRO PROPRIO BD ATRIBUIR O VALOR DE ID
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

		// ESSA INSTANCIAÇÃO GARANTE A CONEXÃO COM O BANCO DE DADOS E TODOS O CONTEXTO DE PERSITENCIA IMPLEMENTADO
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		// QUANDO O JPA FAZ UMA OPERAÇÃO QUE NÃO É UMA SIMPLES LEITURA, ELE PRECISA DE UMA TRANSAÇÃO.
		em.getTransaction().begin(); // INICIA A TRANSAÇÃO
		
		em.persist(p1); // OPERAÇÃO DE INCLUSÃO DE DADOS NO BD
		em.persist(p2); // OPERAÇÃO DE INCLUSÃO DE DADOS NO BD
		em.persist(p3); // OPERAÇÃO DE INCLUSÃO DE DADOS NO BD
		
		em.getTransaction().commit(); // CONFIRMA AS ALTERAÇÕES
		System.out.println("Pronto!");

	}

}
