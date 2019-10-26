package springboot.nacaneta.controller;

import org.junit.Test;

import junit.framework.TestCase;

public class ControllerTest extends TestCase {
	
	@Test
	public void testregisterCotacaoVazioTodos() {
		String valor = "";
		String lista = "";
		String loja = "";
		boolean esperado = false;
		
		boolean resultado = Controller.addCotacao(valor, lista, loja);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testregisterCotacaoVazioValor() {
		String valor = "";
		String lista = "1";
		String loja = "1";
		boolean esperado = false;
		
		boolean resultado = Controller.addCotacao(valor, lista, loja);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testregisterCotacaoVazioLista() {
		String valor = "200";
		String lista = "";
		String loja = "1";
		boolean esperado = false;
		
		boolean resultado = Controller.addCotacao(valor, lista, loja);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testregisterCotacaoVazioLoja() {
		String valor = "200";
		String lista = "1";
		String loja = "";
		boolean esperado = false;
		
		boolean resultado = Controller.addCotacao(valor, lista, loja);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testregisterCotacaoVazioValorELista() {
		String valor = "";
		String lista = "";
		String loja = "1";
		boolean esperado = false;
		
		boolean resultado = Controller.addCotacao(valor, lista, loja);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testregisterCotacaoInvalidoTodos() {
		String valor = "Abcd";
		String lista = "dada";
		String loja = "fsdfs";
		boolean esperado = false;
		
		boolean resultado = Controller.addCotacao(valor, lista, loja);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testregisterCotacaoInvalidoValor() {
		String valor = "-200";
		String lista = "1";
		String loja = "1";
		boolean esperado = false;
		
		boolean resultado = Controller.addCotacao(valor, lista, loja);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testregisterCotacaoInvalidoLista() {
		String valor = "200";
		String lista = "-10";
		String loja = "1";
		boolean esperado = false;
		
		boolean resultado = Controller.addCotacao(valor, lista, loja);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testregisterCotacaoInvalidoLoja() {
		String valor = "200";
		String lista = "1";
		String loja = "fsdfs";
		boolean esperado = false;
		
		boolean resultado = Controller.addCotacao(valor, lista, loja);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testregisterCotacaoInvalidoValorELoja() {
		String valor = "10000000000";
		String lista = "1";
		String loja = "1&";
		boolean esperado = false;
		
		boolean resultado = Controller.addCotacao(valor, lista, loja);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testregisterCotacaoValido1() {
		String valor = "200";
		String lista = "1";
		String loja = "1";
		boolean esperado = true;
		
		boolean resultado = Controller.addCotacao(valor, lista, loja);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testregisterCotacaoValido2() {
		String valor = "100";
		String lista = "2";
		String loja = "3";
		boolean esperado = true;
		
		boolean resultado = Controller.addCotacao(valor, lista, loja);
		
		assertEquals(esperado, resultado);
	}

}
