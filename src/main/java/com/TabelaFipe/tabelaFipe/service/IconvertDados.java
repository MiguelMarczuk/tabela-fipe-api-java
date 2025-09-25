package com.TabelaFipe.tabelaFipe.service;

import java.util.List;

public interface IconvertDados {
    <T>T  obterDados(String json, Class<T> classe);

    <T> List<T> obterLista(String json, Class<T> classe);
}
