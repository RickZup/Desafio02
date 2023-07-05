import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        RegistroDeVendas sistema = new RegistroDeVendas();

        System.out.println("------------------------------------------");
        System.out.println("Olá! Esse é o sistema de registros da loja.");
        System.out.println("------------------------------------------");

        while (sistema.isSistemaRodando()){
            System.out.println();
            System.out.println("O que deseja fazer?");
            System.out.println();
            System.out.println("1. Cadastrar cliente.");
            System.out.println("2. Exibir lista de clientes.");
            System.out.println("3. Cadastrar vendedor.");
            System.out.println("4. Exibir lista de vendedores");
            System.out.println("5. Lançar venda.");
            System.out.println("6. Exibir vendas lançadas.");
            System.out.println("7. Consultar vendas por CPF do cliente.");
            System.out.println("8. Consultar vendas por email do vendedor.");
            System.out.println("9. Sair.");


            int reposta = entrada.nextInt();

            switch (reposta){
                case 1:
                    try {
                        sistema.cadastrarCliente();
                    } catch (IllegalArgumentException exception){
                        System.out.println();
                        System.out.println("----------------------------------------------------");
                        System.out.println(exception.toString());
                        System.out.println("O cadastro não foi concluído.");
                        System.out.println("----------------------------------------------------");
                    }
                    break;
                case 2:
                    sistema.exibirClientes();
                    break;
                case 3:
                    try {
                        sistema.cadastrarVendedor();
                    } catch (IllegalArgumentException exception){
                        System.out.println();
                        System.out.println("----------------------------------------------------");
                        System.out.println(exception.toString());
                        System.out.println("O cadastro não foi concluído.");
                        System.out.println("----------------------------------------------------");
                    }
                    break;
                case 4:
                    sistema.exibirVendedores();
                    break;
                case 5:
                    sistema.inserirVenda();
                    break;
                case 6:
                    sistema.exibirVendas();
                    break;
                case 7:
                    sistema.pesquisarComprasPorCPF();
                    break;
                case 8:
                    sistema.pesquisarComprasPorEmail();
                    break;
                case 9:
                    sistema.setSistemaRodando(false);
                    System.out.println("Encerrando sistema!");
                    break;
                default:
                    System.out.println("Por favor, insira uma opção válida!");
            }
        }

    }
}
