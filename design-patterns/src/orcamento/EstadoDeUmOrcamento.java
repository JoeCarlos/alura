package orcamento;

public interface EstadoDeUmOrcamento {

	void aplicaDescontosExtras(Orcamento orcamento);
    void aprova(Orcamento orcamento);
    void reprova(Orcamento orcamento);
    void finaliza(Orcamento orcamento);
}
