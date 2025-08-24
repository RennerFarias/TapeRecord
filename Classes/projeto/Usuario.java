package Classes;

import Classes.projeto.Midia;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private ArrayList<Playlist> playlists;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.playlists = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public ArrayList<Playlist> getPlaylists() { return playlists; }

    public void criarPlaylist(String nome) {
        playlists.add(new Playlist(nome));
        System.out.println("Playlist criada!");
    }

    public void listarPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("Nenhuma playlist encontrada.");
            return;
        }
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println((i+1) + " - " + playlists.get(i).getNome());
        }
    }

    public Playlist getPlaylist(int indice) {
        if (indice >= 0 && indice < playlists.size()) {
            return playlists.get(indice);
        }
        return null;
    }

    public void removerPlaylist(int indice) {
        if (indice >= 0 && indice < playlists.size()) {
            playlists.remove(indice);
            System.out.println("Playlist removida!");
        }
    }
}