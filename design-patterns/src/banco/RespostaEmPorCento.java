package banco;

public class RespostaEmPorCento implements Resposta{

	private Resposta outraResposta;

//	public RespostaEmPorCento(Resposta outrResposta) {
//		this.outraResposta = outraResposta;
//}

	@Override
	public void responde(Requisicao req, Conta conta) {
		if (req.getFormato() == Formato.PORCENTO) {
			System.out.println(conta.getTitular() + '%' + conta.getSaldo());
		} else if (outraResposta != null) {
			outraResposta.responde(req, conta);
		} else {
			// não existe próxima na corrente, e ninguém atendeu a requisição!
			// poderíamos não ter feito nada aqui, caso não fosse necessário!
			throw new RuntimeException("Formato de resposta não encontrado");
		}
	}
	
	@Override
	public void setProxima(Resposta resposta) {
		this.outraResposta = resposta;
	}


}
