package br.com.ucsal.olimpiadas.model;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados implements Repositorio {

    public static long proximoParticipanteId = 1;
    public static long proximaProvaId = 1;
    public static long proximaQuestaoId = 1;
    public static long proximaTentativaId = 1;

    public static final List<Participante> participantes = new ArrayList<>();
    public static final List<Prova> provas = new ArrayList<>();
    public static final List<Questao> questoes = new ArrayList<>();
    public static final List<Tentativa> tentativas = new ArrayList<>();

    @Override
    public void salvar(Object obj) {
        if (obj instanceof Participante) participantes.add((Participante) obj);
        else if (obj instanceof Prova) provas.add((Prova) obj);
        else if (obj instanceof Questao) questoes.add((Questao) obj);
        else if (obj instanceof Tentativa) tentativas.add((Tentativa) obj);
    }
}