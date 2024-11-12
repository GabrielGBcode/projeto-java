package comportamento.funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class CadastroFuncionario {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private int numeroResidencia;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private boolean sexo;
    private LocalDate dataNascimento;
    private int quantidadeServicos;

    private static final String FILE_PATH = "src/estrutura/data/funcionario.txt";

    private boolean existeFuncionario(String cpf) {
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

    public String cadastrarFuncionario(String nome, String cpf, String email, String telefone, String endereco,
            int numeroResidencia, String bairro,
            String cidade, String estado, String pais, boolean sexo, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.bairro = bairro;
        this.numeroResidencia = numeroResidencia;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.quantidadeServicos = 0;

        if (existeFuncionario(cpf)) {
            return ("Funcionario com CPF \"" + cpf + "\" já cadastrado.");
        }

        try {
            String sexoStr = this.sexo ? "Masculino" : "Feminino";
            quantidadeServicos = 0;
            FileWriter arquivo = new FileWriter(FILE_PATH, true);
            try (PrintWriter escritor = new PrintWriter(arquivo)) {
                escritor.println(
                        this.nome + "," + this.cpf + "," + this.email + "," + this.telefone + "," + this.endereco + ","
                                + this.numeroResidencia + "," + this.bairro + "," + this.cidade + "," + this.estado
                                + "," + this.pais + ","
                                + sexoStr + "," + this.dataNascimento + "," + this.quantidadeServicos);
            } finally {
                arquivo.close();
            }
            return ("Funcionario cadastrado com sucesso");
        } catch (IOException e) {
            return ("Erro ao gravar arquivo");
        }
    }
}
