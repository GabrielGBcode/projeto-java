package comportamento.estoque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaEstoque {
    private static final String FILE_PATH = "src/estrutura/data/estoque.txt";

    public String consultarEstoque(int id) {
        StringBuilder estoqueInfo = new StringBuilder();
        try {
            boolean encontrado;
            try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
                String linha;
                encontrado = false;
                while ((linha = leitor.readLine()) != null) {
                    String[] dados = linha.split("-");
                    if (dados[0].trim().equals(String.valueOf(id))) {
                        estoqueInfo.append("Item encontrado:\n")
                                .append("ID: ").append(dados[0].trim()).append("\n")
                                .append("Nome: ").append(dados[1].trim()).append("\n")
                                .append("Quantidade: ").append(dados[2].trim());
                        encontrado = true;
                        break;
                    }
                }
            }

            if (!encontrado) {
                return "Item com ID " + id + " não encontrado.";
            }
        } catch (IOException e) {
            return "Erro ao ler o arquivo." + e.getMessage();
        }
        return estoqueInfo.toString();
    }
}
