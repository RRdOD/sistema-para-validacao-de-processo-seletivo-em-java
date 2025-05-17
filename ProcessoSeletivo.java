package candidatura;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("=== PROCESSO SELETIVO ===");
        
        // Análise individual de candidatos
        analisarCandidato(1900.0);
        analisarCandidato(2000.0);
        analisarCandidato(2100.0);
        
        // Seleção de candidatos
        List<String> candidatosSelecionados = selecaoCandidatos();
        
        // Impressão da lista de selecionados
        imprimirSelecionados(candidatosSelecionados);
        
        // Tentativa de contato com os selecionados
        for (String candidato : candidatosSelecionados) {
            entrarEmContato(candidato);
        }
    }
    
    // Método para analisar um candidato individualmente
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        
        System.out.println("\nAnalisando candidato com pretensão salarial de R$" + salarioPretendido);
        
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
    
    // Método para selecionar candidatos
    static List<String> selecaoCandidatos() {
        String[] candidatos = {"FELIPE", "MÁRCIA", "JÚLIA", "PAULO", "AUGUSTO", 
                              "MÔNICA", "FABRÍCIO", "MIRELA", "DANIELA", "JORGE"};
        List<String> selecionados = new ArrayList<>();
        int vagasDisponiveis = 5;
        double salarioBase = 2000.0;
        
        System.out.println("\nIniciando seleção de candidatos...");
        
        for (String candidato : candidatos) {
            if (selecionados.size() >= vagasDisponiveis) {
                break;
            }
            
            double salarioPretendido = valorPretendido();
            System.out.println(candidato + " solicitou R$" + salarioPretendido);
            
            if (salarioBase >= salarioPretendido) {
                System.out.println("-> " + candidato + " foi selecionado para a vaga");
                selecionados.add(candidato);
            }
        }
        
        return selecionados;
    }
    
    // Método para gerar um valor de salário pretendido aleatório
    static double valorPretendido() {
        Random random = new Random();
        // Gera valores entre 1800 e 2200
        return 1800 + random.nextDouble() * 400;
    }
    
    // Método para imprimir a lista de selecionados
    static void imprimirSelecionados(List<String> candidatos) {
        System.out.println("\nLista de candidatos selecionados:");
        
        if (candidatos.isEmpty()) {
            System.out.println("Nenhum candidato foi selecionado.");
            return;
        }
        
        System.out.println("Forma tradicional com índice:");
        for (int i = 0; i < candidatos.size(); i++) {
            System.out.println((i+1) + "º - " + candidatos.get(i));
        }
        
        System.out.println("\nForma simplificada (for each):");
        for (String candidato : candidatos) {
            System.out.println("- " + candidato);
        }
    }
    
    // Método para simular tentativas de contato
    static void entrarEmContato(String candidato) {
        System.out.println("\nTentando contato com " + candidato + "...");
        
        int tentativas = 0;
        boolean atendeu = false;
        
        // Tentamos até 3 vezes ou até conseguir contato
        while (tentativas < 3 && !atendeu) {
            tentativas++;
            atendeu = tentarLigar(); // Simula uma tentativa de ligação
            
            if (atendeu) {
                System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativas + "ª TENTATIVA");
            } else if (tentativas < 3) {
                System.out.println("Não conseguimos contato na " + tentativas + "ª tentativa");
            } else {
                System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " APÓS " + tentativas + " TENTATIVAS");
            }
        }
    }
    
    // Método auxiliar para simular tentativa de ligação (30% de chance de atender)
    static boolean tentarLigar() {
        Random random = new Random();
        return random.nextDouble() < 0.3; // 30% de chance de retornar true
    }
}