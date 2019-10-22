package br.com.solid.coesao;
import java.util.Calendar;

public class Funcionario {

    public Funcionario(int id, String nome, Cargo cargo, Calendar dataDeAdmissao, double salarioBase) {
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.dataDeAdmissao = dataDeAdmissao;
		this.salarioBase = salarioBase;
	}
    
    
	private int id;
    private String nome;
    private Cargo cargo;
    private Calendar dataDeAdmissao;
    private double salarioBase;
    
    
    
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public Cargo getCargo() {
        return cargo;
    }
    public Calendar getDataDeAdmissao() {
        return dataDeAdmissao;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public void setDataDeAdmissao(Calendar dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
	public double calculaSalario() {
		return cargo.getRegra().calcular(this);
	
	}
    
    

}