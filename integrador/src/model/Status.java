package model;


public enum Status {

    ATIVA("Ativa"),

    INATIVA("Inativa");


    private final String descricao;


    Status(String descricao) {

        this.descricao = descricao;

    }


    public String getDescricao() {

        return descricao;

    }

}