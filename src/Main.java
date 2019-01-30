public class Main {

    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        while(true) {
            System.out.println("Escolha a opção:\n" +
                    "(1) - Criar nova conta\n" +
                    "(2) - Visualizar detalhes de uma conta\n" +
                    "(3) - Visualizar todas as contas\n" +
                    "(4) - Remover conta\n" +
                    "(5) - Iniciar Sessão\n" +
                    "(6) - Visualizar lista de comunidades\n" +
                    "(Outro) - Sair");

            int escolha = Utilidades.lerInteiro();

            if(escolha == 1) {
                sistema.adicionarConta();
            } else if(escolha == 2) {
                sistema.visualizarDetalhes();
            } else if(escolha == 3) {
                sistema.listarTodasContas();
            } else if(escolha == 4) {
                sistema.removerConta();
            } else if(escolha == 5) {
               Usuario user = sistema.iniciarSessao();
               if(user != null) {
                   Sistema.removerConta(user);
               }
            } else if(escolha == 6) {
                Sistema.listarTodasComunidades();
            }
            else {
                break;
            }
        }

    }
}
