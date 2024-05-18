package com.gumaso.Screentify.models;

public enum TipoFormacao {
    SOLO("solo"),
    DUPLA("dupla"),
    GRUPO("grupo"),
    ;
    private String tipoFormacao;
    TipoFormacao(String tipoFormacao) {
        this.tipoFormacao = tipoFormacao;
    }
    public static TipoFormacao fromString(String tipo){
        for (TipoFormacao tipoFormacao1: TipoFormacao.values()){
            if (tipo.equalsIgnoreCase(tipoFormacao1.tipoFormacao)){
                return tipoFormacao1;
            }
        }
        throw new IllegalArgumentException("Valor inválido");

    }
}
