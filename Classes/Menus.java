package Classes;

public class Menus {
    public static final String NAME = "\033[1m" + "=".repeat(25) +
            "\n♫\uD83D\uDDAD♫  Tape Record  ♫\uD83D\uDDAD♫     \n" +
            "=".repeat(25) + "\033[m";

    public static final String PRINCIPAL = "\033[37m" + "=".repeat(25) +
            """
            
            \033[93m1 - PlayLists
            2 - Midias
            3 - Pesquisar
            4 - Sair
            """ +
            "\033[37m" + "=".repeat(25) + "\033[m";



    public static final String PLAYLISTS = "\033[37m" + "=".repeat(25) +
            """
            
            \033[93m1 - Criar playlist
            2 - Listar playlists criadas
            3 - Selecionar playlist
            4 - Excluir playlist
            5 - Voltar
            """ +
            "\033[37m" + "=".repeat(25) + "\033[m";

    public static final String MIDIAS = "\033[37m" + "=".repeat(25) +
            """
            
            \033[93m1 - Listar midias do catalogo
            2 - Adicionar midia ao catalogo
            3 - Buscar Midia
            4 - Remover midia do catalogo
            5 - Voltar
            \033[m
                    """ +
            "\033[37m" + "=".repeat(25) + "\033[m";

    public static void main(String[] args) {
        System.out.println();
    }
}
