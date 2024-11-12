package comportamento.orcamento;

import comportamento.cliente.CadastroCliente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Orcamento {

    private int id;
    private boolean revOleo;
    private boolean revFreio;
    private boolean revSuspensao;
    private boolean revEletrica;
    private boolean revtimbragem;
    private boolean revInjecaoEletronica;
    private String cpf;
    private boolean feito;

    private static final String FILE_PATH = "src/estrutura/data/orcamento.txt";

    public String cadastrarOrcamento(boolean revOleo, boolean revFreio, boolean revSuspensao, boolean revEletrica,
            boolean revtimbragem, boolean revInjecaoEletronica, String cpf) {
        this.revOleo = revOleo;
        this.revFreio = revFreio;
        this.revSuspensao = revSuspensao;
        this.revEletrica = revEletrica;
        this.revInjecaoEletronica = revInjecaoEletronica;
        this.revtimbragem = revtimbragem;
        this.cpf = cpf;
        this.feito = false;

        int maiorID = 0;

        try (BufferedReader leitor = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    String[] dados = linha.split(",");
                    this.id = Integer.parseInt(dados[0].trim());
                    if (this.id > maiorID) {
                        maiorID = this.id;
                    }
                }
            }
        } catch (IOException e) {
            return ("Erro ao ler o arquivo: " + e.getMessage());
        }

        this.id = maiorID + 1;

        boolean existeCliente = CadastroCliente.existeCliente(cpf);
        if (!existeCliente) {
            return ("Cliente com CPF \"" + this.cpf + "\" não encontrado.");
        }

        try {
            FileWriter arquivo = new FileWriter(FILE_PATH, true);
            try (PrintWriter escritor = new PrintWriter(arquivo)) {
                escritor.println(
                        this.id + "," + this.revOleo + "," + this.revFreio + "," + this.revSuspensao + ","
                                + this.revEletrica + "," + this.revInjecaoEletronica + "," + this.revtimbragem + ","
                                + this.cpf + "," + this.feito);
            } finally {
                arquivo.close();
            }
            return ("Orçamento cadastrado com sucesso");
        } catch (IOException e) {
            return ("Erro ao gravar arquivo");
        }
    }

}
