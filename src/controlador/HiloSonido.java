package controlador;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.SourceDataLine;

import com.sun.media.sound.DataPusher;

public class HiloSonido implements Runnable {
	String fichero;

	HiloSonido(String fichero) {
		this.fichero = fichero;
	}

	public void run() {
		try {
			// read audio data from whatever source (file/classloader/etc.)
			InputStream audioSrc = getClass().getResourceAsStream(fichero);
			// add buffer for mark/reset support
			InputStream bufferedIn = new BufferedInputStream(audioSrc);
			AudioInputStream aus = AudioSystem.getAudioInputStream(bufferedIn);

			if (System.getProperty("os.name").equals("Linux")) {
				DataPusher datapusher = null;
				DataLine.Info lineinfo = null;
				SourceDataLine sourcedataline = null;
				lineinfo = new DataLine.Info(SourceDataLine.class, aus.getFormat());
				if (!(AudioSystem.isLineSupported(lineinfo))) {
					return;
				}
				sourcedataline = (SourceDataLine) AudioSystem.getLine(lineinfo);
				sourcedataline.addLineListener(e -> {
					if (e.getType() == LineEvent.Type.STOP) {
						// Do something on end of playback
					}
				});
				datapusher = new DataPusher(sourcedataline, aus);
				datapusher.start();
			} else {
				// Se obtiene un Clip de sonido
				Clip sonido = AudioSystem.getClip();

				// Se carga con un fichero wav
				sonido.open(aus);

				// Comienza la reproducción
				sonido.start();
			}

		} catch (Exception e) {
			System.out.println("" + e);
		}
	}

}
