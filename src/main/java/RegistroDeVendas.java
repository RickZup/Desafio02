import java.util.*;

public class RegistroDeVendas implements Validacoes {

    private List<Venda> listaVendas;
    private Map<String, Cliente> listaClientes;
    private Map<String, Vendedor> listaVendedores;
    private boolean sistemaRodando;

    Scanner entrada = new Scanner(System.in);

    public RegistroDeVendas(){
        listaVendas = new ArrayList<>();
        listaClientes = new HashMap<>();
        listaVendedores = new HashMap<>();
        sistemaRodando = true;
    }

    public boolean isSistemaRodando(){
        return sistemaRodando;
    }

    public void setSistemaRodando(boolean sistemaRodando) {
        this.sistemaRodando = sistemaRodando;
    }

    public void cadastrarCliente(){
        System.out.println();
        System.out.println("---------- CADASTRO DE CLIENTES ----------");
        System.out.println("Qual o nome do cliente?");
        String nome = entrada.next();

        System.out.println("E o número do CPF?");
        String cpf = entrada.next();
        for (Cliente cliente : listaClientes.values()) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println();
                System.out.println("----------------------------------");
                System.out.println("Esse CPF pertence a outro cliente!");
                System.out.println("----------------------------------");
                return;
            }
        }

        System.out.println("Só preciso de mais um dado! Informe o e-mail de " + nome + " por favor!");
        String email = entrada.next();
        validarEmail(email);
        for (Cliente cliente : listaClientes.values()) {
            if (cliente.getEmail().equals(email)) {
                System.out.println();
                System.out.println("----------------------------------");
                System.out.println("Esse e-mail já foi utilizado!");
                System.out.println("----------------------------------");
                return;
            }
        }

        Cliente cliente = new Cliente(nome, cpf, email);
        listaClientes.put(nome, cliente); //Populando a lista de clientes.

        System.out.println(nome + " foi cadastrado com sucesso! :D");
    }

    public void exibirClientes(){
        System.out.println();
        System.out.println("--------------------");
        System.out.println("Lista de clientes:");
        System.out.println("--------------------");
        for (Cliente cliente: listaClientes.values()){
            System.out.println("Nome: " + cliente.getNome());
        }
    }

    public void cadastrarVendedor(){
        System.out.println();
        System.out.println("---------- CADASTRO DE VENDEDORES ----------");
        System.out.println("Qual o nome do vendedor?");
        String nome = entrada.next();

        System.out.println("E o número do CPF?");
        String cpf = entrada.next();
        for (Vendedor vendedor : listaVendedores.values()) {
            if (vendedor.getCpf().equals(cpf)) {
                System.out.println();
                System.out.println("----------------------------------");
                System.out.println("Esse CPF pertence a outro vendedor!");
                System.out.println("----------------------------------");
                return;
            }
        }

        System.out.println("Agora nforme o e-mail de " + nome);
        String email = entrada.next();
        validarEmail(email);
        for (Vendedor vendedor : listaVendedores.values()) {
            if (vendedor.getEmail().equals(email)) {
                System.out.println();
                System.out.println("----------------------------------");
                System.out.println("Esse e-mail já foi utilizado!");
                System.out.println("----------------------------------");
                return;
            }
        }

        Vendedor vendedor = new Vendedor(nome, cpf, email);
        listaVendedores.put(nome, vendedor); //Populando a lista de vendedores.

        System.out.println();
        System.out.println(nome + " foi cadastrado como vendedor.");
    }

    public void exibirVendedores(){
        System.out.println();
        System.out.println("--------------------");
        System.out.println("Lista de vendedores:");
        System.out.println("--------------------");
        for (Vendedor vendedor: listaVendedores.values()){
            System.out.println("Nome: " + vendedor.getNome());
        }
    }

    public void inserirVenda(){
        System.out.println();
        System.out.println("---------- REGISTRO DE VENDAS ----------");
        System.out.println("Para começarmos, informe o nome do cliente:");
        String clienteNome = entrada.next();

        //Buscando cliente na lista de clientes cadastrados
        Cliente cliente = listaClientes.get(clienteNome);
        if (cliente == null){
            System.out.println(clienteNome + " ainda não foi cadastrado como cliente!");
            return;
        } else {
            System.out.println("------------------------------------------------------");
            System.out.println("Encontrei " + clienteNome + " como cliente cadastrado!");
            System.out.println("------------------------------------------------------");
        }

        System.out.println();
        System.out.println("Agora preciso do nome da pessoa vendedora:");
        String vendedorNome = entrada.next();

        //Buscando pessoa vendedora na lista de vendedores cadastrados
        Vendedor vendedor = listaVendedores.get(vendedorNome);
        if (vendedor == null){
            System.out.println(vendedorNome + " não consta no meu banco de dados.");
        }

        System.out.println("Tudo certo até aqui. Qual o valor da venda?");
        double valor = entrada.nextDouble();

        System.out.println("Para encerrar, diga a data do ocorrido:");
        String data = entrada.next();

        Venda venda = new Venda(cliente, vendedor, valor, data);
        listaVendas.add(venda);

        System.out.println("------------------------------------------------------");
        System.out.println("Pronto! A venda foi registrada com sucesso.");
        System.out.println("------------------------------------------------------");
    }

    public void exibirVendas(){
        System.out.println();
        System.out.println("--------------------");
        System.out.println("Lista de vendas:");
        System.out.println("--------------------");
        for (Venda venda : listaVendas) {
            System.out.println("Venda feita por: " + venda.getVendedor().getNome());
            System.out.println("Nome do cliente: " + venda.getCliente().getNome());
            System.out.println("Valor da venda: " + venda.getValorASerPago());
            System.out.println("Data de registro: " + venda.getDataRegistro());
            System.out.println();
        }
    }

    public void pesquisarComprasPorCPF() {
        System.out.println();
        System.out.println("---------- PESQUISA DE COMPRAS POR CPF ----------");

        // Percorrer a lista de vendas
        for (Venda venda : listaVendas) {
            Cliente cliente = venda.getCliente();

            System.out.println("Informe o CPF:");
            String cpf = entrada.next();

            // Verificar se o CPF do cliente corresponde ao CPF informado
            if (cliente.getCpf().equals(cpf)) {
                System.out.println();
                System.out.println("Cliente: " + cliente.getNome());
                System.out.println("Valor da venda: " + venda.getValorASerPago());
                System.out.println("Data de registro: " + venda.getDataRegistro());
                System.out.println("--------------------");
            }
        }
    }

}
