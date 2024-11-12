package comportamento.estoque;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EditarEstoque {
    private static final String FILE_PATH = "src/estrutura/data/estoque.txt";

    public String editarEstoque(int id, String nome, int quantidade) {
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split("-");
                if (dados[0].trim().equals(String.valueOf(id))) {
                    String novaLinha = String.join(" - ", String.valueOf(id), nome, String.valueOf(quantidade));
                    linhas.add(novaLinha);
                    encontrado = true;
                } else {
                    linhas.add(linha);
                }
            }
        } catch (IOException e) {
            return ("Erro ao ler o arquivo: " + e.getMessage());
        }

        if (encontrado) {
            try (PrintWriter escritor = new PrintWriter(new FileWriter(FILE_PATH))) {
                for (String linha : linhas) {
                    escritor.println(linha);
                }
                return ("Dados do Estoque atualizados com sucesso.");
            } catch (IOException e) {
                return ("Erro ao escrever no arquivo: " + e.getMessage());
            }
        } else {
            return ("Item com ID \"" + id + "\" não encontrado.");
        }
    }
}
