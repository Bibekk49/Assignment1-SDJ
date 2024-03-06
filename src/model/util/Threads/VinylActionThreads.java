package model.util.Threads;

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
        logger.log(Level.INFO, "{0} started.", threadName);

        for (int i = 0; i < 5; i++) { // Perform actions for a certain number of iterations
            try {
                Vinyl selectedVinyl = getRandomVinyl();
                int action = random.nextInt(3); // 0: reserve, 1: borrow, 2: return

                switch (action) {
                    case 0:
                        logger.log(Level.INFO, "{0} is reserving Vinyl: {1}", new Object[]{threadName, selectedVinyl.getTitle()});
                        vinylModel.reserveVinyl(selectedVinyl);
                        break;
                    case 1:
                        logger.log(Level.INFO, "{0} is performing action: {1}", new Object[]{threadName, action});
                        logger.log(Level.INFO, "{0} is borrowing Vinyl: {1}", new Object[]{threadName, selectedVinyl.getTitle()});
                        vinylModel.borrowVinyl(selectedVinyl);
                        break;
                    case 2:
                        logger.log(Level.INFO, "{0} is returning Vinyl: {1}", new Object[]{threadName, selectedVinyl.getTitle()});
                        vinylModel.returnVinyl(selectedVinyl);
                        break;
                }

                logger.log(Level.INFO, "{0} finished.", threadName);

                Thread.sleep(2000); // Sleep for 2 seconds between actions
            } catch (InterruptedException e) {
                logger.log(Level.SEVERE, "Thread interrupted exception", e);
            }
        }
    }

    private Vinyl getRandomVinyl() {
        // Get a random Vinyl from the model (replace this with your logic)
        return vinylModel.getAllVinyls().get(new Random().nextInt(vinylModel.getAllVinyls().size()));
    }
}
