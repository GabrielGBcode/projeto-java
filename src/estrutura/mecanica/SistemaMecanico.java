package estrutura.mecanica;

import comportamento.cliente.*;
import comportamento.estoque.CadastroEstoque;
import comportamento.estoque.ConsultaEstoque;
import comportamento.estoque.EditarEstoque;
import comportamento.funcionario.*;
import comportamento.orcamento.*;
import comportamento.servico.Revisao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SistemaMecanico {
    PaginaInicial sistemaMecanico = new PaginaInicial();

    public boolean seVerdadeiro(Scanner scanner, String str) {
        while (true) {
            System.out.println("Digite 'S' para sim ou 'N' para não:");
            str = scanner.nextLine().trim();

            if (str.equalsIgnoreCase("S") || str.equals("1") || str.equals("sim")) {
                return true;
            } else if (str.equalsIgnoreCase("N") || str.equals("0") || str.equals("não") || str.equals("nao")) {
                return false;
            } else {
                System.out.println(
                        "Entrada inválida! Por favor, digite 'S' para sim, 'N' para não, '1' para sim, ou '0' para não.");
            }
        }
    }

    public void CadastroFuncionario() {
        boolean boolSexo;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (Scanner scanner = new Scanner(System.in)) {
            CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();

            System.out.println("Nome:");
            String nome = scanner.nextLine();

            System.out.println("CPF: ");
            String cpf = scanner.nextLine();

            System.out.println("Email: ");
            String email = scanner.nextLine();

            System.out.println("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.println("Endereço: ");
            String endereco = scanner.nextLine();

            System.out.println("Número da Residência: ");
            int numeroResidencia = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Bairro: ");
            String bairro = scanner.nextLine();

            System.out.println("Cidade: ");
            String cidade = scanner.nextLine();

            System.out.println("Estado: ");
            String estado = scanner.nextLine();

            System.out.println("País: ");
            String pais = scanner.nextLine();

            String sexo;
            while (true) {
                System.out.println("Sexo: (M/F)");
                sexo = scanner.nextLine().trim().toUpperCase();

                if (sexo.equals("M") || sexo.equals("F")) {
                    boolSexo = sexo.equals("M");
                    break;
                } else {
                    System.out.println("Entrada inválida. Por favor, digite 'M' para Masculino ou 'F' para Feminino.");
                }
            }

            System.out.println("Data de Nascimento (dd/MM/yyyy):");
            String dataNascimentoStr = scanner.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, dateFormatter);
            System.out.println(cadastroFuncionario.cadastrarFuncionario(nome, cpf, email, telefone,
                    endereco, numeroResidencia, bairro, cidade, estado, pais, boolSexo,
                    dataNascimento));

            System.out.println("1. Cadastrar outro funcionário\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Cadastrar funcionário");
                    CadastroFuncionario();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando a Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    public void ConsultarFuncionario() {
        try (Scanner scanner = new Scanner(System.in)) {
            ConsultaFuncionario consultaFuncionario = new ConsultaFuncionario();
            String cpfFuncionario;
            System.out.println("Digite o CPF do funcionário que deseja consultar:");
            cpfFuncionario = scanner.nextLine();
            System.out.println(consultaFuncionario.consultarFuncionario(cpfFuncionario));

            System.out.println("1. Consultar outro funcionário\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Consultar funcionário");
                    ConsultarFuncionario();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando a Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        }
    }

    public void EditarFuncionario() {
        boolean boolSexo;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try (Scanner scanner = new Scanner(System.in)) {
            EditarFuncionario editarFuncionario = new EditarFuncionario();
            String cpfFuncionario;
            System.out.println("Digite o CPF do funcionário que deseja editar:");
            cpfFuncionario = scanner.nextLine();

            System.out.println("Nome:");
            String nome = scanner.nextLine();

            System.out.println("Email: ");
            String email = scanner.nextLine();

            System.out.println("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.println("Endereço: ");
            String endereco = scanner.nextLine();

            System.out.println("Número da Residência: ");
            int numeroResidencia = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Bairro: ");
            String bairro = scanner.nextLine();

            System.out.println("Cidade: ");
            String cidade = scanner.nextLine();

            System.out.println("Estado: ");
            String estado = scanner.nextLine();

            System.out.println("País: ");
            String pais = scanner.nextLine();

            String sexo;
            while (true) {
                System.out.println("Sexo: (M/F)");
                sexo = scanner.nextLine().trim().toUpperCase();

                if (sexo.equals("M") || sexo.equals("F")) {
                    boolSexo = sexo.equals("M");
                    break;
                } else {
                    System.out.println("Entrada inválida. Por favor, digite 'M' para Masculino ou 'F' para Feminino.");
                }
            }

            System.out.println("Data de Nascimento (dd/MM/yyyy):");
            String dataNascimentoStr = scanner.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, dateFormatter);

            System.out.println(editarFuncionario.editarFuncionario(cpfFuncionario, nome, email, telefone,
                    endereco, numeroResidencia, bairro, cidade, estado, pais, boolSexo,
                    dataNascimento));

            System.out.println("1. Editar outro funcionário\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Editar funcionário");
                    EditarFuncionario();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando a Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao editar funcionário: " + e.getMessage());
        }
    }

    public void CadastroCliente() {
        boolean boolSexo;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (Scanner scanner = new Scanner(System.in)) {
            CadastroCliente cadastroCliente = new CadastroCliente();

            System.out.println("Nome:");
            String nome = scanner.nextLine();

            System.out.println("CPF: ");
            String cpf = scanner.nextLine();

            System.out.println("Email: ");
            String email = scanner.nextLine();

            System.out.println("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.println("Endereço: ");
            String endereco = scanner.nextLine();

            System.out.println("Número da Residência: ");
            int numeroResidencia = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Bairro: ");
            String bairro = scanner.nextLine();

            System.out.println("Cidade: ");
            String cidade = scanner.nextLine();

            System.out.println("Estado: ");
            String estado = scanner.nextLine();

            System.out.println("País: ");
            String pais = scanner.nextLine();

            String sexo;
            while (true) {
                System.out.println("Sexo: (M/F)");
                sexo = scanner.nextLine().trim().toUpperCase();

                if (sexo.equals("M") || sexo.equals("F")) {
                    boolSexo = sexo.equals("M");
                    break;
                } else {
                    System.out.println("Entrada inválida. Por favor, digite 'M' para Masculino ou 'F' para Feminino.");
                }
            }

            System.out.println("Data de Nascimento (dd/MM/yyyy):");
            String dataNascimentoStr = scanner.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, dateFormatter);
            System.out.println(cadastroCliente.cadastrarCliente(nome, cpf, email, telefone,
                    endereco, numeroResidencia, bairro, cidade, estado, pais, boolSexo,
                    dataNascimento));

            System.out.println("1. Cadastrar outro cliente\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Cadastrar cliente");
                    CadastroCliente();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando a Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public void ConsultarCliente() {
        try (Scanner scanner = new Scanner(System.in)) {
            ConsultaCliente consultaCliente = new ConsultaCliente();
            String cpfCliente;
            System.out.println("Digite o CPF do cliente que deseja consultar:");
            cpfCliente = scanner.nextLine();
            System.out.println(consultaCliente.consultarCliente(cpfCliente));

            System.out.println("1. Consultar outro cliente\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Consultar cliente");
                    ConsultarCliente();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando a Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao consultar o cliente: " + e.getMessage());
        }
    }

    public void EditarCliente() {
        boolean boolSexo;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try (Scanner scanner = new Scanner(System.in)) {
            EditarCliente editarCliente = new EditarCliente();
            String cpfFuncionario;
            System.out.println("Digite o CPF do cliente que deseja editar:");
            cpfFuncionario = scanner.nextLine();

            System.out.println("Nome:");
            String nome = scanner.nextLine();

            System.out.println("Email: ");
            String email = scanner.nextLine();

            System.out.println("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.println("Endereço: ");
            String endereco = scanner.nextLine();

            System.out.println("Número da Residência: ");
            int numeroResidencia = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Bairro: ");
            String bairro = scanner.nextLine();

            System.out.println("Cidade: ");
            String cidade = scanner.nextLine();

            System.out.println("Estado: ");
            String estado = scanner.nextLine();

            System.out.println("País: ");
            String pais = scanner.nextLine();

            String sexo;
            while (true) {
                System.out.println("Sexo: (M/F)");
                sexo = scanner.nextLine().trim().toUpperCase();

                if (sexo.equals("M") || sexo.equals("F")) {
                    boolSexo = sexo.equals("M");
                    break;
                } else {
                    System.out.println("Entrada inválida. Por favor, digite 'M' para Masculino ou 'F' para Feminino.");
                }
            }

            System.out.println("Data de Nascimento (dd/MM/yyyy):");
            String dataNascimentoStr = scanner.nextLine();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, dateFormatter);

            System.out.println(editarCliente.editarCliente(cpfFuncionario, nome, email, telefone,
                    endereco, numeroResidencia, bairro, cidade, estado, pais, boolSexo,
                    dataNascimento));

            System.out.println("1. Editar outro cliente\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Editar cliente");
                    EditarCliente();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando a Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao editar cliente: " + e.getMessage());
        }
    }

    public void CadastroEstoque() {
        try (Scanner scanner = new Scanner(System.in)) {
            CadastroEstoque cadastroEstoque = new CadastroEstoque();

            System.out.println("Nome:");
            String nome = scanner.nextLine();

            System.out.println("Quantidade:");
            int quantidade = scanner.nextInt();
            scanner.nextLine();
            System.out.println(cadastroEstoque.cadastrarEstoque(nome, quantidade));

            System.out.println("1. Cadastrar outro estoque\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Cadastrar estoque");
                    CadastroEstoque();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando a Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        }
    }

    public void ConsultarEstoque() {
        try (Scanner scanner = new Scanner(System.in)) {
            ConsultaEstoque consultaEstoque = new ConsultaEstoque();
            System.out.println("Digite o ID do estoque que deseja consultar:");
            int idEstoque = scanner.nextInt();
            scanner.nextLine();
            System.out.println(consultaEstoque.consultarEstoque(idEstoque));

            System.out.println("1. Consultar outro estoque\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Consultar estoque");
                    ConsultarEstoque();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando a Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao consultar estoque: " + e.getMessage());
        }
    }

    public void EditarEstoque() {
        try (Scanner scanner = new Scanner(System.in)) {
            EditarEstoque editarEstoque = new EditarEstoque();

            System.out.println("Digite o ID do estoque que deseja editar:");
            int idEstoque = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Nome:");
            String nome = scanner.nextLine();

            System.out.println("Quantidade:");
            int quantidade = scanner.nextInt();
            scanner.nextLine();
            System.out.println(editarEstoque.editarEstoque(idEstoque, nome, quantidade));

            System.out.println("1. Editar outro estoque\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Editar estoque");
                    EditarEstoque();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando a Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao editar estoque: " + e.getMessage());
        }
    }

    public void CadastroOrcamento() {
        try (Scanner scanner = new Scanner(System.in)) {
            Orcamento orcamento = new Orcamento();

            System.out.println("Rev. Óleo:");
            boolean revOleo = seVerdadeiro(scanner, "");

            System.out.println("Rev. Freio:");
            boolean revFreio = seVerdadeiro(scanner, "");

            System.out.println("Rev. Suspensão:");
            boolean revSuspensao = seVerdadeiro(scanner, "");

            System.out.println("Rev. Eletricidade:");
            boolean revEletrica = seVerdadeiro(scanner, "");

            System.out.println("Rev. Timbragem:");
            boolean revTimbragem = seVerdadeiro(scanner, "");

            System.out.println("Rev. Injeção Eletrônica:");
            boolean revInjecaoEletronica = seVerdadeiro(scanner, "");

            System.out.println("CPF:");
            String cpf = scanner.nextLine().trim();

            System.out.println(orcamento.cadastrarOrcamento(revOleo, revFreio, revSuspensao, revEletrica, revTimbragem,
                    revInjecaoEletronica, cpf));

            int opcao = 0;
            while (true) {
                System.out.println("1. Cadastrar outro orçamento\n2. Voltar para a Página Inicial");
                String entrada = scanner.nextLine().trim();

                try {
                    opcao = Integer.parseInt(entrada);
                    if (opcao == 1 || opcao == 2) {
                        break;
                    } else {
                        System.out.println("Opção inválida! Por favor, digite '1' ou '2'.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida! Por favor, digite um número ('1' ou '2').");
                }
            }

            switch (opcao) {
                case 1 -> {
                    System.out.println("Cadastrar orçamento");
                    CadastroOrcamento();
                }
                case 2 -> {
                    System.out.println("Voltando à Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar orçamento: " + e.getMessage());
        }
    }

    public void aprovarOrcamento() {
        try (Scanner scanner = new Scanner(System.in)) {
            Revisao orcamento = new Revisao();
            System.out.println("Digite o ID do orçamento que deseja aprovar:");
            int idOrcamento = scanner.nextInt();
            scanner.nextLine();
            orcamento.aprovarOrcamento(idOrcamento);

            System.out.println("1. Aprovar outro orçamento\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Aprovar orçamento");
                    aprovarOrcamento();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando à Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao aprovar orçamento: " + e.getMessage());
        }
    }

    public void realizarServico() {
        try (Scanner scanner = new Scanner(System.in)) {
            Revisao orcamento = new Revisao();
            System.out.println("Digite o ID do orçamento que deseja realizar:");
            int idOrcamento = scanner.nextInt();
            scanner.nextLine();
            System.out.println(orcamento.realizarServico(idOrcamento));

            System.out.println("1. Realizar outro orçamento\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Realizar orçamento");
                    realizarServico();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando à Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao realizar orçamento: " + e.getMessage());
        }
    }

    public void CadastroVeiculo() {
        try (Scanner scanner = new Scanner(System.in)) {
            Veiculo veiculo = new Veiculo();

            System.out.println("Placa:");
            String placa = scanner.nextLine().trim();

            System.out.println("Marca:");
            String marca = scanner.nextLine().trim();

            System.out.println("Modelo:");
            String modelo = scanner.nextLine().trim();

            System.out.println("Ano de Fabricação:");
            int anoFabricacao = scanner.nextInt();
            scanner.nextLine();

            System.out.println("CPF do Proprietário:");
            String proprietarioCPF = scanner.nextLine().trim();

            System.out.println(veiculo.cadastrarVeiculo(placa, marca, modelo, anoFabricacao, proprietarioCPF));

            System.out.println("1. Cadastrar outro veículo\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Cadastrar veículo");
                    CadastroVeiculo();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando à Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar veículo: " + e.getMessage());
        }
    }

    public void ConsultarVeiculo() {
        try (Scanner scanner = new Scanner(System.in)) {
            Veiculo veiculo = new Veiculo();
            System.out.println("Digite a placa do veículo que deseja consultar:");
            String placa = scanner.nextLine().trim().toUpperCase();
            System.out.println(veiculo.consultarVeiculo(placa));

            System.out.println("1. Consultar outro veículo\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Consultar veículo");
                    ConsultarVeiculo();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando à Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao consultar veículo: " + e.getMessage());
        }
    }

    public void ConsultarVeiculos() {
        try (Scanner scanner = new Scanner(System.in)) {
            Veiculo veiculo = new Veiculo();
            System.out.println("Digite o CPF do proprietário que deseja consultar:");
            String cpf = scanner.nextLine().trim();
            System.out.println(veiculo.consultarVeiculoPorCPF(cpf));

            System.out.println("1. Consultar outro veículo\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Consultar veículo");
                    ConsultarVeiculos();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando à Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao consultar veículos: " + e.getMessage());
        }
    }

    public void EditarVeiculo() {
        try (Scanner scanner = new Scanner(System.in)) {
            Veiculo veiculo = new Veiculo();
            System.out.println("Digite a placa do veículo que deseja editar:");
            String placa = scanner.nextLine().trim();

            System.out.println("Marca:");
            String marca = scanner.nextLine().trim();

            System.out.println("Modelo:");
            String modelo = scanner.nextLine().trim();

            System.out.println("Ano de Fabricação:");
            int anoFabricacao = scanner.nextInt();
            scanner.nextLine();

            System.out.println("CPF do Proprietário:");
            String proprietarioCPF = scanner.nextLine().trim();

            System.out.println(veiculo.editarVeiculo(placa, marca, modelo, anoFabricacao, proprietarioCPF));

            System.out.println("1. Editar outro veículo\n2. Voltar para a Página Inicial");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Editar veículo");
                    EditarVeiculo();
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Voltando à Página Inicial");
                    sistemaMecanico.IniciarPaginaInicial();
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao editar veículo: " + e.getMessage());
        }
    }
}
