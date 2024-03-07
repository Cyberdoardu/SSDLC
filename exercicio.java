import java.util.ArrayList;
import java.util.Scanner;

class Musica {
    String titulo;
    double duracao;
    String compositor;

    public Musica(String titulo, double duracao, String compositor) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.compositor = compositor;
    }

    public void tocarMusica() {
        System.out.println("Tocando música: " + this.titulo);
    }
}

class Album {
    String genero;
    int ano;
    String nome;
    String artista;
    ArrayList<Musica> musicas;

    public Album(String genero, int ano, String nome, String artista) {
        this.genero = genero;
        this.ano = ano;
        this.nome = nome;
        this.artista = artista;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void mostrarTodosOsDados() {
        System.out.println("Nome do Álbum: " + nome);
        System.out.println("Artista: " + artista);
        System.out.println("Gênero: " + genero);
        System.out.println("Ano: " + ano);
        for (Musica musica : musicas) {
            System.out.println("Música: " + musica.titulo + ", Duração: " + musica.duracao + ", Compositor: " + musica.compositor);
        }
    }
}

class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

public class exercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Leitura dos dados da Pessoa
        System.out.println("Informe o nome da pessoa:");
        String nomePessoa = scanner.nextLine();
        System.out.println("Informe a idade da pessoa:");
        int idadePessoa = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        Pessoa pessoa = new Pessoa(nomePessoa, idadePessoa);

        //Criar um array de musicas, onde todas as musicas serao adicionadas
        ArrayList<Musica> musicas = new ArrayList<>();
        ArrayList<Album> albuns = new ArrayList<>();
        


        while (true){

            System.out.println("Digite um comando (tocar, addmusica, musicas, addalbum, perfil, toAlbum, mostrarAlbum, sair):");
            String comando = scanner.nextLine();

            if (comando.equals("sair")) {
                break;
            } else if (comando.equals("tocar")) {

                //Insira o nome da musica para ser tocada
                System.out.println("Escolha a música que deseja tocar:");
                String musicaEscolhida = scanner.nextLine();
                boolean musicaEncontrada = false;
                for (Musica musica : musicas) {
                    if (musica.titulo.toLowerCase().equals(musicaEscolhida.toLowerCase())) {
                        musica.tocarMusica();
                        musicaEncontrada = true;
                    }
                }
                if (!musicaEncontrada) {
                    System.out.println("Música não encontrada");
                }


                

            } else if (comando.equals("addmusica")){

                // Leitura dos dados da Música
                System.out.println("Informe o título da música:");
                String tituloMusica = scanner.nextLine();
                System.out.println("Informe a duração da música:");
                double duracaoMusica = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over
                System.out.println("Informe o compositor da música:");
                String compositorMusica = scanner.nextLine();
                musicas.add(new Musica(tituloMusica, duracaoMusica, compositorMusica));      
                



            } else if (comando.equals("musicas")){

                for (Musica musica : musicas) {
                    System.out.println("Música: " + musica.titulo + ", Duração: " + musica.duracao + ", Compositor: " + musica.compositor);
                }
            
            } else if (comando.equals("addalbum")) {

                        // Leitura dos dados do Álbum
                System.out.println("Informe o gênero do álbum:");
                String generoAlbum = scanner.nextLine();
                System.out.println("Informe o ano do álbum:");
                int anoAlbum = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                System.out.println("Informe o nome do álbum:");
                String nomeAlbum = scanner.nextLine();
                System.out.println("Informe o artista do álbum:");
                String artistaAlbum = scanner.nextLine();
                albuns.add(new Album(generoAlbum, anoAlbum, nomeAlbum, artistaAlbum));


            } else if (comando.equals("perfil")) {
                System.out.println("Nome: " + pessoa.nome);
                System.out.println("Idade: " + pessoa.idade);

            } else if (comando.equals("toAlbum")) {
                // Adicionar musica em um album
                System.out.println("Escolha o álbum que deseja adicionar a música:");
                //Printar todos os albuns e numerar eles para facilitar escolha 
                for (int i = 0; i < albuns.size(); i++) {
                    System.out.println(i + " - " + albuns.get(i).nome);
                }
                int albumEscolhido = scanner.nextInt();
                // Printar todas as musicas e numerar elas para facilitar escolha
                System.out.println("Escolha a música que deseja adicionar:");
                for (int i = 0; i < musicas.size(); i++) {
                    System.out.println(i + " - " + musicas.get(i).titulo);
                }
                //Adicionar a musica escolhida no album escolhido
                int musicaEscolhida = scanner.nextInt();
                 // Consumir o newline left-over
                scanner.nextLine();
                albuns.get(albumEscolhido).adicionarMusica(musicas.get(musicaEscolhida));
                System.out.println("Música " + musicas.get(musicaEscolhida).titulo + " adicionada ao álbum " + albuns.get(albumEscolhido).nome);

            
            } else if (comando.equals("mostrarAlbum")) {
                //Mostrar todos os dados de um album
                System.out.println("Escolha o álbum que deseja mostrar:");
                //Printar todos os albuns e numerar eles para facilitar escolha 
                for (int i = 0; i < albuns.size(); i++) {
                    System.out.println(i + " - " + albuns.get(i).nome);
                }
                int albumEscolhido = scanner.nextInt();
                                                // Consumir o newline left-over
                scanner.nextLine();
                albuns.get(albumEscolhido).mostrarTodosOsDados();
            }else {
                System.out.println("Comando inválido");
            }

        






        }
                scanner.close();

        
    }
}
