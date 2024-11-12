package comportamento.cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private String proprietarioCPF;

    private static final String FILE_PATH = "src/estrutura/data/veiculo.txt";

    public String cadastrarVeiculo(String placa, String marca, String modelo, int anoFabricacao,
            String proprietarioCPF) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.proprietarioCPF = proprietarioCPF;

        boolean existeCliente = CadastroCliente.existeCliente(proprietarioCPF);

        if (!existeCliente) {
            return "Cliente com CPF \"" + proprietarioCPF + "\" não encontrado.";
        }

        try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[0].trim().equals(placa)) {
                    return "Veículo com placa \"" + placa + "\" já cadastrado.";
                }
            }
        } catch (IOException e) {
            return ("Erro ao ler o arquivo: " + e.getMessage());
        }

        try {
            FileWriter arquivo = new FileWriter(FILE_PATH, true);
            try (PrintWriter escritor = new PrintWriter(arquivo)) {
                escritor.println(
                        this.placa
                                + "," + this.marca + "," + this.modelo + "," + this.anoFabricacao + ","
                                + this.proprietarioCPF);
            } finally {
                arquivo.close();
            }
            return ("Veiculo cadastrado com sucesso");
        } catch (IOException e) {
            return ("Erro ao gravar arquivo");
        }
    }

    public String consultarVeiculo(String placa) {
        StringBuilder veiculoInfo = new StringBuilder();

        try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            boolean encontrado = false;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[0].trim().equals(placa)) {
                    veiculoInfo.append("Veiculo encontrado:\n")
                            .append("Placa: ").append(dados[0]).append("\n")
                            .append("Marca: ").append(dados[1]).append("\n")
                            .append("Modelo: ").append(dados[2]).append("\n")
                            .append("Ano de Fabricação: ").append(dados[3]).append("\n")
                            .append("CPF do Proprietário: ").append(dados[4]);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                return ("Veiculo com placa " + placa + " não encontrado.");
            }
        } catch (IOException e) {
            return ("Erro ao ler o arquivo." + e.getMessage());
        }
        return veiculoInfo.toString();
    }

    public String consultarVeiculoPorCPF(String cpf) {
        StringBuilder veiculoInfo = new StringBuilder();

        try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            boolean encontrado = false;
            int num = 1;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[4].trim().equals(cpf)) {
                    veiculoInfo.append("Veiculo encontrado nº").append(num).append(":\n")
                            .append("Placa: ").append(dados[0]).append("\n")
                            .append("Marca: ").append(dados[1]).append("\n")
                            .append("Modelo: ").append(dados[2]).append("\n")
                            .append("Ano de Fabricação: ").append(dados[3]).append("\n");
                    num++;
                    encontrado = true;
                }
            }
            if (!encontrado) {
                return ("Veiculo(s) vinculado(s) ao CPF " + cpf + " não encontrado(s).");
            }
        } catch (IOException e) {
            return ("Erro ao ler o arquivo." + e.getMessage());
        }
        return ("Veiculo(s) vinculado(s) ao CPF " + cpf + " encontrado(s).") + "\n" + veiculoInfo.toString();
    }

    public String editarVeiculo(String placa, String marca, String modelo, int anoFabricacao, String proprietarioCPF) {
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;
        try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados[0].equals(placa)) {
                    String novaLinha = String.join(",", placa, marca, modelo, String.valueOf(anoFabricacao),
                            proprietarioCPF);
                    linhas.add(novaLinha);
                    encontrado = true;
                } else {
                    linhas.add(linha);
                }
            }
        } catch (IOException e) {
            return ("Erro ao ler o arquivo." + e.getMessage());
        }

        if (encontrado) {
            try (PrintWriter escritor = new PrintWriter(new FileWriter(FILE_PATH))) {
                for (String linha : linhas) {
                    escritor.println(linha);
                }
                return ("Dados do veículo atualizados com sucesso.");
            } catch (IOException e) {
                return ("Erro ao escrever no arquivo." + e.getMessage());
            }
        } else {
            return ("Veículo com placa " + placa + " não encontrado.");
        }
    }

}
