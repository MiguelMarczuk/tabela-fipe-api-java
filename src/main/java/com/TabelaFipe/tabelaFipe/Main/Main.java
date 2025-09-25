package com.TabelaFipe.tabelaFipe.Main;

import com.TabelaFipe.tabelaFipe.model.Dados;
import com.TabelaFipe.tabelaFipe.model.Modelos;
import com.TabelaFipe.tabelaFipe.model.Veiculos;
import com.TabelaFipe.tabelaFipe.service.ConsumoApi;
import com.TabelaFipe.tabelaFipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
   private Scanner leitor ;
  private   ConsumoApi consumoApi ;
   private ConverteDados converteDados ;
   private  String endereco;


    public Main() {
        this.leitor = new Scanner(System.in);
        this.consumoApi = new ConsumoApi();
        this.converteDados = new ConverteDados();
        this.endereco = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
    }

    public void menu(){


        var json =  consumoApi.ObterDados(endereco);


        var marcas = converteDados.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(m -> m.codigo()))
                .forEach(System.out::println);


        System.out.println("codigo da marca que voce quer consultar");
        String codigoMarca = leitor.nextLine();
        endereco = endereco + "/"+ codigoMarca + "/modelos";
        json= consumoApi.ObterDados(endereco);

        var modelosList = converteDados.obterDados(json, Modelos.class);
        System.out.println("\n modelos dessa marca: ");

        modelosList.modelos().stream()
                .sorted(Comparator.comparing(m-> m.codigo()))
                .forEach(System.out::println);


        System.out.println("digite um trecho do carro que vc gostaria de pesquisar");
        String carroEscolhido = leitor.nextLine();

        modelosList.modelos().stream()
                .filter(c -> c.nome().toLowerCase().contains(carroEscolhido.toLowerCase()))
                .peek(System.out::println)
                .sorted(Comparator.comparing(c-> c.nome()))
                .peek(System.out::println)
                .forEach(System.out::println);


        System.out.println("Digite o codigo do modelo para consultar Valores: ");

        String codigoModelo = leitor.nextLine();

        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumoApi.ObterDados(endereco);
        List<Dados> anos = converteDados.obterLista(json, Dados.class);
        List<Veiculos> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumoApi.ObterDados(enderecoAnos);
            Veiculos veiculo = converteDados.obterDados(json, Veiculos.class);
            veiculos.add(veiculo);
        }

        System.out.println("todos veiculos filtrados com avaliação por ano: ");
        veiculos.forEach(System.out::println);


    }
}
