package games.acdirican.pissedchickens.utils;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class SoundPlayer extends Thread{
	private final int BUFFER_SIZE = 128000;
	private AudioInputStream audioStream;
	private SourceDataLine sourceLine;
	private String fileName;
	
	/**
	 * @param filename the name of the file that is going to be played
	 */
	public void playSound(String filename) {
		this.fileName = filename;
		this.start();
	}
	
	public void run() {
		try {
			//audioStream = AudioSystem.getAudioInputStream(new File(fileName));
			audioStream = AudioSystem.getAudioInputStream(getClass().getResource(fileName));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		try {
			sourceLine = (SourceDataLine) AudioSystem
					.getLine(new DataLine.Info(SourceDataLine.class, audioStream.getFormat()));
			
			sourceLine.open(audioStream.getFormat());
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sourceLine.start();
		int nBytesRead = 0;
		byte[] abData = new byte[BUFFER_SIZE];
		while (nBytesRead != -1) {
			try {
				nBytesRead = audioStream.read(abData, 0, abData.length);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (nBytesRead >= 0) {
				@SuppressWarnings("unused")
				int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
			}
		}
		sourceLine.drain();
		sourceLine.close();
	}
	
	
}
