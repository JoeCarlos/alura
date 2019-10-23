package br.com.solid.acoplamento;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import org.mockito.*;



public class ProgramaTest {
	
	
	
//	@Test
//	public void teste(){
//		NotaFiscalDao nfDao = new NotaFiscalDao();
//		List<AcaoAposGerarNotaFiscal> acoes = new ArrayList<AcaoAposGerarNotaFiscal>();
//		acoes.add(nfDao);
//		Fatura fatura = new Fatura(5000, "Joe");
//		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes);
//		gerador.gera(fatura);
//	}
	
	@Test
	public void NotaDaoTest() {
		NotaFiscalDao nfDao = Mockito.mock(NotaFiscalDao.class);
		List<AcaoAposGerarNotaFiscal> acoes = new ArrayList<AcaoAposGerarNotaFiscal>();
		acoes.add(nfDao);
		GeradorDeNotaFiscal gNF = new GeradorDeNotaFiscal(new ArrayList<AcaoAposGerarNotaFiscal>(acoes));
		
		Fatura fatura = new Fatura(5000, "Joe");
		NotaFiscal nf = gNF.gera(fatura);
		
		
	//	Mockito.verify(gNF,  Mockito.times(1)).gera(fatura);
		Mockito.verify(nfDao, Mockito.times(1)).executa(nf);
	}
	
}
