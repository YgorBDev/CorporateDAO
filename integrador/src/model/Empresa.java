package model;

public class Empresa {        
	    private String nomeEmpresa;    
	    private String cnpj;          
	    private String lugar;         
	    private String dataCriacao;      
	    private double lucroBruto;    
	    private double lucroLiquido;   
	    private double imposto;       
	    private int qtdeFuncionario;   
	    private Status status; 

public Empresa(String nomeEmpresa, String cnpj, String lugar, String dataCriacao,double lucroBruto, double lucroLiquido, double imposto, int qtdeFuncionario, Status status) {
	
	        this.nomeEmpresa = nomeEmpresa;
	        this.cnpj = cnpj;
	        this.lugar = lugar;
	        this.dataCriacao = dataCriacao;
	        this.lucroBruto = lucroBruto;
	        this.lucroLiquido = lucroLiquido;
	        this.imposto = imposto;
	        this.qtdeFuncionario = qtdeFuncionario;
	        this.status = status;

	    }

		public String getNomeEmpresa() {
	        return nomeEmpresa;
	    }

	    public void setNomeEmpresa(String nomeEmpresa) {
	        this.nomeEmpresa = nomeEmpresa;
	    }

	    public String getCnpj() {
	        return cnpj;
	    }

	    public void setCnpj(String cnpj) {
	        this.cnpj = cnpj;
	    }

	    public String getLugar() {
	        return lugar;
	    }

	    public void setLugar(String lugar) {
	        this.lugar = lugar;
	    }

	    public String getDataCriacao() {
	        return dataCriacao;
	    }
	    
	    public void setDataCriacao(String dataCriacao) {
	        this.dataCriacao = dataCriacao;
	    }

	    public double getLucroBruto() {
	        return lucroBruto;
	    }

	    public void setLucroBruto(double lucroBruto) {
	        this.lucroBruto = lucroBruto;
	    }

	    public double getLucroLiquido() {
	        return lucroLiquido;
	    }

	    public void setLucroLiquido(double lucroLiquido) {
	        this.lucroLiquido = lucroLiquido;
	    }

	    public double getImposto() {
	       return imposto;
	    }

	    public void setImposto(double imposto) {
	        this.imposto = imposto;
	    }
	    
	    public int getQtdeFuncionario() {
	        return qtdeFuncionario;
	    }

	    public void setQtdeFuncionario(int qtdeFuncionario) {
	        this.qtdeFuncionario = qtdeFuncionario;
	    }

	    public Status getStatus() {
	        return status;

	    }

	    public void setStatus(Status status) {
	        this.status = status;

	    }

	}

