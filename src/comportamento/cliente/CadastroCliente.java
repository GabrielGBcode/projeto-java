package comportamento.cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class CadastroCliente {
    private static final String FILE_PATH = "src/estrutura/data/cliente.txt";

    public static boolean existeCliente(String cpf) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length > 1 && dados[1].trim().equals(cpf)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return false;
    }

    public String cadastrarCliente(String nome, String cpf, String email, String telefone, String endereco,
            int numeroResidencia, String bairro, String cidade, String estado, String pais, boolean sexo,
            LocalDate dataNascimento) {

        if (existeCliente(cpf)) {
            return "Cliente com CPF \"" + cpf + "\" já cadastrado.";
        }

        try {
            String sexoStr = sexo ? "Masculino" : "Feminino";
            int quantidadeServicos = 0; // ou inicialize com um valor apropriado
            FileWriter arquivo = new FileWriter(FILE_PATH, true);
            try (PrintWriter escritor = new PrintWriter(arquivo)) {
                escritor.println(
                        nome + "," + cpf + "," + email + "," + telefone + "," + endereco + ","
                                + numeroResidencia + "," + bairro + "," + cidade + "," + estado
                                + "," + pais + "," + sexoStr + "," + dataNascimento + "," + quantidadeServicos);
            }
            return "Cliente cadastrado com sucesso";
        } catch (IOException e) {
            return "Erro ao gravar arquivo: " + e.getMessage();
        }
    }
}
