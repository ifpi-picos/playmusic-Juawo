import java.util.List;
import java.util.ArrayList;

import dominio.Album;
import dominio.Artista;
import dominio.Musica;

public class App {
    public static void main(String[] args) {
        // Criei 3 músicas
        Musica musica1 = new Musica("Neófito", "Rock Cristão", "./assets/Banda-Resgate/Banda-Resgate-Neofito.wav", 194);

        Musica musica2 = new Musica("Terapia", "Rock Cristão", "assets/Banda-Resgate/Banda-Resgate-A-terapia.wav", 188);

        Musica musica3 = new Musica("Jack Joe and Nancy in the Mail", "Rock Cristão",
                "./assets/Banda-Resgate/Banda-Resgate-Jack_-Joe-and-Nancy-in-the-Mall.wav", 185);

        // Crio uma lista de músicas vazia e depois adiciono cada uma
        List<Musica> musicas1 = new ArrayList<>();
        musicas1.add(musica1);
        musicas1.add(musica2);
        musicas1.add(musica3);

        // Passo a lista de músicas como parâmetro para o construtor de album
        Album album1 = new Album("Ainda não é o fim", 2010, musicas1, "./assets/Banda-Resgate/BandaResgate-Capa.jpg");

        Artista bandaResgate = new Artista("Banda Resgate");
        bandaResgate.addAlbum(album1);

        //bandaResgate.getAlbuns().get(0).getMusicas().get(0).getArquivoAudio();
        //[album1,album2,album3] -> album1 -> [musica1,musica2,musica3] -> musica1 -> "./assets/"
        
        Musica musica4 = new Musica("Empty Machine", "Rock", "assets/Linkin-Park/The-Emptiness-Machine-_Official-Music-Video_-Linkin-Park-_-ezmp3.cc-_.wav", 200);

        Album album2 = new Album("Album-LP", 2024, musicas1, null);
        album2.addMusica(musica4);

        Artista linkinPar = new  Artista("LinkinPark");
        linkinPar.addAlbum(album2);
        
        AudioPlayer player = new AudioPlayer();
        player.loadAudios(bandaResgate.getAlbuns().get(0).getMusicas());
        
        AudioPlayerGUI gui = new AudioPlayerGUI(player);

        gui.createOptionDialog("Você está ouvindo música", "PlayMusic", bandaResgate.getAlbuns().get(0).getCapa());
    }
}
