package banco;

public class RepostaEmCsv implements Resposta{

	private Resposta outraResposta;
	
//	 public RepostaEmCsv(Resposta outraResposta) {
//		this.outraResposta = outraResposta;
//	}
	@Override
	public void responde(Requisicao req, Conta conta) {
		if (req.getFormato() == Formato.CSV) {
			System.out.println(conta.getTitular() + ", " + conta.getSaldo());
		}
		
	}
	@Override
	public void setProxima(Resposta resposta) {
		this.outraResposta = resposta;
	}

}
