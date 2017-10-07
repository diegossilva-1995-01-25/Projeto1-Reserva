package br.fatec.teste_unitario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.fatec.modelo.Empresa;
import br.fatec.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa {
	public static Empresa empresa;
	public static EmpresaDAO empresaDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}

	@After
	public void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}

	/**
	 *  CT01 - Cadastra com Sucesso
	 *  Objetivo: verificar o comportamento do sistema quando
	 *  cadastra com sucesso.
	 */
	@Test
	public void CT01_UC01CadastrarEmpresa_com_sucesso() {
		assertEquals(1, empresaDAO.adiciona(empresa));
	}
	
	/**
	 *  CT02 - Cadastra com CNPJ inv�lido
	 *  Objetivo: verificar o comportamento do sistema quando
	 *  se tenta cadastrar com um CNPJ inv�lido.
	 */
	@Test
	public void CT02_UC01A1CadastrarEmpresa_com_CNPJ_invalido() {
		assertEquals("CNPJ invalido.", empresa.setCnpj("121221"));
	}
	
	/**
	 *  CT03 - Cadastra com CNPJ j� cadastrado
	 *  Objetivo: verificar o comportamento do sistema quando
	 *  se tenta cadastrar com um CNPJ que j� existe na base
	 *  de dados sendo chave prim�ria.
	 *  Detalhe: N�o vai reclamar se n�o projetarmos valida��o
	 *  do cnpj digitado.
	 */
	@Test
	public void CT03_UC01A2CadastrarEmpresa_com_CNPJ_ja_cadastrado() {
		empresaDAO.adiciona(empresa);
		assertEquals(0, empresaDAO.adiciona(empresa));
	}

}
