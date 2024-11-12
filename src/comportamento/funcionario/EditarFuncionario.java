package comportamento.funcionario;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EditarFuncionario {
    private static final String FILE_PATH = "src/estrutura/data/funcionario.txt";

    public String editarFuncionario(String cpf, String nome, String email, String telefone, String endereco,
            int numeroResidencia,
            String bairro, String cidade, String estado, String pais, boolean sexo, LocalDate dataNascimento) {
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length > 1 && dados[1].trim().equals(cpf)) {
                    String sexoStr = sexo ? "Masculino" : "Feminino";
                    String novaLinha = String.join(",",
                            nome, cpf, email, telefone, endereco, String.valueOf(numeroResidencia), bairro,
                            cidade, estado, pais, sexoStr, dataNascimento.toString(), dados[12]);
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
                return ("Dados do funcionário atualizados com sucesso.");
            } catch (IOException e) {
                return ("Erro ao escrever no arquivo: " + e.getMessage());
            }
        } else {
            return ("Funcionário com CPF \"" + cpf + "\" não encontrado.");
        }
    }
}
