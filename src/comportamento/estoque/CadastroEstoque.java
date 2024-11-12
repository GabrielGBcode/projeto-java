package comportamento.estoque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CadastroEstoque {
    private int id;

    private static final String FILE_PATH = "src/estrutura/data/estoque.txt";

    public static boolean existeItem(int id) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split("-");
                if (dados[0].trim().equals(String.valueOf(id))) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return false;
    }

    public String cadastrarEstoque(String nome, int quantidade) {
        int maiorID = 0;

        try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    String[] dados = linha.split("-");
                    if (dados.length > 0) {
                        try {
                            this.id = Integer.parseInt(dados[0].trim());
                            if (this.id > maiorID) {
                                maiorID = this.id;
                            }
                        } catch (NumberFormatException e) {
                            return ("Erro na formatação do ID: " + dados[0].trim());
                        }
                    }
                }
            }
            this.id = maiorID + 1;
        } catch (IOException e) {
            return ("Erro ao ler o arquivo: " + e.getMessage());
        }

        if (existeItem(this.id)) {
            return "Item com ID \"" + this.id + "\" já cadastrado no estoque!";
        }

        try {
            FileWriter arquivo = new FileWriter(FILE_PATH, true);
            try (PrintWriter escritor = new PrintWriter(arquivo)) {
                escritor.println(this.id + " - " + nome + " - " + quantidade);
            } finally {
                arquivo.close();
            }
            return "Item cadastrado com sucesso!";
        } catch (IOException e) {
            return "Erro ao gravar arquivo";
        }
    }
}
