package comportamento.cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaCliente {
    private static final String FILE_PATH = "src/estrutura/data/cliente.txt";

    public String consultarCliente(String cpf) {
        StringBuilder clienteInfo = new StringBuilder();

        try {
            boolean encontrado;
            try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
                String linha;
                encontrado = false;
                while ((linha = leitor.readLine()) != null) {
                    String[] dados = linha.split(",");
                    if (dados.length > 1 && dados[1].trim().equals(cpf)) {
                        clienteInfo.append("Cliente encontrado:\n")
                                .append("Nome: ").append(dados[0]).append("\n")
                                .append("CPF: ").append(dados[1]).append("\n")
                                .append("Email: ").append(dados[2]).append("\n")
                                .append("Telefone: ").append(dados[3]).append("\n")
                                .append("Endereço: ").append(dados[4]).append("\n")
                                .append("Número Residencia: ").append(dados[5]).append("\n")
                                .append("Bairro: ").append(dados[6]).append("\n")
                                .append("Cidade: ").append(dados[7]).append("\n")
                                .append("Estado: ").append(dados[8]).append("\n")
                                .append("País: ").append(dados[9]).append("\n")
                                .append("Sexo: ").append(dados[10]).append("\n")
                                .append("Data de Nascimento: ").append(dados[11]).append("\n");
                        encontrado = true;
                    }
                }
            }

            if (!encontrado) {
                return "Cliente com CPF \"" + cpf + "\" não encontrado.";
            }
        } catch (IOException e) {
            return "Erro ao ler o arquivo." + e.getMessage();
        }
        return clienteInfo.toString();
    }
}
