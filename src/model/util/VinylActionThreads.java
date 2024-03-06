package model.util;

import model.VinylModel;
import model.vinyl.Vinyl;

import java.util.Random;
import java.util.logging.Logger;
import java.util.logging.Level;

public class VinylActionThreads extends Thread {

    private final Logger logger = Logger.getLogger(VinylActionThreads.class.getName());
    private final VinylModel vinylModel;
    private final String threadName;

    public VinylActionThreads(VinylModel vinylModel, String threadName) {
        this.vinylModel = vinylModel;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            try {
                Vinyl selectedVinyl = getRandomVinyl();
                int action = random.nextInt(3);

                switch (action) {
                    case 0:
                        vinylModel.reserveVinyl(selectedVinyl);
                        break;
                    case 1:
                        vinylModel.borrowVinyl(selectedVinyl);
                        break;
                    case 2:
                        vinylModel.returnVinyl(selectedVinyl);
                        break;
                }


                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }

    private Vinyl getRandomVinyl() {
        return vinylModel.getAllVinyls().get(new Random().nextInt(vinylModel.getAllVinyls().size()));
    }
}
