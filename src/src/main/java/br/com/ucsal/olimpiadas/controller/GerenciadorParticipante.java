package br.com.ucsal.olimpiadas.controller;

import java.util.Scanner;

import br.com.ucsal.olimpiadas.model.BancoDeDados;
import br.com.ucsal.olimpiadas.model.Participante;
import br.com.ucsal.olimpiadas.model.Repositorio;

public class GerenciadorParticipante {

    private static final Scanner in = new Scanner(System.in);
    private static final Repositorio repositorio = new BancoDeDados();

    public static void cadastrarParticipante() {
        System.out.print("Nome: ");
        var nome = in.nextLine();

        System.out.print("Email (opcional): ");
        var email = in.nextLine();

        if (nome == null || nome.isBlank()) {
            System.out.println("nome inválido");
            return;
        }

        var p = new Participante();
        p.setId(BancoDeDados.proximoParticipanteId++);
        p.setNome(nome);
        p.setEmail(email);

        repositorio.salvar(p);
        System.out.println("Participante cadastrado: " + p.getId());
    }

    public static Long escolherParticipante() {
        System.out.println("\nParticipantes:");
        for (var p : BancoDeDados.participantes) {
            System.out.printf("  %d) %s%n", p.getId(), p.getNome());
        }
        System.out.print("Escolha o id do participante: ");

        try {
            long id = Long.parseLong(in.nextLine());
            boolean existe = BancoDeDados.participantes.stream().anyMatch(p -> p.getId() == id);
            if (!existe) {
                System.out.println("id inválido");
                return null;
            }
            return id;
        } catch (Exception e) {
            System.out.println("entrada inválida");
            return null;
        }
    }
}
