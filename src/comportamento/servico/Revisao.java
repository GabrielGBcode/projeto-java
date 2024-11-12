package comportamento.servico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Revisao {

    public void removerItemEstoque(int... ids) {
        List<String> linhas = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader("src/estrutura/data/estoque.txt"))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split("-");
                boolean itemAtualizado = false;

                for (int id : ids) {
                    if (dados[0].trim().equals(String.valueOf(id))) {
                        int valor = Integer.parseInt(dados[2].trim()) - 1;
                        String novaLinha = String.join(" - ", dados[0].trim(), dados[1].trim(), String.valueOf(valor));
                        linhas.add(novaLinha);
                        itemAtualizado = true;
                        break;
                    }
                }

                if (!itemAtualizado) {
                    linhas.add(linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        try (PrintWriter escritor = new PrintWriter(new FileWriter("src/estrutura/data/estoque.txt"))) {
            for (String linha2 : linhas) {
                escritor.println(linha2);
            }
            System.out.println("Itens removidos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static final String FILE_PATH = "src/estrutura/data/orcamento.txt";

    public boolean orcamentoEncontrado(int id) {
        boolean encontrado = false;
        try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[0].trim().equals(String.valueOf(id))) {
                    encontrado = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return encontrado;
    }

    public void aprovarOrcamento(int id) {
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;
        try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[0].trim().equals(String.valueOf(id))) {
                    String novaLinha = String.join(",", String.valueOf(id), dados[1], dados[2], dados[3], dados[4],
                            dados[5], dados[6], dados[7], "true");
                    linhas.add(novaLinha);
                    System.out.println("Orçamento aprovado com sucesso!");
                    encontrado = true;
                } else {
                    linhas.add(linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        if (encontrado) {
            try (PrintWriter escritor = new PrintWriter(new FileWriter(FILE_PATH))) {
                for (String linha : linhas) {
                    escritor.println(linha);
                }
            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Orçamento com ID \"" + id + "\" não encontrado.");
        }
    }

    public String realizarServico(int id) {
        double preco = 0;
        StringBuilder servico = new StringBuilder();
        try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[0].trim().equals(String.valueOf(id))) {
                    if (dados[8].trim().equals("true")) {
                        if (dados[1].trim().equals("true")) {
                            preco += 340.00;
                            removerItemEstoque(1, 2, 3, 4, 5);
                            servico.append(
                                    "Itens utilizados: Óleo de motor, Filtro de óleo, Filtro de ar, Filtro de combustível e Filtro de cabine\n");
                        }
                        if (dados[2].trim().equals("true")) {
                            preco += 495.00;
                            removerItemEstoque(6, 7, 8);
                            servico.append("Itens utilizados: Pastilha, Disco, Fluido de freio e Fluido de freio\n");
                        }
                        if (dados[3].trim().equals("true")) {
                            preco += 825.00;
                            removerItemEstoque(9, 10, 11, 12);
                            servico.append("Itens utilizados: Amotecedor, molas, buchas, pivôs\n");
                        }
                        if (dados[4].trim().equals("true")) {
                            preco += 290.00;
                            removerItemEstoque(13, 14, 15, 16);
                            servico.append("Itens utilizados: Bateria, Alternador, motor de arranque, iluminação\n");
                        }
                        if (dados[5].trim().equals("true")) {
                            preco += 360.00;
                            removerItemEstoque(17);
                            servico.append("Limpeza dos blocos e verificação dos sensores\n");
                        }
                        if (dados[6].trim().equals("true")) {
                            preco += 180.00;
                            servico.append("Alinhamento e balanceamento das rodas\n");
                        }
                        if ("true".equals(dados[1]) && "true".equals(dados[2]) && "true".equals(dados[3])
                                && "true".equals(dados[4])
                                && "true".equals(dados[5]) && dados[6].equals("true")) {
                            preco = 2241.00;
                        }
                    } else {
                        return ("Orçamento com ID \"" + id + "\" não aprovado!");
                    }
                }
            }
            if (!orcamentoEncontrado(id)) {
                return ("Orçamento com ID \"" + id + "\" não encontrado.");
            }
        } catch (IOException e) {
            return ("Erro ao ler o arquivo: " + e.getMessage());
        }
        return (servico.toString() + "\n" +
                "Preco: " + preco);
    }
}
