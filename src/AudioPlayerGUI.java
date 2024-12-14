import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AudioPlayerGUI {
    private AudioPlayer player;
    private JButton playStopButton;

    public AudioPlayerGUI(AudioPlayer player) {
        this.player = player;
        this.playStopButton = new JButton("Play");
    }

    public JButton getPlayStopButton(){
        return playStopButton;
    }

    public JButton createPlayStopButtonGUI(){
        playStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                if (!player.getIsPlaying()) {
                    player.playAudio();
                    playStopButton.setText("Stop");
                } else {
                    player.stopAudio();
                    playStopButton.setText("Play");
                }
            }
        });

        return playStopButton;

    }

    public JButton createNextButtonGUI(){
        JButton nextButton = new JButton("Next");

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                player.nextAudio();
                playStopButton.setText("Stop");
            }
        });
        
        return nextButton;
    }

    public JButton createPreviousButtonGUI(){
        JButton previousButton = new JButton("Previous");

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                player.previousAudio();
                playStopButton.setText("Stop");
            }
        });
        
        return previousButton;
    }

    public void createOptionDialog(String text, String title, ImageIcon capa){
        JOptionPane.showOptionDialog(null, text, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, capa, new Object[] { createPreviousButtonGUI(), playStopButton, createNextButtonGUI()}, createPlayStopButtonGUI());

        if (player.getAudioClip() != null) {
            player.getAudioClip().close();
        }
    }
}
