package model;

public class Empresa {        
	    private String nomeEmpresa;    
	    private String cnpj;          
	    private String lugar;         
	    private String dataCriacao;      
	    private Double lucroBruto;    
	    private Double lucroLiquido;   
	    private Double imposto;       
	    private Double qtdeFuncionario;   
	    private Status status; 
	    
	    public Empresa(String nomeEmpresa, String cnpj, String lugar, String dataCriacao,Double lucroBruto, Double qtdeFuncionario, Status status) {
	    	
	        this.nomeEmpresa = nomeEmpresa;
	        this.cnpj = cnpj;
	        this.lugar = lugar;
	        this.dataCriacao = dataCriacao;
	        this.lucroBruto = lucroBruto;
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

	    public Double getLucroBruto() {
	        return lucroBruto;
	    }

	    public void setLucroBruto(Double lucroBruto) {
	        this.lucroBruto = lucroBruto;
	    }

	    public Double getLucroLiquido() {
	        return lucroLiquido;
	    }

	    public void setLucroLiquido(Double lucroLiquido) {
	        this.lucroLiquido = lucroLiquido;
	    }

	    public Double getImposto() {
	       return imposto;
	    }

	    public void setImposto(Double imposto) {
	        this.imposto = imposto;
	    }
	    
	    public Double getQtdeFuncionario() {
	        return qtdeFuncionario;
	    }

	    public void setQtdeFuncionario(Double qtdeFuncionario) {
	        this.qtdeFuncionario = qtdeFuncionario;
	    }

	    public Status getStatus() {
	        return status;

	    }

	    public void setStatus(Status status) {
	        this.status = status;

	    }

	}

