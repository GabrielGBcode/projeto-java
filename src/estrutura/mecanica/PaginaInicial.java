package estrutura.mecanica;

import java.util.Scanner;

public class PaginaInicial {

    public void IniciarPaginaInicial() {
        SistemaMecanico sistemaMecanico = new SistemaMecanico();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bem vindo ao sistema Reviselt!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Funcionários\n2. Clientes\n3. Estoque\n4. Orcamento\n5. Serviço\n6. Sair");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.flush();
                    System.out.println("Funcionários");
                    System.out.println(
                            "1. Cadastrar funcionário\n2. Consultar funcionários\n3. Editar funcionário\n4. Veiculos\n5. Sair");
                    int opcaoFuncionario = scanner.nextInt();
                    switch (opcaoFuncionario) {
                        case 1 -> {
                            System.out.flush();
                            System.out.println("Cadastrar funcionário");
                            sistemaMecanico.CadastroFuncionario();
                        }
                        case 2 -> {
                            System.out.flush();
                            System.out.println("Consultar funcionário");
                            sistemaMecanico.ConsultarFuncionario();
                        }
                        case 3 -> {
                            System.out.flush();
                            System.out.println("Editar funcionário");
                            sistemaMecanico.EditarFuncionario();
                        }
                        case 4 -> {
                            System.out.flush();
                            System.out.println("Sair");
                            IniciarPaginaInicial();
                        }
                        default -> System.out.println("Opção inválida");
                    }
                }
                case 2 -> {
                    System.out.flush();
                    System.out.println("Clientes");
                    System.out.println(
                            "1. Cadastrar cliente\n2. Consultar cliente\n3. Editar cliente\n4. Veiculos\n5. Sair");
                    int opcaoFuncionario = scanner.nextInt();
                    switch (opcaoFuncionario) {
                        case 1 -> {
                            System.out.flush();
                            System.out.println("Cadastrar cliente");
                            sistemaMecanico.CadastroCliente();
                        }
                        case 2 -> {
                            System.out.flush();
                            System.out.println("Consultar cliente");
                            sistemaMecanico.ConsultarCliente();
                        }
                        case 3 -> {
                            System.out.flush();
                            System.out.println("Editar cliente");
                            sistemaMecanico.EditarCliente();
                        }
                        case 4 -> {
                            System.out.flush();
                            System.out.println("Veiculos");
                            System.out.println(
                                    "1. Cadastrar veículo\n2. Consultar veículo (Placa)\n3. Consultar veículos (CPF)\n4. Editar veículo\n5. Sair");
                            int opcaoVeiculo = scanner.nextInt();
                            switch (opcaoVeiculo) {
                                case 1 -> {
                                    System.out.flush();
                                    System.out.println("Cadastrar veículo");
                                    sistemaMecanico.CadastroVeiculo();
                                }
                                case 2 -> {
                                    System.out.flush();
                                    System.out.println("Consultar veículo (Placa)");
                                    sistemaMecanico.ConsultarVeiculo();
                                }
                                case 3 -> {
                                    System.out.flush();
                                    System.out.println("Consultar veículos (CPF)");
                                    sistemaMecanico.ConsultarVeiculos();
                                }
                                case 4 -> {
                                    System.out.flush();
                                    System.out.println("Editar veículo");
                                    sistemaMecanico.EditarVeiculo();
                                }
                                case 5 -> {
                                    System.out.flush();
                                    System.out.println("Sair");
                                    IniciarPaginaInicial();
                                }
                            }
                        }
                        case 5 -> {
                            System.out.flush();
                            System.out.println("Sair");
                            IniciarPaginaInicial();
                        }
                        default -> System.out.println("Opção inválida");
                    }
                }
                case 3 -> {
                    System.out.flush();
                    System.out.println("Estoque");
                    System.out.println(
                            "1. Cadastrar estoque\n2. Consultar estoque\n3. Editar estoque\n4. Sair");
                    int opcaoEstoque = scanner.nextInt();
                    switch (opcaoEstoque) {
                        case 1 -> {
                            System.out.flush();
                            System.out.println("Cadastrar estoque");
                            sistemaMecanico.CadastroEstoque();
                        }
                        case 2 -> {
                            System.out.flush();
                            System.out.println("Consultar estoque");
                            sistemaMecanico.ConsultarEstoque();
                        }
                        case 3 -> {
                            System.out.flush();
                            System.out.println("Editar estoque");
                            sistemaMecanico.EditarEstoque();
                        }
                        case 4 -> {
                            System.out.flush();
                            System.out.println("Sair");
                            IniciarPaginaInicial();
                        }
                    }
                }
                case 4 -> {
                    System.out.flush();
                    System.out.println("Orcamento");
                    System.out.println(
                            "1. Cadastrar orçamento\n2. Sair");
                    int opcaoOrcamento = scanner.nextInt();
                    switch (opcaoOrcamento) {
                        case 1 -> {
                            System.out.flush();
                            System.out.println("Cadastrar orçamento");
                            sistemaMecanico.CadastroOrcamento();
                        }
                        case 2 -> {
                            System.out.flush();
                            System.out.println("Sair");
                            IniciarPaginaInicial();
                        }
                    }
                }
                case 5 -> {
                    System.out.flush();
                    System.out.println("Serviço");
                    System.out.println(
                            "1. Aprovar Orçamento\n2. Realizar Serviço\n3. Sair");
                    int opcaoServico = scanner.nextInt();
                    switch (opcaoServico) {
                        case 1 -> {
                            System.out.flush();
                            System.out.println("Solicitar serviço");
                            sistemaMecanico.aprovarOrcamento();
                        }
                        case 2 -> {
                            System.out.flush();
                            System.out.println("Reavaliar serviço");
                            sistemaMecanico.realizarServico();
                        }
                        case 3 -> {
                            System.out.flush();
                            System.out.println("Sair");
                            IniciarPaginaInicial();
                        }
                    }
                }
                case 6 -> {
                    System.out.println("Adeus!");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
